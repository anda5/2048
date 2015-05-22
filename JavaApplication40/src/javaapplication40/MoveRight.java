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
public class MoveRight implements Move{
    	
    int score;
    @Override
    public void move(int[][] gameBoard) {
        System.out.println("Pushing right...");
		for (int x = 0; x < 4; x++) {
			boolean[] alreadyCombined = { false, false, false, false };
			for (int y = 2; y > -1; y--) {
				if (gameBoard[x][y] != 0) {
					int value = gameBoard[x][y];
					int Y = y + 1;
					while ( (Y <= 3) && (gameBoard[x][Y] == 0) ) {
						Y++;
					}
					if (Y == 4) {
						gameBoard[x][3] = value;
						gameBoard[x][y] = 0;
					}
					else if (gameBoard[x][Y] != value) {
						gameBoard[x][y] = 0;
						gameBoard[x][Y-1] = value;
						// gameBoard[x][y] = 0;
					}
					else {
						if (alreadyCombined[Y]) {
							gameBoard[x][y] = 0;
							gameBoard[x][Y-1] = value;
							
						}
						else {
							gameBoard[x][y] = 0;
							gameBoard[x][Y] *= 2;
							score += gameBoard[x][Y];
							alreadyCombined[Y] = true;
						}
					}
				}
			}
		} //To change body of generated methods, choose Tools | Templates.
    }
     public int getScore(){
        return score;
    }
}
