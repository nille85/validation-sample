/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.service;

import be.nille.validation.sample.model.client.Client;
import be.nille.validation.sample.model.client.ClientRepository;
import be.nille.validation.sample.model.client.Scope;

/**
 *
 * @author Niels Holvoet
 */
public class ClientService {
    
    private final ClientRepository repository;
    
    public ClientService(final ClientRepository repository){
        this.repository = repository;
    }
    
    public void registerClient(final RegisterClientData registerClientData){
        registerClientData.validate();
        repository.save(registerClientData.toClient());
    }
    
    public void addScope(final AddScopeData addScopeData){
        addScopeData.validate();
        Client client = repository.findById(addScopeData.getClientId());
        client.addScope(new Scope("read"));
        repository.save(client);
    }
    
}
