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
public class MoveLeft implements Move{
    int score;
    @Override
    public void move(int[][] gameBoard) {
        System.out.println("Pushing left...");
		for (int x = 0; x < 4; x++) {
			boolean[] alreadyCombined = { false, false, false, false };
			for (int y = 1; y < 4; y++) {
				if (gameBoard[x][y] != 0) {
					int value = gameBoard[x][y];
					int Y = y - 1;
					while ( (Y >= 0) && (gameBoard[x][Y] == 0) ) {
						Y--;
					}
					if (Y == -1) {
						gameBoard[x][0] = value;
						gameBoard[x][y] = 0;
					}
					else if (gameBoard[x][Y] != value) {
						gameBoard[x][y] = 0;
						gameBoard[x][Y+1] = value;
						// gameBoard[x][y] = 0;
					}
					else {
						if (alreadyCombined[Y]) {
							gameBoard[x][y] = 0;
							gameBoard[x][Y+1] = value;
							// gameBoard[x][y] = 0;
						}
						else {
							gameBoard[x][y] = 0;
							gameBoard[x][Y] *= 2;
							score += gameBoard[x][Y];
							alreadyCombined[Y] = true;
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
