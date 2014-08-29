package org.ferris.ejbrace.web.net.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class HttpClientFascade implements AutoCloseable {
    public interface WriteResponseCallback {
        void writtenSoFar(long totalBytesWritten);
    }

    private URL url;
    private HttpGet httpGet;
    private HttpResponse response;

    private CloseableHttpClient httpclient;

    public HttpClientFascade(URL url) {
        this.url = url;
        this.httpclient = HttpClientBuilder.create().build();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.AutoCloseable#close()
     */
    @Override
    public void close() throws Exception {
        response = null;
        try {
            if (httpGet != null) {
                httpGet.abort();
            }
        } catch (Throwable ignore) {
        }
        try {
            httpclient.close();
        } catch (Throwable ignore) {
        }
    }

    /**
     * GET the request
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws URISyntaxException
     */
    public HttpClientFascade get() throws ClientProtocolException, IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder(getUri());
        URI requestUri = builder.build();
        httpGet = new HttpGet(requestUri);
        response = httpclient.execute(httpGet);
        return this;
    }

    /**
     * Get response as string
     * 
     * @throws IOException
     * @throws IllegalStateException
     */
    public Object getResponseAsObject() throws IllegalStateException, IOException {
        Object retval = null;
        if (response != null) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {

                try (InputStream is = entity.getContent(); ObjectInputStream ois = new ObjectInputStream(is);) {
                    retval = ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }
        return retval;
    }

    /**
     * Return if the get() operation was successful
     */
    public boolean isSuccessful() {
        boolean retval = false;
        if (response != null) {
            int statusCode = response.getStatusLine().getStatusCode();
            retval = (statusCode == 200);
        }
        return retval;
    }

    private URI getUri() throws URISyntaxException {
        return url.toURI();
    }
}
