package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Wunkus extends GamePiece {

	//Constructor class that establishes values using super
	public Wunkus(char symbol, String label, int location) {
		super (symbol,  label,  location);
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		
		if(playerLocation == super.getLocation() ) {
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}
	
}
