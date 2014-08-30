package org.ferris.ejbrace.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.model.AccountSingleton;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Stateless
public class AccountServiceEjb implements AccountService {

    @Override
    public List<Account> getAccounts() {
        System.out.println("ENTER EJB getAccounts()");
        return AccountSingleton.getAccounts();
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public List<Account> getAccountsTransactionNever() {
        System.out.println("ENTER EJB getAccounts()");
        return AccountSingleton.getAccounts();
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Account> getAccountsTransactionSupports() {
        System.out.println("ENTER EJB getAccounts()");
        return AccountSingleton.getAccounts();
    }

}
