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
public class Game {
    
    private int[][] gameBoard;
    
    public Game(){
        gameBoard = new int[4][4];
    }
    
    public void printArray(){
        for(int[] x:gameBoard){
            System.out.format("%6d%6d%6d%6d%n",x[0],x[1],x[2],x[3]);
        }
        System.out.println("\n");
    }
}
