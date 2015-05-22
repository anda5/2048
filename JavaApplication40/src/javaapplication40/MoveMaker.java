/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication40;

import javaapplication40.GUI.GameBoard;

/**
 *
 * @author anda
 */
public class MoveMaker {
   private Move moveup;
   private Move movedown;
   private Move moveleft;
   private Move moveright;
   private int score;

   public MoveMaker() {
     moveup = new MoveUp();
     movedown = new MoveDown();
     moveleft = new MoveLeft();
     moveright = new MoveRight();
   }

   public void MoveUp(int[][] gameBoard){
      moveup.move(gameBoard);
      score = moveup.getScore();
   }
    public void MoveDown(int[][] gameBoard){
      movedown.move(gameBoard);
      score = movedown.getScore();
   }
      public void MoveLeft(int[][] gameBoard){
      moveleft.move(gameBoard);
      score = moveup.getScore();
   }
      public void MoveRight(int[][] gameBoard){
      moveright.move(gameBoard);
      score = movedown.getScore();
   }
      public int getScore(){
          return score;
      }
}
