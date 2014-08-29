package org.ferris.ejbrace.ejb;

import javax.ejb.Remote;
import org.ferris.ejbrace.model.Account;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Remote
public interface AccountService {
    Account getAccount();
}
