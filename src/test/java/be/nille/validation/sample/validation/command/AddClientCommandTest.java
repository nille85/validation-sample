/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validation.command;

import be.nille.validation.sample.service.RegisterClientData;
import be.nille.validation.sample.validation.api.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class AddClientCommandTest {
    
    
    
 
    @Test
    public void createClient(){
        RegisterClientData command = new RegisterClientData();
        command.setClientId("clientid");
        command.setClientSecret("secret");
        command.validate();
  
    }
    
    @Test(expected = ValidationException.class)
    public void createClientWithoutClientId(){
        RegisterClientData command = new RegisterClientData();
        command.setClientSecret("secret");
        command.validate();
       
        
    }
    
    @Test(expected = ValidationException.class)
    public void createClientWithoutClientIdToShort(){
        RegisterClientData command = new RegisterClientData();
        command.setClientId("id");
        command.setClientSecret("secret");
        command.validate();
    }
    
}
