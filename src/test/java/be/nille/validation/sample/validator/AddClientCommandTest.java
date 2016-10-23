/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validator;

import be.nille.validation.sample.validator.api.ValidationMessage;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class AddClientCommandTest {
    
    
    
 
    @Test
    public void createClient(){
        AddClientCommand command = new AddClientCommand();
        command.setClientId("clientid");
        command.setClientSecret("secret");
        List<ValidationMessage> messages = command.validate();
        assertTrue(messages.isEmpty());
        
    }
    
    @Test
    public void createClientWithoutClientId(){
        AddClientCommand command = new AddClientCommand();
        command.setClientSecret("secret");
        List<ValidationMessage> messages = command.validate();
        assertFalse(messages.isEmpty());
        printMessages(messages);
        
    }
    
    @Test
    public void createClientWithoutClientIdToShort(){
        AddClientCommand command = new AddClientCommand();
        command.setClientId("id");
        command.setClientSecret("secret");
        List<ValidationMessage> messages = command.validate();
        assertFalse(messages.isEmpty());
        printMessages(messages);
        
    }
    
    private void printMessages(List<ValidationMessage> messages){
        for(ValidationMessage message : messages){
            log.debug(message.toString());
        }
    }
}
