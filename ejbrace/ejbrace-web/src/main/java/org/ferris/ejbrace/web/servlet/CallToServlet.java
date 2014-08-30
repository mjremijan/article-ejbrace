package org.ferris.ejbrace.web.servlet;

import org.ferris.ejbrace.web.net.http.HttpClientFascade;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.ferris.ejbrace.model.Account;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@WebServlet("/CallToServlet")
public class CallToServlet extends HttpServlet 
{
    class ByServlet extends ServiceTemplateMethod 
    {
        private URL url;
        public ByServlet() throws MalformedURLException {
            url = new URL("http://remijan-server:8080/ejbrace-service/AccountServiceServlet");
        }
        
        @Override
        public List<Account> getAccounts() {
            try (HttpClientFascade hcf = new HttpClientFascade(url);) {
                List<Account> myAccounts = (List<Account>) hcf.get().getResponseAsObject();
                return myAccounts;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String getName() {
            return CallToServlet.class.getName();
        }
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        ByServlet byServlet = new ByServlet();
        byServlet.service(response);
    }
}
