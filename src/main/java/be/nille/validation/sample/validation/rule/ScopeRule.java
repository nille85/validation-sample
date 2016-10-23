/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validation.rule;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Niels Holvoet
 */
public class ScopeRule{
    
    @NotNull(message = "scope.required")
    private final String scope;
    
    public ScopeRule(final String scope){
        this.scope = scope;
    }
    
}
