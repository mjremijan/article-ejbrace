package org.ferris.ejbrace.servlet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.model.AccountSingleton;


@Path("AccountServiceJaxRs")
public class AccountServiceJaxRs {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
    @Path("Get")
    public Account getAccount() {
        System.out.println("ENTER JaxRs getAccount()");
        return AccountSingleton.getAccount();
    }   
}
