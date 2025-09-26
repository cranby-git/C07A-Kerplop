package levelPieces;

import gameEngine.Drawable;

public class MudPit implements Drawable {
	
	char symbol = 'M';
	
	public void draw() {
		System.out.print(symbol);
	}
	
}
