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
		Random rand = new Random();
		int randomLocation = rand.nextInt(21);
		this.setLocation(randomLocation);
	}
	
	
}
