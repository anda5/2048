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
    
    public void pushDown(){
        System.out.println("Pushed down.....");
         boolean aleradyCombined[]= {false,false,false,false};
        for(int j=0;j<4;j++){
            for(int i=2;i>-1;i--){
                if(gameBoard[i][j]!=0){
                    int value = gameBoard[i][j];
                    int x=i+1;
                    while(x<=3 && gameBoard[x][j]==0){
                       x++;
                    }
                    if(x==4){
                        gameBoard[3][j]=value;
                        gameBoard[i][j]=0;
                    }
                    else if(gameBoard[x][j]!=value){
                        gameBoard[x-1][j] = value;
                        gameBoard[i][j] =0;
                    }
                    else{
                        if(aleradyCombined[x]==true){
                        gameBoard[x-1][j] = value;
                        gameBoard[i][j] =0;
                        }else{
                            
                        gameBoard[x][j]*=2;
                        aleradyCombined[x]=true;
                        gameBoard[i][j]=0;
                        }
                    }
                }
                
            }
        }
    }
        
        public void pushUp(){
        System.out.println("Pushed up.....");
        boolean aleradyCombined[]= {false,false,false,false};
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
                         if(aleradyCombined[x]==true){
                        gameBoard[x+1][j] = value;
                        gameBoard[i][j] =0;
                        }else{
                            
                        gameBoard[x][j]*=2;
                        aleradyCombined[x]=true;
                        gameBoard[i][j]=0;
                        }
                    }
                }
                
            }
        }
        }
         public void pushLeft(){
        System.out.println("Pushed left.....");
        boolean aleradyCombined[]= {false,false,false,false};
        for(int i=0;i<4;i++){
            for(int j=1;j<4;j++){
                if(gameBoard[i][j]!=0){
                    int value = gameBoard[i][j];
                    int y=j-1;
                    while(y>=0 && gameBoard[i][y]==0){
                       y--;
                    }
                    if(y==-1){
                        gameBoard[i][0]=value;
                        gameBoard[i][j]=0;
                    }
                    else if(gameBoard[i][y]!=value){
                        gameBoard[i][y+1] = value;
                        gameBoard[i][j] =0;
                    }
                    else{
                         if(aleradyCombined[y]==true){
                        gameBoard[i][y+1] = value;
                        gameBoard[i][j] =0;
                        }else{
                            
                        gameBoard[i][y]*=2;
                        aleradyCombined[y]=true;
                        gameBoard[i][j]=0;
                        }
                    }
                }
                
            }
        }
         }
         public void pushRight(){
        System.out.println("Pushed right.....");
        boolean aleradyCombined[]= {false,false,false,false};
        for(int i=0;i<4;i++){
            for(int j=2;j>-1;j--){
                if(gameBoard[i][j]!=0){
                    int value = gameBoard[i][j];
                    int y=j+1;
                    while(y>3 && gameBoard[i][y]==0){
                       y++;
                    }
                    if(y==4){
                        gameBoard[i][3]=value;
                        gameBoard[i][j]=0;
                    }
                    else if(gameBoard[i][y]!=value){
                        gameBoard[i][y-1] = value;
                        gameBoard[i][j] =0;
                    }
                    else{
                         if(aleradyCombined[y]==true){
                        gameBoard[i][y-1] = value;
                        gameBoard[i][j] =0;
                        }else{
                            
                        gameBoard[i][y]*=2;
                        aleradyCombined[y]=true;
                        gameBoard[i][j]=0;
                        }
                    }
                }
                
            }
        }
    }
}
