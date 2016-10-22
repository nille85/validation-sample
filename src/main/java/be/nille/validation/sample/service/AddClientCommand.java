/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.service;

import be.nille.validation.sample.model.client.Client;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Niels Holvoet
 */
@Getter
@Setter
public class AddClientCommand {
    
    @NotNull
    private String clientId;
    @NotNull
    private String clientSecret;
    
    
    public Client toClient(){
         return new Client("clientid", "secret");
       
    }
    
    
}
