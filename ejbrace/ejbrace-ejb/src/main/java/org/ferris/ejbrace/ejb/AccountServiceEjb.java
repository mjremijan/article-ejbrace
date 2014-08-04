package org.ferris.ejbrace.ejb;

import javax.ejb.Stateless;
import org.ferris.ejbrace.model.Account;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Stateless
//@EJB(name="java:global/planets/mercury", beanInterface=AccountService.class)
public class AccountServiceEjb implements AccountService {

    @Override
    public Account findAccount(String id) {
        System.out.println("AccountServiceEjb [" + id + "] !!");
        return new Account(String.format("0000%s", id));
    }

}
