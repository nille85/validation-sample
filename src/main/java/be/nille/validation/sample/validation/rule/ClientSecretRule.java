/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validation.rule;

import be.nille.validation.sample.validation.api.ValidationRule;
import javax.validation.constraints.NotNull;
import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class ClientSecretRule extends ValidationRule {
    
    @NotNull(message = "clientSecret.required")
    private final String clientSecret;
    
    public ClientSecretRule(final String clientSecret){
        this.clientSecret = clientSecret;
    }
    
}
