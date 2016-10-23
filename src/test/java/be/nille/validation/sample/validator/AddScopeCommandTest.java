/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validator;

import be.nille.validation.sample.validator.api.ValidationMessage;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
public class AddScopeCommandTest {
    
    @Test
    public void addScope(){
        AddScopeCommand command = new AddScopeCommand();
        command.setClientId("clientid12");
        command.setScope("read");
        
        List<ValidationMessage> messages = command.validate();
        assertTrue(messages.isEmpty());
    }
    
    @Test
    public void addScopeWithClientIdTooShort(){
        AddScopeCommand command = new AddScopeCommand();
        command.setClientId("cli");
        command.setScope("read");
        
        List<ValidationMessage> messages = command.validate();
        assertFalse(messages.isEmpty());
    }
    
    @Test
    public void addScopeWithoutClientId(){
        AddScopeCommand command = new AddScopeCommand();
       
        command.setScope("read");
        
        List<ValidationMessage> messages = command.validate();
        assertFalse(messages.isEmpty());
    }
    
    @Test
    public void addScopeWithoutScope(){
        AddScopeCommand command = new AddScopeCommand();
        command.setClientId("clientid12");
        List<ValidationMessage> messages = command.validate();
        assertFalse(messages.isEmpty());
    } 
    
}
