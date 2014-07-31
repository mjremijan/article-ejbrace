package org.ferris.ejbrace.ejb;

import javax.ejb.Remote;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Remote
public interface AccountService {
    String findAccount(String id);
}
