/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication40;

import junit.framework.TestCase;

/**
 *
 * @author anda
 */
public class ContextTest extends TestCase {
    

    public void testGetState() {
        Context context = new Context();
        ContinueState gameState = new ContinueState();
        context.setState(gameState);
        assertEquals(context.getState(),gameState);
       
    }

    public void testSetState() {
        Context context = new Context();
        ContinueState gameState = new ContinueState();
        context.setState(gameState);
        assertEquals(context.getState(),gameState);
    }

  
    public void testDoAction() {

        ContinueState gameState = new ContinueState();
        GameState expResult = GameState.CONTINUE;
        GameState result = gameState.doAction();
        assertEquals(expResult, result);
        
    }
    
}
