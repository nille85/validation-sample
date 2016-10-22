/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.model.client;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Niels Holvoet
 */
public class ClientTest {
    
    @Test
    public void create(){
        Client client = new Client("clientid", "secret");
        assertEquals("clientid", client.getCredentials().getId());
        assertEquals("secret", client.getCredentials().getSecret());
    }
    
    @Test
    public void addAndRemoveScopes(){
       Client client = new Client("clientid", "secret");
       
       client.addScope(new Scope("read"));
       client.addScope(new Scope("write"));
       assertTrue(2 == client.getScopes().size());
       
       client.removeScope("read");
       assertTrue(1 == client.getScopes().size());
       
       assertEquals("write", client.getScopes().get(0).getName());
    }
    
   
    
}
