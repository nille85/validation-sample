/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.model.client;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@Setter
public class Scope {
    
    private String name;
    private String description;
    
    public Scope(final String name){
        this.name = name;
    }
    
}
