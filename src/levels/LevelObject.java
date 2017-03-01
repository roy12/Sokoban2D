package levels;

import java.io.Serializable;

public class LevelObject implements Serializable {
	private Point2D position;
	
	public char getChar(LevelObject lo){
		if (lo instanceof Wall)
			return '#';
		else if(lo instanceof Player)
			return 'A';
		else if (lo instanceof Crate)
			return '@';
		else if (lo instanceof Target)
			return 'o';
		return ' ';
	}
	public LevelObject() {
		// TODO Auto-generated constructor stub
	}
}
