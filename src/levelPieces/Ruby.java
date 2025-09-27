package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Ruby extends GamePiece{
	
	// constructor
	public Ruby(char symbol, String label, int location) {
		super (symbol,  label,  location);
	}
	

	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		// advance if on the player
		if(super.getLocation() == playerLocation) {
		return InteractionResult.ADVANCE;
			}
		return InteractionResult.NONE;
	}

}
