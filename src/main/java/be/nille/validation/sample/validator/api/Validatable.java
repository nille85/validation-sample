/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.validator.api;

import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public interface Validatable {
    
    List<ValidationMessage> validate();
    
}