package org.ferris.ejbrace.ejb;

import java.util.List;
import javax.ejb.Remote;
import org.ferris.ejbrace.model.Account;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Remote
public interface AccountService {
    List<Account> getAccounts();
    List<Account> getAccountsTransactionNever();
    List<Account> getAccountsTransactionSupports();
}
