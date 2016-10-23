/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.model.client;

import be.nille.validation.sample.model.NoDataFoundException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class ClientRepository {
    
    private final List<Client> clients;
    
    
    public ClientRepository(){
        clients = new LinkedList<>();
    }
    
    public void save(final Client client){
        try{
            update(client);
        }catch(NoDataFoundException ex){
            add(client);
        }
    }
    
    private void add(final Client client){
        clients.add(client);
    }
    
    private void update(final Client client){
        int clientIndex = findIndex(client.getId());
        clients.set(clientIndex, client);
    }
    
    public void remove(final Client client){
        int clientIndex = findIndex(client.getId());
        clients.remove(clientIndex);
    }
    
    public List<Client> findAll(){
        return clients;
    }
      
    
    public Client findById(final String id){
        int clientIndex = findIndex(id);
        return clients.get(clientIndex);
    }
    
     private int findIndex(final String id){
        
        for(int i=0;i<clients.size();i++){
            Client client = clients.get(i);
             if(client.getId().equals(id)){
                return i;
            }
        }
        throw new NoDataFoundException("Client with id " + id + " was not found in repository");
    }
    
}
