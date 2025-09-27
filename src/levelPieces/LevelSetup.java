package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {
	
	protected ArrayList<GamePiece> pieces = new ArrayList<>();
	
	protected Drawable[] wholeBoard = new Drawable[21];
	
	protected ArrayList<Moveable> canMove = new ArrayList<>();
	
	
	public void createLevel(int levelNum){
		
		Wunkus wonk = new Wunkus('W', "Wunkus",0);
		
		wholeBoard[0] = wonk;
		pieces.add(wonk);
		
		if(levelNum == 1){
			//need to determine level set up and what pieces to use
			MudPit muddy = new MudPit(9);
			MudPit corn = new MudPit(17);
			Lobster lob = new Lobster('L', "Lobster", 19);
			
			wholeBoard[9] = muddy;
			wholeBoard[17] = corn;
			wholeBoard[19] = lob;
			
			pieces.add(lob);
			
			canMove.add(lob);
			
			
		}
		else {
			//need to determine level set up and what pieces to use
			Lobster lob = new Lobster('L', "Lobster", 19);
			MudPit steak = new MudPit(20);
			Lobster pot = new Lobster('L', "Lobster", 3);
			
			wholeBoard[19] =  lob;
			wholeBoard[20] = steak;
			wholeBoard[3] = pot;
			
			pieces.add(lob);
			pieces.add(pot);
			
			canMove.add(lob);
			canMove.add(pot);
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
		return 10;
	}
}

