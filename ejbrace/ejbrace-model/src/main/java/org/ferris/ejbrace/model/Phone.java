package org.ferris.ejbrace.model;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Phone implements Serializable {
    private static final long serialVersionUID = 928034759823745091L;
    private PhoneType type;
    private String number;
    private String id;
    private String description;
   
    public Phone() {}

    public Phone(String id, PhoneType type, String number) {
        this(id, type, number, null);
    }

    public Phone(String id, PhoneType type, String number, String description) {
        this.type = type;
        this.number = number;
        this.id = id;
        this.description = description;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Phone other = (Phone) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
