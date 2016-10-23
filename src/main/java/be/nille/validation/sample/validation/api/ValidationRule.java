/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validation.api;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Niels Holvoet
 */
public abstract class ValidationRule{
    
    private static final Validator validator;
    
    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
     public Set<ConstraintViolation<ValidationRule>> validate(){
        return validator.validate(this);
    }
}
