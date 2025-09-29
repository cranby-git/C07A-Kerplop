package levelPieces;
import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;
public class LevelSetup {
	
	protected ArrayList<GamePiece> pieces = new ArrayList<>();
	
	protected Drawable[] wholeBoard = new Drawable[21];
	
	protected ArrayList<Moveable> canMove = new ArrayList<>();
	
	
	public void createLevel(int levelNum){
		
		
		if(levelNum == 1){
			//need to determine level set up and what pieces to use
			Fairy f1 = new Fairy('F', "Fairy",3);
			Fairy f2 = new Fairy('F', "Fairy",19);
			Ruby rube = new Ruby('R', "Ruby", 15);
			
			MudPit muddy = new MudPit(17);
			Lobster lob = new Lobster('L', "Lobster", 13);
			Ghost blinky = new Ghost('G', "Ghost", 1);
			
			
			wholeBoard[3] = f1;
			wholeBoard[19] = f2;
			wholeBoard[17] = muddy;
			wholeBoard[13] = lob;
			wholeBoard[15] = rube;
			wholeBoard[1] = blinky;
			
			pieces.add(f1);
			pieces.add(f2);
			pieces.add(lob);
			pieces.add(rube);
			pieces.add(blinky);
			
			
			canMove.add(lob);
			canMove.add(blinky);
			
			//print out pieces and what they do
			System.out.println("P - Player(you)");
			System.out.println(f1 + "(gives you a point)");
			System.out.println(lob + "(Can attack from a distance)");
			System.out.println(rube + "(Unique)");
			System.out.println(muddy + "(A mud pit)");
			System.out.println(blinky + "(Will kill you)");
			
			
			
		}
		else {
			//need to determine level set up and what pieces to use
			
			Fairy f1 = new Fairy('F', "Fairy",1);
			Fairy f2 = new Fairy('F', "Fairy",15);
			
			Wunkus wonkL = new Wunkus('W', "Wunkus",8);
			Wunkus wonkR = new Wunkus('W', "Wunkus",12);
			Lobster lob = new Lobster('L', "Lobster", 19);
			Bomb bob = new Bomb('B', "Bomb", 17);
			Bomb omb = new Bomb('B', "Bomb", 9);
			Tesla musky = new Tesla('T', "Tesla", 16);
			
			wholeBoard[1] =  f1;
			wholeBoard[15] =  f2;
			wholeBoard[8] = wonkL;
			wholeBoard[12] = wonkR;
			wholeBoard[19] =  lob;
			wholeBoard[17] =  bob;
			wholeBoard[9] =  omb;
			wholeBoard[16] =  musky;

			pieces.add(f1);
			pieces.add(f2);
			pieces.add(wonkL);
			pieces.add(wonkR);
			pieces.add(lob);
			pieces.add(bob);
			pieces.add(omb);
			pieces.add(musky);
			
			
			canMove.add(lob);
			canMove.add(bob);
			canMove.add(omb);
			
			//print out pieces and what they do
			System.out.println("P - Player(you)");
			System.out.println(f1 + "(gives you a point)" );
			System.out.println(wonkL + "(Will kill ou if you touch it)");
			System.out.println(lob + "(Can attack from a distance)");
			System.out.println(bob + "(Will deal 1 damage)");
			System.out.println(musky + "(Has a chance to deal 1 damage to player)");
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

