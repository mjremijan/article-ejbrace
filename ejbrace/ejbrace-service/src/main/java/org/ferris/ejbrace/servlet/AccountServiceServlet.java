package org.ferris.ejbrace.servlet;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.ferris.ejbrace.model.AccountSingleton;


@WebServlet("/AccountServiceServlet")
public class AccountServiceServlet extends HttpServlet 
{
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("ENTER servlet service()");
        response.setContentType("application/x-java-serialized-object");
        final OutputStream os = response.getOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(AccountSingleton.getAccounts());
    }

}
