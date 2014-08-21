package org.ferris.ejbrace.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer
                = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");

        try {
            writer.printf("<p>Hello Account!</p>\n"); 
            
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
            writer.printf("<p>time=\"%s\"</p>\n", sdf.format(Calendar.getInstance().getTime()));
            
            writer.printf("<p>lookup=\"%s\"</p>\n", redLookup);
            
            writer.printf("<p>accountService variable = %s</p>\n", accountService.toString());
            
            Random r = new Random();
            int id = r.nextInt(1000) + 1;
            
            Account account
                    = accountService.findAccount(String.format("%d", id));

            System.out.println("AccountServlet [" + account.getId() + "] !!");

            writer.printf("<p>account.getId() = %s</p>\n", account.getId());

        } catch (Throwable t) {
            t.printStackTrace(writer);
        }

        writer.println("</body>");
        writer.println("</html>");
    }
}
