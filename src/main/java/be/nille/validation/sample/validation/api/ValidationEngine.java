/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validation.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class ValidationEngine {
    
    List<ValidationRule> rules;
    
    public ValidationEngine(){
        rules = new ArrayList<>();
    }
    
    public void addRule(ValidationRule rule){
        rules.add(rule);
    }
    
    public void fireRules(){
        List<ValidationMessage> allValidationMessages = new ArrayList<>();
        for(ValidationRule rule : rules){
            List<ValidationMessage> validationMessages = validateRule(rule);
            allValidationMessages.addAll(validationMessages);
        }
        if(!allValidationMessages.isEmpty()){
            throw new ValidationException(allValidationMessages);
        }
        
    }
    
    private List<ValidationMessage> validateRule(final ValidationRule rule){
         Set<ConstraintViolation<ValidationRule>> constraints = rule.validate();
         List<ValidationMessage> validationMessages = getValidationMessagesFromConstraints(constraints);
         return validationMessages;
    }
    
    private List<ValidationMessage> getValidationMessagesFromConstraints( Set<ConstraintViolation<ValidationRule>> constraints){
        List<ValidationMessage> validationMessages = new ArrayList<>();
        for(ConstraintViolation<ValidationRule> constraint : constraints){
            ValidationMessage validationMessage = new ValidationMessage();
            validationMessage.setDescription(constraint.getMessage());
            validationMessage.setInvalidValue(constraint.getInvalidValue());
            log.debug("Validation occurred: " + validationMessage.toString());
            validationMessages.add(validationMessage);
        }
        return validationMessages;
    }
    
}
