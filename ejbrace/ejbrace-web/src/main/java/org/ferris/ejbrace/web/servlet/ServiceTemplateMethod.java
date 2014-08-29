package org.ferris.ejbrace.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.web.util.Stopwatch;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public abstract class ServiceTemplateMethod {

    public void service(ServletResponse response) throws ServletException, IOException 
    {
        Stopwatch sw = new Stopwatch();
        sw.start();
        for (int i = 0; i < 100_000; i++) {
            getAccount();
        }
        sw.stop();

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println(String.format("<body style=\"%s\">", "background-color: rgb(191,191,191);"));
        writer.println(String.format("<h1>%s</h1>", getName()));
        writer.println(String.format("<p>Time: \"%s\"</p>", new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(Calendar.getInstance().getTime())));
        writer.println(String.format("<table>"));
        writer.println(String.format("<tr>"));
        {
            writer.println(String.format("<td>Number of calls:</td>"));
            writer.println(String.format("<td>%d</td>", sw.size()));
        }
        writer.println(String.format("</tr>"));
        writer.println(String.format("<tr>"));
        {
            writer.println(String.format("<td>Total time:</td>"));
            writer.println(String.format("<td>%d</td>", sw.getTotalTime()));
        }
        writer.println(String.format("</tr>"));
        writer.println(String.format("<tr>"));
        {
            writer.println(String.format("<td>Average time:</td>"));
            writer.println(String.format("<td>%.3f</td>", sw.getAverageTime()));
        }
        writer.println(String.format("</tr>"));
        writer.println(String.format("<tr>"));
        {
            writer.println(String.format("<td>Min time:</td>"));
            writer.println(String.format("<td>%.3f</td>", sw.getMinTime()));
        }
        writer.println(String.format("</tr>"));
        writer.println(String.format("<tr>"));
        {
            writer.println(String.format("<td>Max time:</td>"));
            writer.println(String.format("<td>%.3f</td>", sw.getMaxTime()));
        }
        writer.println(String.format("</tr>"));
        writer.println(String.format("</table>"));
        writer.println("</body>");
        writer.println("</html>");
    }
    
    public abstract Account getAccount();
    public abstract String getName();
}
