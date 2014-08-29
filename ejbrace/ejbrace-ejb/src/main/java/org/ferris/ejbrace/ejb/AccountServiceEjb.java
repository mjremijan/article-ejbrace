package org.ferris.ejbrace.ejb;

import javax.ejb.Stateless;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.model.AccountSingleton;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Stateless
public class AccountServiceEjb implements AccountService {

    @Override
    public Account getAccount() {
        System.out.println("getAccount()");
        return AccountSingleton.getAccount();
    }

}
