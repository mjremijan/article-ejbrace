package org.ferris.cassett;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ferris.ejb.account.AccountService;
import org.ferris.model.account.Account;

@WebServlet(name="AccountServlet", urlPatterns= {"/account"})
public class AccountServlet extends HttpServlet
{
	private static final long serialVersionUID = 1928524322445296653L;
	
    // Remember, this is a 
    //   
    //  !! LOCAL JNDI LOOKUP NAME !!
    //
    // and this lookup name is only 
    // used by this WAR.  How this 
    // local lookup name maps to a 
    // real EJB instance is configured
    // in web.xml and sun-web.xml
	@EJB(lookup="java:comp/env/ejb/Sam")
        //@EJB(name="ejb/Sam")
	AccountService accountService;
	
    @Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		PrintWriter writer
			= response.getWriter();
		writer.println("<html>");
			writer.println("<body>");
			
				try {
					Account account
						= accountService.findAccount(123);
					writer.println("<p>Hello Account!</p>");
                                        //writer.println("<p>name=\"ejb/Sam\"</p>");
                                        writer.println("<p>name=\"java:comp/env/ejb/Sam\"</p>");
					writer.println(String.format("<p>%s</p>",account.toString()));
				}
				catch (Throwable t)
				{
					t.printStackTrace(writer);
				}
		
		
			writer.println("</body>");
		writer.println("</html>");
		
	}
}
