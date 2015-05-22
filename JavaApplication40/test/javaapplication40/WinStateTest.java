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
public class WinStateTest extends TestCase {
    
  public void testDoAction() {
      
        WinState instance = new WinState();
        GameState expResult = instance.doAction();
        assertEquals(expResult, GameState.WIN);
       
    }
    
}
