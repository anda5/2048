package javaapplication40;

import javaapplication40.GameState;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	private int[][] gameBoard;
	private Random r = new Random();
	private GameState state1,state3;
	private int score;
        private ContinueState gameState;
        private WinState winState; 
        private LoseState loseState; 
        private Context context ;
       
      
	public Game() {
		gameBoard = new int[4][4];
		addNewNumber();
		addNewNumber();
                context = new Context();
                winState = new WinState();
                loseState = new LoseState();
                if(context!=null){
                gameState = new ContinueState();
                context.setState(gameState);
                }
	}
	
	public int[][] getGameBoard() {
		return gameBoard;
	}
	public Context getContext() {
	    return context ;
	}
	public int getScore() {
	    return score;
	}
	
	public void printArray() {
		for (int[] x: gameBoard) {
			System.out.format("%6d%6d%6d%6d%n", x[0], x[1], x[2], x[3]);
		}
		System.out.format("%n");
	}
	
	public void addNewNumber() {
	    if (checkBoardFull()) {
	        return;
	    }
		ArrayList<Integer> emptySpacesX = new ArrayList<Integer>();
		ArrayList<Integer> emptySpacesY = new ArrayList<Integer>();
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (gameBoard[x][y] == 0) {
					emptySpacesX.add(new Integer(x));
					emptySpacesY.add(new Integer(y));
				}
			}
		}
		int choice = r.nextInt(emptySpacesX.size());
		int numberChooser = r.nextInt(10); // value 0-9
		int newNumber = 1;
		if (numberChooser == 0) {
			newNumber = 2;
		}
		int X = emptySpacesX.get(choice);
		int Y = emptySpacesY.get(choice);
		gameBoard[X][Y] = newNumber;
	}
	
        public void pushUp(){
        MoveFactory mf = new MoveFactory();
        mf.getShape("MoveUp",gameBoard);
        score +=mf.getScore();
        
        }
        
	public void pushDown(){
        MoveFactory mf = new MoveFactory();
        mf.getShape("MoveDown",gameBoard);
        score +=mf.getScore();
	}
	
	public void pushLeft() {
       MoveFactory mf = new MoveFactory();
       mf.getShape("MoveLeft",gameBoard);
       score +=mf.getScore();
	}
	
	public void pushRight() {
	
	MoveFactory mf = new MoveFactory();
        mf.getShape("MoveRight",gameBoard);
        score +=mf.getScore();
        
        }
	// return true if a 1024 is on the board
	public boolean checkFor1024() {
	    for (int x = 0; x < 4; x++) {
	        for (int y = 0; y < 4; y++) {
	            if (gameBoard[x][y] == 1024) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	// return true if the board is full of tiles
	public boolean checkBoardFull() {
	    for (int x = 0; x < 4; x++) {
	        for (int y = 0; y < 4; y++) {
	            if (gameBoard[x][y] == 0) {
	                return false;
	            }
	        }
	    }
	    System.out.println("Board full");
	    return true;
	}
	// return true if there are any adjacent numbers
	public boolean checkHasMoves() {
	    for (int x = 0; x < 4; x++) {
	        for (int y = 0; y < 4; y++) {
	            if (x == 0) {
	                if (y != 0) {
	                    if (gameBoard[x][y] == gameBoard[x][y-1]) {
	                        System.out.println("checkHasMoves(): There ARE adjacent numbers.");
	                        return true;
	                    }
	                }
	            } else {
	                if (y != 0) {
	                    if (gameBoard[x][y] == gameBoard[x][y-1]) {
	                        System.out.println("checkHasMoves(): There ARE adjacent numbers.");
	                        return true;
	                    }
	                }
	                if (gameBoard[x][y] == gameBoard[x-1][y]) {
	                    System.out.println("checkHasMoves(): There ARE adjacent numbers.");
	                    return true;
	                } 
	            }
	        }
	    }
	    System.out.println("checkHasMoves(): There are no adjacent numbers.");
	    return false;
	}
	
	public void checkState() {
	    if (checkFor1024()) {
	       context.setState(winState);
	    } else if (checkBoardFull()){
	        if (checkHasMoves()) {
	          context.setState(gameState);
	        } else {
                  context.setState(loseState);
	        }
	    } else {
           context.setState(gameState);
        }
	}
	
}
