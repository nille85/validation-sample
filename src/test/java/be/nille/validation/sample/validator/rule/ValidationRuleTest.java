/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validator.rule;

import be.nille.validation.sample.validator.api.ValidationRule;
import be.nille.validation.sample.validator.AddClientCommand;
import be.nille.validation.sample.validator.api.ValidationEngine;
import be.nille.validation.sample.validator.api.ValidationMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class ValidationRuleTest {
    
    @Test
    public void validateRules(){
        AddClientCommand clientCommand = new AddClientCommand();
        clientCommand.setClientId("cli");
        //clientCommand.setClientSecret("clientSecret");
        
        ValidationEngine engine = new ValidationEngine();
        engine.addRule(new ClientIdRule(clientCommand.getClientId()));
        engine.addRule(new ClientSecretRule(clientCommand.getClientSecret()));
        
        List<ValidationMessage> validationMessages = engine.fireRules();
       
        for(ValidationMessage message : validationMessages){
            log.debug(message.toString());
        }
    }
    
}
