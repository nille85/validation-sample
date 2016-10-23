/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.model;

/**
 *
 * @author Niels Holvoet
 */
public class NoDataFoundException extends RuntimeException {
    
    public NoDataFoundException(final String message){
        super(message);
    }
}
