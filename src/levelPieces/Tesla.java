package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Tesla extends GamePiece{
	
	// constructor
	public Tesla(char symbol, String label, int location) {
		super (symbol,  label,  location);
	}
	

	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		// 50% chance to hit the player if it is next to or on
		if(Math.abs(super.getLocation() - playerLocation) <= 1 && Math.random() < 0.5) {
		return InteractionResult.HIT;
			}
		return InteractionResult.NONE;
	}

}
