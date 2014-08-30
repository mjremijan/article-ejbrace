package org.ferris.ejbrace.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.ferris.ejbrace.ejb.AccountService;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.web.ejb.AccountServiceLocal;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@WebServlet("/CallToEjbLocal")
public class CallToEjbLocal extends HttpServlet 
{
    @EJB
    AccountServiceLocal accountService;
    
    class ByEjb extends ServiceTemplateMethod 
    {
        @Override
        public List<Account> getAccounts() {
            return accountService.getAccounts();
        }

        @Override
        public String getName() {
            return CallToEjbLocal.class.getName();
        }
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        ByEjb byEjb = new ByEjb();
        byEjb.service(response);
    }
}
