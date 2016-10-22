/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.validation.sample.model.client;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Niels Holvoet
 */
public class ScopeTest {
    
    @Test
    public void scopeCreate(){
        Scope scope = new Scope("read");
        assertEquals("read", scope.getName());
    }
    
}
