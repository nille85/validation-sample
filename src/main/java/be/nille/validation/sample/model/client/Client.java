/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.model.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class Client {
    
    private final String id;
    @Setter
    private String secret;
    private List<Scope> scopes;
    
    public Client(final String id, final String secret){
        this.id = id;
        this.secret = secret;
        scopes = new ArrayList<>();
    }
    
    public void addScope(final Scope scope){
        scopes.add(scope);
    }
    
    public void removeScope(final String name){
        this.scopes = scopes.stream()
                .filter(scope -> !scope.getName().equals(name))
                .collect(Collectors.toList());
        
    }
    
}
