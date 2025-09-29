package tests;

import org.junit.jupiter.api.Assertions.*;

import levelPieces.*;
import gameEngine.GameEngine;
import gameEngine.Drawable;

public class TestMovingPieces {
/*
 * Test that the ghost goes back and forth properly with obstacles to hide behind
*/
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
}
