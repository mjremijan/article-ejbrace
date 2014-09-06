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
import javax.xml.ws.BindingProvider;

import org.ferris.ejbrace.servlet.Account;
import org.ferris.ejbrace.servlet.AccountServiceJaxWs;
import org.ferris.ejbrace.servlet.AccountServiceJaxWsService;

/**
 *
 * @author Tim Taylor tim@taylorhome.org
 */
@WebServlet("/CallToJaxWs")
public class CallToJaxWs extends HttpServlet 
{
    class ByJaxWs extends ServiceTemplateMethod<Account, JaxbAccountHtmlFormatter>
    {
        private String url;
        public ByJaxWs() {
            url = "http://remijan-server:8080/ejbrace-service/AccountServiceJaxWsService";
            super(new JaxbAccountHtmlFormatter());
            url = "http://tim-laptop:8080/ejbrace-service/AccountServiceJaxWsService";
        }
        
        @Override
        public List<Account> getAccounts() {
            AccountServiceJaxWsService service = new AccountServiceJaxWsService();
            AccountServiceJaxWs port = service.getAccountServiceJaxWsPort();
            
            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
            
            List<Account> myAccounts = port.getAccount();
            return myAccounts;
        }

        @Override
        public String getName() {
            return CallToJaxWs.class.getName();
        }
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        ByJaxWs byJaxWs = new ByJaxWs();
        byJaxWs.service(response);
    }
}
