package org.ferris.ejbrace.model;

import java.io.Serializable;
/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 13984327509734L;
    private String address1;

    private String address2;

    private String city;
    private String state;
    private String zipCode;
    private final String id;

    public Address(final String id) {
        this.id = id;
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
        final Address other = (Address) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getId() {
        return this.id;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public void setAddress1(final String address1) {
        this.address1 = address1;
    }

    public void setAddress2(final String address2) {
        this.address2 = address2;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

}
