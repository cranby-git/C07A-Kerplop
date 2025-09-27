package levelPieces;

import gameEngine.InteractionResult;
import gameEngine.Drawable;

public class Fairy extends GamePiece{
	
	// constructor
	public Fairy(char symbol, String label, int location) {
		super (symbol,  label,  location);
	}
	

	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		// give a point if on the player
		if(super.getLocation() == playerLocation) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
	
}
