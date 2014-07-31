/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ferris.ejbrace.model;

import java.io.Serializable;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
public class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Account(String id) {
        this.id = id;
    }
    
    private String id;
    public String getId() { return id; }
    
}
