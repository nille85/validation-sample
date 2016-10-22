/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.service;

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
public class AddClientValidatorTest {
    
    private static  Validator validator;
    
    @Before
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void createClient(){
        AddClientCommand command = new AddClientCommand();
        command.setClientId("clientid");
        command.setClientSecret("secret");
        Set<ConstraintViolation<AddClientCommand>> constraints = validator.validate(command);
        assertTrue(constraints.isEmpty());
        
    }
    
    @Test
    public void createClientWithoutClientId(){
        AddClientCommand command = new AddClientCommand();
      
        command.setClientSecret("secret");
        Set<ConstraintViolation<AddClientCommand>> constraints = validator.validate(command);
        assertFalse(constraints.isEmpty());
        
    }
}
