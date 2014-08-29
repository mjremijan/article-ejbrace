package org.ferris.ejbrace.model;

import java.io.Serializable;

public class Phone implements Serializable {
    private static final long serialVersionUID = 928034759823745091L;
    private final PhoneType type;
    private final String number;
    private final String id;
    private String description;

    public Phone(final String id, final PhoneType type, final String number) {
        super();
        this.id = id;
        this.type = type;
        this.number = number;
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
        final Phone other = (Phone) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return this.id;
    }

    public String getNumber() {
        return number;
    }

    public PhoneType getType() {
        return type;
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

    public void setDescription(final String description) {
        this.description = description;
    }

}
