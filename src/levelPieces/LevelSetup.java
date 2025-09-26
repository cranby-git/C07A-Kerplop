package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {
	
	protected ArrayList<GamePiece> pieces;
	protected Drawable[] wholeBoard;
	protected ArrayList<Moveable> canMove;
	
	void createLevel(int levelNum){
		if(levelNum == 1){
			//need to determine level set up and what pieces to use
		}
		else {
			//need to determine level set up and what pieces to use
		}
		
	}
	
	public Drawable[] getBoard(){
		return wholeBoard;
	}
	
	public ArrayList<Moveable> getMovingPieces(){
		return canMove;
	}
	public ArrayList<GamePiece> getInteractingPieces(){
		return pieces;
	}
	
	public int getPlayerStartLoc(){
		return 8;
	}
}

