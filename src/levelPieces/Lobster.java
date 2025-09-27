package levelPieces;

import java.util.Random;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Lobster extends GamePiece implements Moveable{
	
	
	//Constructor class that establishes values using super
	public Lobster(char symbol, String label, int location) {
		super (symbol,  label,  location);
	}
	
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
		//replace current location as empty
		gameBoard[this.getLocation()] = null;
		
		//new location
		int randomLocation;
		
		
		//do while to see if the new random location is valid
		do {
			//generate a new location with an ever changing seed
			long seed = System.currentTimeMillis();
			Random rand = new Random(seed);
			randomLocation = rand.nextInt(21);
		}while(gameBoard[this.getLocation()] != null);
		
		
		//set the new location for the lobster
		this.setLocation(randomLocation);
		gameBoard[randomLocation] = this;
	}
	
	
}
