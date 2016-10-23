/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validation.rule;

import be.nille.validation.sample.validation.rule.ClientSecretRule;
import be.nille.validation.sample.validation.rule.ClientIdRule;
import be.nille.validation.sample.validation.api.ValidationRule;
import be.nille.validation.sample.service.RegisterClientData;
import be.nille.validation.sample.validation.api.ValidationEngine;
import be.nille.validation.sample.validation.api.ValidationException;
import be.nille.validation.sample.validation.api.ValidationMessage;
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
    public void validateRules() {
        RegisterClientData clientCommand = new RegisterClientData();
        clientCommand.setClientId("cli");
        //clientCommand.setClientSecret("clientSecret");

        ValidationEngine engine = new ValidationEngine();
        engine.addRule(new ClientIdRule(clientCommand.getClientId()));
        engine.addRule(new ClientSecretRule(clientCommand.getClientSecret()));

        try {
            engine.fireRules();
        } catch (ValidationException ex) {
            for (ValidationMessage message : ex.getMessages()) {
                log.debug(message.toString());
            }
        }

        
    }

}
