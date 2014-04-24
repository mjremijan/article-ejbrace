package org.ejbrace;

import javax.jws.WebService;

@WebService
public class EjbRaceJaxwsWebService {
    public String echo(String message) {
        return "I got: " + message;
    }
}
