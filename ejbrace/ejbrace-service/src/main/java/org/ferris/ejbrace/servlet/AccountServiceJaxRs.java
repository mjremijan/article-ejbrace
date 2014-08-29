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

//    public int itr = 5;
//    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
//    @Path("get")
//    public String get() {
//        return "Hello World " + itr;
//    }
//    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
//    @Path("foo")
//    public FooBean foo() {
//        System.out.println("FooBean " + itr);
//        FooBean fb = new FooBean();
//        fb.setName(new java.util.Date().toString());
//        return fb;
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
    @Path("Get")
    public Account getAccount() {
        System.out.println("ENTER getAccount()");
        Account a = AccountSingleton.getAccount();
        System.out.println("a= " + ToStringBuilder.reflectionToString(a));
        return a;
    }   
}
