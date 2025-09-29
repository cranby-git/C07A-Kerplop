package tests;

import levelPieces.*;
import gameEngine.GameEngine;
import gameEngine.Drawable;

public class TestMovingPieces {
/*
 * Test that the ghost goes back and forth properly with obstacles
*/
	public void testGhost() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ghost testGhost = new Ghost('T', "testGhost", 1);
		
		// create board and test movement with assertEquals()
	}
}
