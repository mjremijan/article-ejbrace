package org.ferris.ejbrace.web.ejb;

import java.util.List;
import javax.ejb.Local;
import org.ferris.ejbrace.model.Account;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Local
public interface AccountServiceLocal {
    List<Account> getAccounts();
}
