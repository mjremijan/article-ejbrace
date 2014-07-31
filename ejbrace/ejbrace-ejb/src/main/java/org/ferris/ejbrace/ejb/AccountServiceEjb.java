package org.ferris.ejbrace.ejb;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.ferris.ejbrace.model.Account;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Stateless
public class AccountServiceEjb implements AccountService {

    @Override
    public Account findAccount(String id) {
        throw new EJBException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
