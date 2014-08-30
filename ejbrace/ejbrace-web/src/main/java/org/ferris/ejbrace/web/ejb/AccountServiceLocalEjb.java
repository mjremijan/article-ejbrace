package org.ferris.ejbrace.web.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.model.AccountSingleton;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Stateless
public class AccountServiceLocalEjb implements AccountServiceLocal {

    @Override
    public List<Account> getAccounts() {
        System.out.println("ENTER EJB getAccounts()");
        return AccountSingleton.getAccounts();
    }

}
