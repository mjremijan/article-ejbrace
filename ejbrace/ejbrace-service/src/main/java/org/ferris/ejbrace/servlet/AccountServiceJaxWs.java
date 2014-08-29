package org.ferris.ejbrace.servlet;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.model.AccountSingleton;


@WebService
public class AccountServiceJaxWs {

    @WebMethod
    public Account getAccount() {
        System.out.println("ENTER JaxWs getAccount()");
        return AccountSingleton.getAccount();
    }
}
