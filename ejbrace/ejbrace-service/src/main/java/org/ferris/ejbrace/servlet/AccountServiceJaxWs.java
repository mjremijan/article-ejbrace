package org.ferris.ejbrace.servlet;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.model.AccountSingleton;


@WebService
public class AccountServiceJaxWs {

    @WebMethod
    public List<Account> getAccount() {
        System.out.println("ENTER JaxWs getAccounts()");
        return AccountSingleton.getAccounts();
    }
}
