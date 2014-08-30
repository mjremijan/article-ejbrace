package org.ferris.ejbrace.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.web.util.Stopwatch;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public abstract class ServiceTemplateMethod 
{

    public void service(ServletResponse response) throws ServletException, IOException 
    {
        Integer numberOfCalls 
            = getNumberOfCalls();
        
        Stopwatch sw 
            = new Stopwatch();
        
        List<Account> accounts 
            = null;
        
        for (int i = 1, imax=numberOfCalls.intValue(); i <= imax; i++) {
            System.out.printf("Make call %d of %d", i, imax);
            sw.start();
            accounts = getAccounts();
            sw.stop();
        }

        print(response, sw, accounts);
    }
    
    private final void print(ServletResponse response, Stopwatch sw, List<Account> accounts) throws IOException 
    {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println(String.format("<body style=\"%s\">", "background-color: rgb(191,191,191);"));
        writer.println(String.format("<h1>%s</h1>", getName()));
        writer.println(String.format("<p>Time: \"%s\"</p>", new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(Calendar.getInstance().getTime())));
        writer.println("<p>Values are in milliseconds.</p>");
        
        writer.println(String.format("<table>"));
        writer.println(String.format("<tr>"));
        {
            //
            // Lables
            //
            writer.println(String.format("<td>"));
            {
                writer.println(String.format("<table>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>Number of calls:</td>"));
                }
                writer.println(String.format("</tr>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>Total time:</td>"));
                }
                writer.println(String.format("</tr>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>Average time:</td>"));
                }
                writer.println(String.format("</tr>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>Min time:</td>"));
                }
                writer.println(String.format("</tr>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>Max time:</td>"));
                }
                writer.println(String.format("</tr>"));        
                writer.println(String.format("</table>"));
            }
            writer.println(String.format("</td>"));
            
            //
            // Values
            //
            writer.println(String.format("<td>"));
            {
                writer.println(String.format("<table>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>%d</td>", sw.size()));
                }
                writer.println(String.format("</tr>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>%d</td>", sw.getTotalTime()));
                }
                writer.println(String.format("</tr>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>%.3f</td>", sw.getAverageTime()));
                }
                writer.println(String.format("</tr>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>%d</td>", sw.getMinTime()));
                }
                writer.println(String.format("</tr>"));
                writer.println(String.format("<tr>"));
                {
                    writer.println(String.format("<td>%d</td>", sw.getMaxTime()));
                }
                writer.println(String.format("</tr>"));        
                writer.println(String.format("</table>"));                
            }
            writer.println(String.format("</td>"));
        }        
        writer.println(String.format("</tr>"));        
        writer.println(String.format("</table>"));
        
        
        
        writer.println(String.format("<p><b>Last List&lt;Account&gt;:</b></p>"));
        writer.println(String.format("<p>size = %d</p>", accounts.size()));
        writer.println(String.format("<p>get(0) = %s</p>", ToStringBuilder.reflectionToString(accounts.get(0))));        
        
        writer.println("</body>");
        writer.println("</html>");
    }
    
    
    private final Integer getNumberOfCalls()
    {
        Integer numberOfCalls = null;
        if (numberOfCalls == null) {
            try {
              InitialContext ic = new InitialContext();
              numberOfCalls = (Integer) ic.lookup("numberOfCalls");
            } catch (NamingException e) {
                System.out.printf("NUMBER_OF_CALLS: failed Integer lookup");
            }
        }
        if (numberOfCalls == null) {
            try {
              InitialContext ic = new InitialContext();
              String s = (String) ic.lookup("numberOfCalls");
              numberOfCalls = Integer.parseInt(s);
            } catch (NamingException e) {
                System.out.printf("NUMBER_OF_CALLS: failed String lookup");
            }
        }
        if (numberOfCalls == null) {
            System.out.printf("NUMBER_OF_CALLS: default!");
            numberOfCalls = 100;
        }
        
        System.out.printf("numberOfCalls = %d", numberOfCalls);
        return numberOfCalls;
    }
    
    public abstract List<Account> getAccounts();
    public abstract String getName();
}
