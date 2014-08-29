package org.ferris.ejbrace.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 14987238570707L;

    private String id;
    private List<Address> addresses;
    private Map<String, Phone> phones;

    public Account() {
        addresses = new LinkedList<>();
        phones = new HashMap<>();
    }
    
    public Account(String id) {
        this();
        this.id = id;
    }
       
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
     
    public void addAddress(Address a) {
        this.addresses.add(a);
    }

    public Map<String, Phone> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, Phone> phones) {
        this.phones = phones;
    }
    
    public void addPhone(Phone p) {
        this.phones.put(p.getId(), p);
    }
 }
