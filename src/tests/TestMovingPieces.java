package tests;

import org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Test;

import levelPieces.*;
import gameEngine.GameEngine;
import gameEngine.Drawable;

public class TestMovingPieces {
	/*
	 * Test that the ghost goes back and forth properly with obstacles to hide behind
	*/
	@Test
	public void testGhost() {
		// set up board and ghost
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ghost testGhost = new Ghost('G', "testGhost", 1);
		gameBoard[1] = testGhost;
		
		// add obstacles (other pieces)
		gameBoard[5] = new Tesla('T', "teslaObstacle", 5);
		gameBoard[10] = new MudPit(10);
		
		// create board and test movement with assert()
		for(int i = 0; i < 3*(GameEngine.BOARD_SIZE - 1); i++) {
			testGhost.move(gameBoard, 0);
			// make sure ghost doesn't replace any obstacles
			assert(gameBoard[5] != testGhost);
			assert(gameBoard[10] != testGhost);
		}
		assert(gameBoard[GameEngine.BOARD_SIZE - 1] == testGhost);
	}
	
	/*
	 * 
	 */
	@Test
	public void testLobster() {
		// set up test environment
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Lobster testLobster = new Lobster('L', "testLobster", 1);
		gameBoard[1] = testLobster;
		
		// add obstacles (other pieces)
		gameBoard[5] = new Tesla('T', "teslaObstacle", 5);
		gameBoard[10] = new MudPit(10);
		
		// create array for all spaces to test for random movement
		Boolean testBoolArray[] = new Boolean[GameEngine.BOARD_SIZE];
		for(int i = 0; i < 100; i++) {
			testLobster.move(gameBoard, 0);
			// set true to show that a space has been visited
			testBoolArray[testLobster.getLocation()] = true;
		}
		
		// check array 
		for(int i = 0; i < GameEngine.BOARD_SIZE - 1; i++) {
			//should never teleport on other objects
			if (i == 5 || i == 10) {
				Assert.assertEquals(false, testBoolArray[i]);
				continue;
			}
			//should have traveled to every other spot
			Assert.assertEquals(true, testBoolArray[i]);
		}
		
	}
}
