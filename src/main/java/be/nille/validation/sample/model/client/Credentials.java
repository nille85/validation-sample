/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.model.client;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@Setter(AccessLevel.PACKAGE)
@ToString
public class Credentials {
    
    private String id;
    private String secret;
    
    Credentials(){}
    
}
