/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 *
 * @author anda
 */
public class Main {
    public static void main(String[] args){
        Game game = new Game();
        for(int i =0;i<3;i++){
        game.addNewNumber();
        }
        game.printArray();
        for(int i =0;i<3;i++){
           game.addNewNumber();
           game.printArray();
           game.pushUp();
           game.printArray();
        }
    }
}
