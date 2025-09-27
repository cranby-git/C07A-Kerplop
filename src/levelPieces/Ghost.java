package levelPieces;

import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.GameEngine;

// will damage the player if it is next to them, but will disappear if behind another piece
public class Ghost extends GamePiece implements Moveable{
	
	// the direction 
	int direction;
	
	// Constructor
	public Ghost(char symbol, String label, int location) {
		super(symbol, label, location);
		direction = 1;
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		//damage if next to the player
		if(playerLocation == super.getLocation() + direction) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
	
	// move one space back and forth across the board
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// change direction if on edge
		if(super.getLocation() + direction < 0 || super.getLocation() + direction > GameEngine.BOARD_SIZE - 1) {
			direction = direction * (-1);
		}
		
		// if space is empty
		if(gameBoard[super.getLocation() + direction] == null) {
			// if on a piece, don't remove that piece
			if(gameBoard[super.getLocation()] != null) {
				gameBoard[super.getLocation()] = null;
			}
			gameBoard[super.getLocation() + direction] = this;
			super.setLocation(super.getLocation() + direction);
		// otherwise move but don't go on the board
		} else {
			// if on a piece, don't remove that piece
			if(gameBoard[super.getLocation()] != null) {
				gameBoard[super.getLocation()] = null;
			}
			super.setLocation(super.getLocation() + direction);
		}
	}
}
