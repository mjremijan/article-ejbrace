package org.ferris.ejbrace.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.web.util.Stopwatch;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@WebServlet("/ServletCallToJaxRs")
public class ServletCallToJaxRs extends HttpServlet 
{
    class ByJaxRs extends ServiceTemplateMethod 
    {
        private String url;
        public ByJaxRs() {
            url = "http://remijan-server:8080/something/AccountServiceJaxRs";
        }
        
        @Override
        public Account getAccount() {
            Client client = ClientBuilder.newClient();
            WebTarget myResource = client.target(url);
            Builder myBuilder = myResource.request(MediaType.APPLICATION_JSON);
            Account myAccount = myBuilder.get(Account.class);
            client.close();
            return myAccount;
        }

        @Override
        public String getName() {
            return ServletCallToJaxRs.class.getName();
        }
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        ByJaxRs byJaxRs = new ByJaxRs();
        byJaxRs.service(response);
    }
}
