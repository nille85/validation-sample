/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.service;

import be.nille.validation.sample.model.client.ClientRepository;
import be.nille.validation.sample.validation.api.ValidationException;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
public class ClientServiceTest {
       
    @Test
    public void registerClient(){
        RegisterClientData data = new RegisterClientData();
        data.setClientId("clientid");
        data.setClientSecret("secret");
        ClientService service = createService();
        service.registerClient(data);
    }
    
    @Test(expected = ValidationException.class)
    public void registerClientWithoutClientId(){
        RegisterClientData data = new RegisterClientData();
        data.setClientSecret("secret");
        ClientService service = createService();
        service.registerClient(data);
    }
    
    private ClientService createService(){
        ClientRepository repository = new ClientRepository();
        return new ClientService(repository);
    }
    
}
