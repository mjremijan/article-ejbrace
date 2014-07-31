package org.ferris.ejbrace.ejb;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
@Stateless
//@EJB(name="java:global/planets/mercury", beanInterface=AccountService.class)
public class AccountServiceEjb implements AccountService {

    @Override
    public String findAccount(String id) {
        throw new EJBException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
