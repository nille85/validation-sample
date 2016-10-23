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
public class ValidationEngine {
    
    final List<ValidationObject> objects;
   
    public ValidationEngine(){
        objects = new ArrayList<>();
    }
    
    public ValidationEngine addObject(Object object){
        ValidationObject validationObject = new ValidationObject(object);
        objects.add(validationObject);
        return this;
    }
    
    public ValidationEngine addObjects(Object ... objects){
        for(Object object : objects){
            addObject(object);
        }
        return this;
    }
    
    public void validate(){
        List<ValidationMessage> allValidationMessages = new ArrayList<>();
        for(ValidationObject object : objects){
            List<ValidationMessage> validationMessages = object.validate();
            allValidationMessages.addAll(validationMessages);
        }
        if(!allValidationMessages.isEmpty()){
            throw new ValidationException(allValidationMessages);
        }    
    }
    
}
