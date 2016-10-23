/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validation.command;

import be.nille.validation.sample.service.AddScopeData;
import be.nille.validation.sample.validation.api.ValidationException;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
public class AddScopeCommandTest {

    @Test
    public void addScope() {
        AddScopeData command = new AddScopeData();
        command.setClientId("clientid12");
        command.setScope("read");

        command.validate();
    }

    @Test(expected = ValidationException.class)
    public void addScopeWithClientIdTooShort() {
        AddScopeData command = new AddScopeData();
        command.setClientId("cli");
        command.setScope("read");
        command.validate();

    }

    @Test(expected = ValidationException.class)
    public void addScopeWithoutClientId() {
        AddScopeData command = new AddScopeData();

        command.setScope("read");

        command.validate();

    }

    @Test(expected = ValidationException.class)
    public void addScopeWithoutScope() {
        AddScopeData command = new AddScopeData();
        command.setClientId("clientid12");
        command.validate();
    }

}
