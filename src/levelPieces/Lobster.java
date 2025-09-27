package levelPieces;

import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.Drawable;

import java.util.Random;
import java.util.ArrayList;

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
		// find all valid spots
		ArrayList<Integer> validSpots = new ArrayList<Integer>();
		for (int i = 0; i < gameBoard.length; ++i) {
			if (gameBoard[i] == null) {
				validSpots.add(i);
			}
		}
		
		//generate random number and update relevant positions
		Random rand = new Random();
		int newLocation = rand.nextInt(validSpots.size());
		gameBoard[newLocation] = gameBoard[super.getLocation()];
		gameBoard[super.getLocation()] = null;
		super.setLocation(newLocation);
	}
	
	
}
