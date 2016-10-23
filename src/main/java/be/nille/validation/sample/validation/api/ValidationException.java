/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validation.api;

import java.util.List;
import lombok.Getter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
public class ValidationException extends RuntimeException {
    
    private final List<ValidationMessage> messages;
    
    public ValidationException(final List<ValidationMessage> messages){
        this.messages = messages;
    }
}
