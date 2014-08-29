package org.ferris.ejbrace.servlet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.ferris.ejbrace.model.Account;
import org.ferris.ejbrace.model.AccountSingleton;


@Path("/AccountServiceJaxRs")
public class AccountServiceJaxRs {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
    public Account getAccount() {
        return AccountSingleton.getAccount();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
//    public Response getAccountResponse() {
//        return Response.ok(AccountSingleton.getAccount(), MediaType.APPLICATION_JSON).build();
//    }
}
