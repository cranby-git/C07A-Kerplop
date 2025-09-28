package levelPieces;

import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.Drawable;

import java.util.Random;

public class Lobster extends GamePiece implements Moveable{
	
	//Constructor class that establishes values using super
	public Lobster(char symbol, String label, int location) {
		super (symbol,  label,  location);
	}
	
	// kill if next to the player
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		
		if(playerLocation == super.getLocation() + 1 || playerLocation == super.getLocation() - 1) {
			return InteractionResult.KILL;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation){
		
		gameBoard[this.getLocation()] = null;
		
		int newLocation;
		
		
		do {
			//generate random number and update relevant positions
			long seed = System.currentTimeMillis();
			Random rand = new Random(seed);
			newLocation = rand.nextInt(21);
		}while(gameBoard[newLocation] != null);
		
		
		gameBoard[newLocation] = gameBoard[this.getLocation()];
		this.setLocation(newLocation);
	}
	
	
}
