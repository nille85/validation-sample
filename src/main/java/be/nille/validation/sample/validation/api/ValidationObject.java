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
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class ValidationObject {
    private static final Validator validator;
    
    static{
         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         validator = factory.getValidator();
    }
    
    private final Object objectToValidate;
    
    ValidationObject(final Object objectToValidate){
        this.objectToValidate = objectToValidate;
    }
    
    List<ValidationMessage> validate(){
         Set<ConstraintViolation<Object>> constraints = validator.validate(objectToValidate);
         List<ValidationMessage> validationMessages = getValidationMessagesFromConstraints(constraints);
         return validationMessages;
    }
    
    
    private List<ValidationMessage> getValidationMessagesFromConstraints( Set<ConstraintViolation<Object>> constraints){
        List<ValidationMessage> validationMessages = new ArrayList<>();
        for(ConstraintViolation<Object> constraint : constraints){
            ValidationMessage validationMessage = new ValidationMessage(constraint);
            log.debug("Validation occurred: " + validationMessage.toString());
            validationMessages.add(validationMessage);
        }
        return validationMessages;
    }
    
}
