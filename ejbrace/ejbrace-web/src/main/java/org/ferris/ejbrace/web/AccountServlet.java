package org.ferris.ejbrace.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import org.ferris.ejbrace.ejb.AccountService;
import org.ferris.ejbrace.model.Account;

@WebServlet(name = "AccountServlet", urlPatterns = {"/account"})
public class AccountServlet extends HttpServlet {

    private static final long serialVersionUID = 1928524322445296653L;
    private static final String redLookup = "java:comp/env/ejb/Red";
    // Remember, this is a 
    //   
    //  !! LOCAL JNDI LOOKUP NAME !!
    //
    // and this lookup name is only used by this WAR.  How this 
    // local lookup name maps to a real EJB instance is configured
    // in web.xml and glassfish-web.xml
    @EJB(lookup = redLookup)
    AccountService accountService;

    @Override
    @Path("variable")
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer
                = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");

        try {
            Account account
                    = accountService.findAccount("123");
            writer.printf("<p>Hello Account!</p>\n");           
            writer.printf("<p>name=\"%s\"</p>\n", redLookup);
            writer.printf("<p>accountService variable = %s</p>\n", accountService.toString());
        } catch (Throwable t) {
            t.printStackTrace(writer);
        }

        writer.println("</body>");
        writer.println("</html>");
    }
}
