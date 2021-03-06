/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validation.rule;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class ClientIdRule {
    
    @NotNull(message = "clientId.required")
    @Size(min = 5, message = "clientId.size")
    private final String clientId;
    
    public ClientIdRule(final String clientId){
        this.clientId = clientId;
    }
    
   

   

    
    
}
