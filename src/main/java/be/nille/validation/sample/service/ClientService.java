/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.service;

import be.nille.validation.sample.model.client.Client;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class ClientService {
    
    private final List<Client> clients;
    
    
    public ClientService(){
        clients = new LinkedList<>();
    }
    
    
    public void addClient(final AddClientCommand clientCommand){
        final Client client = clientCommand.toClient();
        clients.add(client);
    }
    
    public List<Client> getClients(){
        return clients;
    }
    
}
