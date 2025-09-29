package tests;

import org.junit.Assert;
import org.junit.Test;

import levelPieces.*;
import gameEngine.GameEngine;
import gameEngine.Drawable;

public class TestMovingPieces {
	/*
	 * Test that the ghost goes back and forth properly with 
	 * obstacles to hide behind. The ghost will move across the
	 * board 3 times, so it should be at the end of the board
	 * after 3 traversals. It is also checked that the ghost
	 * never replaces or "stands in front" of the tesla and 
	 * mud pit at 5 and 10 respectively.
	*/
	@Test
	public void testGhost() {
		// set up board and ghost
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ghost testGhost = new Ghost('G', "testGhost", 0);
		gameBoard[0] = testGhost;
		
		// add obstacles (other pieces)
		Tesla testTesla = new Tesla('T', "teslaObstacle", 5);
		gameBoard[5] = testTesla;
		MudPit testMudPit = new MudPit(10);
		gameBoard[10] = testMudPit;		
		
		// create board and test movement with assert()
		for(int i = 0; i < 3*(GameEngine.BOARD_SIZE - 1); i++) {
			testGhost.move(gameBoard, 0);
			// make sure ghost doesn't replace any obstacles
			Assert.assertSame(testTesla, gameBoard[5]);
			Assert.assertSame(testMudPit, gameBoard[10]);
		}
		Assert.assertSame(testGhost, gameBoard[GameEngine.BOARD_SIZE - 1]);
	}
	
	/*
	 * Tests lobster random movement by placing a mud pit and
	 * tesla at 5 and 10. The lobster moves 100 times, and if
	 * it moves to a space it is recorded. Then check that every
	 * space was visited except 5 and 10.
	 * 
	 * Note: there is approximately a 0.38% chance that a space is 
	 * not landed on by random chance. Otherwise the test should 
	 * pass every other time.
	 */
	@Test
	public void testLobster() {
		// set up test environment
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Lobster testLobster = new Lobster('L', "testLobster", 0);
		gameBoard[0] = testLobster;
		
		// add obstacles (other pieces)
		gameBoard[5] = new Tesla('T', "teslaObstacle", 5);
		gameBoard[10] = new MudPit(10);
		
		// create array for all spaces to test for random movement
		boolean testBoolArray[] = new boolean[GameEngine.BOARD_SIZE];
		for(int i = 0; i < 100; i++) {
			testLobster.move(gameBoard, 0);
			// set true to show that a space has been visited
			testBoolArray[testLobster.getLocation()] = true;
		}
		
		// check array 
		int spotsVisited = 0;
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			//should never teleport on other objects
			if (i == 5 || i == 10) {
				Assert.assertEquals(false, testBoolArray[i]);
				continue;
			} else if(testBoolArray[i] == true) {
				spotsVisited++;
			}
		}
		//should have traveled to every other spot with the small 
		//chance that one spot was not visited
		Assert.assertEquals(19, spotsVisited);
	}
}
