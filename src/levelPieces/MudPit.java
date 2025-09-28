package levelPieces;
import gameEngine.Drawable;
public class MudPit implements Drawable {
	
	char symbol = 'M';
	String label = "Mud Pit";
	int local;
	
	public MudPit(int spawn) {
		local = spawn;
	}
	
	public int getLocation() {
		return local;
	}
	
	public void draw() {
		System.out.print(symbol);
	}
	
	public String toString() {
		return symbol + " - " + label ; 
	}
}
