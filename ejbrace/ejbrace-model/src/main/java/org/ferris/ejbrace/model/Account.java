package org.ferris.ejbrace.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {

    private static final long serialVersionUID = 1769869876986L;

    private final String id;
    private String email;
    private final List<Address> addresses;
    private final Map<String, Phone> phones;

    public Account(final String id) {
        this.id = id;
        this.addresses = new LinkedList<>();
        this.phones = new HashMap<>();
    }

    public void addAddress(final Address address) {
        addresses.add(address);
    }

    public void addPhone(final Phone phone) {
        this.phones.put(phone.getId(), phone);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (addresses == null) {
            if (other.addresses != null) {
                return false;
            }
        } else if (!addresses.equals(other.addresses)) {
            return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (phones == null) {
            if (other.phones != null) {
                return false;
            }
        } else if (!phones.equals(other.phones)) {
            return false;
        }
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((phones == null) ? 0 : phones.hashCode());
        return result;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
