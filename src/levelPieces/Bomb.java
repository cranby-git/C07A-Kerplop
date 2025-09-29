package levelPieces;

import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.Drawable;

import java.util.ArrayList;
import java.util.Random;

public class Bomb extends GamePiece implements Moveable {
	
	// if the bomb is on the board and about to explode
	Boolean primed;
	
	// basic constructor
	public Bomb(char symbol, String label, int location) {
		super(symbol, label, location);
		primed = true;
	}
	
	@Override 
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		// hit if next to or on the player while the bomb is primed
		if(primed && Math.abs(super.getLocation() - playerLocation) <= 1) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// if the bomb just exploded, remove it from the board
		if(primed) {
			gameBoard[super.getLocation()] = null;
			primed = false;
		} else {
			// find all valid spots
			ArrayList<Integer> validSpots = new ArrayList<Integer>();
			for (int i = 0; i < gameBoard.length; ++i) {
				if (gameBoard[i] == null) {
					validSpots.add(i);
				}
			}
			
			// choose random valid spot
			Random rand = new Random();
			int newLocation = rand.nextInt(validSpots.size());
			gameBoard[newLocation] = this;
			super.setLocation(newLocation);
			primed = true;
		}
	}
}
