/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validator;

import be.nille.validation.sample.validator.api.Validatable;
import be.nille.validation.sample.validator.api.ValidationEngine;
import be.nille.validation.sample.validator.api.ValidationMessage;
import be.nille.validation.sample.validator.rule.ClientIdRule;
import be.nille.validation.sample.validator.rule.ClientSecretRule;
import be.nille.validation.sample.validator.rule.ScopeRule;
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
public class AddScopeCommand implements Validatable {
   
    private String clientId; 
    private String scope;

    @Override
    public List<ValidationMessage> validate() {
        ValidationEngine engine = new ValidationEngine();
        engine.addRule(new ClientIdRule(clientId));
        engine.addRule(new ScopeRule(scope));
        return engine.fireRules();
    }
    
}
