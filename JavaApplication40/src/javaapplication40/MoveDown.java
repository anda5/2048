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
public class MoveDown implements Move {
     int score;
    @Override
    public void move(int[][] gameBoard) {
      System.out.println("Pushing down...");
		for (int y = 0; y < 4; y++) {
			boolean[] alreadyCombined = { false, false, false, false };
			for (int x = 2; x > -1; x--) {
				if (gameBoard[x][y] != 0) {
					int value = gameBoard[x][y];
					int X = x + 1;
					while ( (X <= 3) && (gameBoard[X][y] == 0) ) {
						X++;
					}
					if (X == 4) {
						gameBoard[3][y] = value;
						gameBoard[x][y] = 0;
					}
					else if (gameBoard[X][y] != value) {
						gameBoard[x][y] = 0;
						gameBoard[X-1][y] = value;
					}
					else {
						if (alreadyCombined[X]) {
							gameBoard[x][y] = 0;
							gameBoard[X-1][y] = value;
							// gameBoard[x][y] = 0;
						}
						else {
							gameBoard[x][y] = 0;
							gameBoard[X][y] *= 2;
							score += gameBoard[X][y];
							alreadyCombined[X] = true;
							//gameBoard[x][y] = 0;
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
