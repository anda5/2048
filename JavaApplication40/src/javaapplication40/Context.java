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
public class Context implements State{
    public State state;
    
    
    public Context(){
        state = null;
    }
    public State getState(){
        return state;
    }
   
    public void setState(State state){
        this.state = state;
    }

    @Override
    public GameState doAction() {
       return this.state.doAction();
    }

   
}
