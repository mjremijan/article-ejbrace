package org.ferris.ejbrace.servlet;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.model.AccountSingleton;


@Path("AccountServiceJaxRs")
public class AccountServiceJaxRs {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
    @Path("Get")
    public List<Account> getAccount() {
        System.out.println("ENTER JaxRs getAccounts()");
        return AccountSingleton.getAccounts();
    }   
}
