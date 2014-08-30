package org.ferris.ejbrace.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.ferris.ejbrace.model.Account;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@WebServlet("/CallToJaxRs")
public class CallToJaxRs extends HttpServlet 
{
    class ByJaxRs extends ServiceTemplateMethod 
    {
        private String url;
        public ByJaxRs() {
            url = "http://remijan-server:8080/ejbrace-service/resources/AccountServiceJaxRs/Get";
        }
        
        @Override
        public List<Account> getAccounts() {
            Client client = ClientBuilder.newClient();
            WebTarget myResource = client.target(url);
            Builder myBuilder = myResource.request(MediaType.APPLICATION_JSON);
            List<Account> myAccounts = myBuilder.get(new GenericType<List<Account>>(){});
            client.close();
            return myAccounts;
        }

        @Override
        public String getName() {
            return CallToJaxRs.class.getName();
        }
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        ByJaxRs byJaxRs = new ByJaxRs();
        byJaxRs.service(response);
    }
}
