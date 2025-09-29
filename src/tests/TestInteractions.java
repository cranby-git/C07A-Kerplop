package tests;

import org.junit.Assert;
import org.junit.Test;

import levelPieces.*;
import gameEngine.GameEngine;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class TestInteractions {
	/*
	 * First tests that the bomb does not deal damage after exploding,
	 * then tests that the bomb only deals damage if the player is
	 * next to or on the bomb, otherwise it does not do damage
	 */
	@Test
	public void testBomb() {
		// set up board
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Bomb testBomb = new Bomb('B', "testBomb", 10);
		gameBoard[10] = testBomb;
		
		// add mud pits on the side so the bomb cannot land on the side
		gameBoard[0] = new MudPit(0);
		gameBoard[GameEngine.BOARD_SIZE - 1] = new MudPit(GameEngine.BOARD_SIZE - 1);
		
		// "explode" the bomb to remove it from the board
		testBomb.move(gameBoard, 0);
		
		// test that the bomb wouldn't do damage for all possible player positions
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			Assert.assertEquals(gameEngine.InteractionResult.NONE, testBomb.interact(gameBoard, i));
		}
		
		// re-drop the bomb
		testBomb.move(gameBoard, 0);
		
		// test that the bomb would do damage only if the player is nearby
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if(Math.abs(i - testBomb.getLocation()) <= 1) {
				Assert.assertEquals(InteractionResult.HIT, testBomb.interact(gameBoard, i));				
			} else {
				Assert.assertEquals(InteractionResult.NONE, testBomb.interact(gameBoard, i));
			}
		}
	}
	
	/*
	 * Tests the tesla by running 100 interactions with player position
	 * either adjacent or on the tesla. It is expected the player will
	 * be hit about 50 times, with a range of +- 12. There is ~0.6% chance
	 * the tesla operates correctly but falls outside the range. If one
	 * of the valid "damage" spots is not functional, there is an ~83.2%
	 * chance the test should fail.
	 * 
	 * Then the code will test that the tesla doesn't damage any other spots
	 */
	@Test
	public void testTesla() {
		// set up board
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Tesla testTesla = new Tesla('T', "testTesla", 10);
		gameBoard[10] = testTesla;
		
		// calculate num hits for all positions close to the tesla
		int numHits = 0;
		for(int i = 0; i < 100; i++) {
			if(testTesla.interact(gameBoard, 9 + (i%3)) == InteractionResult.HIT) {
				numHits++;
			}
		}
		
		// tests that the number of hits is reasonable. Proof is above
		Assert.assertEquals(50, numHits, 12);
		
		//test the tesla doesn't damage from afar
		for(int i = 0; i < 9; i++) 
			Assert.assertEquals(InteractionResult.NONE, testTesla.interact(gameBoard, i));
		for(int i = 12; i < GameEngine.BOARD_SIZE; i++) 
			Assert.assertEquals(InteractionResult.NONE, testTesla.interact(gameBoard, i));
	}
	
}
