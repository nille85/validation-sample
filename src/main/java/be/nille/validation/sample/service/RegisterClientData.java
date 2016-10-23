/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.service;

import be.nille.validation.sample.model.client.Client;
import be.nille.validation.sample.validation.api.ValidationEngine;
import be.nille.validation.sample.validation.rule.ClientIdRule;
import be.nille.validation.sample.validation.rule.ClientSecretRule;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@Setter
public class RegisterClientData {
    
  
    private String clientId;
    private String clientSecret;
    
    
    public Client toClient(){
         return new Client("clientid", "secret");      
    }

    
    public void validate() {
        ValidationEngine engine = new ValidationEngine();
        engine.addObject(new ClientIdRule(clientId));
        engine.addObject(new ClientSecretRule(clientSecret));
        engine.validate();
    }
    
   
    
    
}
