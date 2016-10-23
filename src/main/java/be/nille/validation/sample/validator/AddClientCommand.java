/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validator;

import be.nille.validation.sample.model.client.Client;
import be.nille.validation.sample.validator.api.Validatable;
import be.nille.validation.sample.validator.api.ValidationEngine;
import be.nille.validation.sample.validator.api.ValidationMessage;
import be.nille.validation.sample.validator.rule.ClientIdRule;
import be.nille.validation.sample.validator.rule.ClientSecretRule;
import be.nille.validation.sample.validator.api.ValidationRule;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@Setter
public class AddClientCommand implements Validatable {
    
  
    private String clientId;
    private String clientSecret;
    
    
    public Client toClient(){
         return new Client("clientid", "secret");      
    }

    @Override
    public List<ValidationMessage> validate() {
        ValidationEngine engine = new ValidationEngine();
        engine.addRule(new ClientIdRule(clientId));
        engine.addRule(new ClientSecretRule(clientSecret));
        return engine.fireRules();
    }
    
   
    
    
}
