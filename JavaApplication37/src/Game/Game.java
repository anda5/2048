/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author anda
 */
public class Game {
    
    private int[][] gameBoard;
    private Random random = new Random();
    
    
    public Game(){
        gameBoard = new int[4][4];
    }
    
    public void printArray(){
        for(int[] x:gameBoard){
            System.out.format("%6d%6d%6d%6d%n",x[0],x[1],x[2],x[3]);
        }
        System.out.println("\n");
    }
    
    public void addNewNumber(){
 
        ArrayList<Integer> emptySpacesx = new ArrayList<Integer>();
        ArrayList<Integer> emptySpacesy = new ArrayList<Integer>();
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                if(gameBoard[i][j]==0){
                    emptySpacesx.add(new Integer(i));
                    emptySpacesy.add(new Integer(j));
                }
            }
        }
        int choice = random.nextInt(emptySpacesx.size());
        int numberChooser = random.nextInt(10);//0-9
        int newNumber = 1;
        if(numberChooser==0){
            newNumber = 2;
        }
        int x = emptySpacesx.get(choice);
        int y = emptySpacesy.get(choice);
        gameBoard[x][y] = newNumber;
    }
    
    public void pushUp(){
        System.out.println("Pushed up.....");
        for(int j=0;j<4;j++){
            for(int i=1;i<4;i++){
                if(gameBoard[i][j]!=0){
                    int value = gameBoard[i][j];
                    int x=i-1;
                    while(x>=0 && gameBoard[x][j]==0){
                       x--;
                    }
                    if(x==-1){
                        gameBoard[0][j]=value;
                        gameBoard[i][j]=0;
                    }
                    else if(gameBoard[x][j]!=value){
                        gameBoard[x+1][j] = value;
                        gameBoard[i][j] =0;
                    }
                    else{
                        gameBoard[x][j]*=2;
                        gameBoard[i][j]=0;
                    }
                }
                
            }
        }
        
        
    }
}
