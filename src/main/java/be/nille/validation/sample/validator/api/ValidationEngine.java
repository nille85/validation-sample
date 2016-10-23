/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validator.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;

/**
 *
 * @author Niels Holvoet
 */
public class ValidationEngine {
    
    List<ValidationRule> rules;
    
    public ValidationEngine(){
        rules = new ArrayList<>();
    }
    
    public void addRule(ValidationRule rule){
        rules.add(rule);
    }
    
    public List<ValidationMessage> fireRules(){
        List<ValidationMessage> allValidationMessages = new ArrayList<>();
        for(ValidationRule rule : rules){
            Set<ConstraintViolation<ValidationRule>> constraints = rule.validate();
            List<ValidationMessage> validationMessages = getValidationMessagesFromConstraints(constraints);
            allValidationMessages.addAll(validationMessages);
        }
        return allValidationMessages;
    }
    
    private List<ValidationMessage> getValidationMessagesFromConstraints( Set<ConstraintViolation<ValidationRule>> constraints){
        List<ValidationMessage> validationMessages = new ArrayList<>();
        for(ConstraintViolation<ValidationRule> constraint : constraints){
            ValidationMessage validationMessage = new ValidationMessage();
            validationMessage.setDescription(constraint.getMessage());
            validationMessage.setInvalidValue(constraint.getInvalidValue());
            validationMessages.add(validationMessage);
        }
        return validationMessages;
    }
    
}
