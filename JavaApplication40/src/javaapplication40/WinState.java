/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication40;

/**
 *
 * @author anda
 */
public class WinState implements State{
  
    @Override
    public GameState doAction() {
       return GameState.WIN;//To change body of generated methods, choose Tools | Templates.
    }
}
