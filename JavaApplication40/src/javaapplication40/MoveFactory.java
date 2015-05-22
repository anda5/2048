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
public class MoveFactory {
    MoveMaker mm = new MoveMaker();
    private int score;
     public void getShape(String shapeType,int[][] gameBoard){
   	
      if(shapeType.equalsIgnoreCase("MoveUp")){
          mm.MoveUp(gameBoard);
          score = mm.getScore();
      }      
       else if(shapeType.equalsIgnoreCase("MoveDown")){
         mm.MoveDown(gameBoard);
         score = mm.getScore();
      }
        
       else if(shapeType.equalsIgnoreCase("MoveLeft")){
         mm.MoveLeft(gameBoard);
         score = mm.getScore();
      }
      else if(shapeType.equalsIgnoreCase("MoveRight")){
         mm.MoveRight(gameBoard);
         score = mm.getScore();
      }
     
      }
      public int getScore(){
          return score;
      
   }
    
}
