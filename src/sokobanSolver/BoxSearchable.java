package sokobanSolver;

import levels.Level;
import levels.Position;

//extends CommonSearchable & connect between the sokoban solver & the searcher
//own a searcher and checking with it if box can reach from one position to another (consider the player moves too) 

public class BoxSearchable extends CommonSearchable{

	public BoxSearchable(Level lvl, Position firstPos, Position secondPos) {
		super(lvl, firstPos, secondPos);
		// TODO Auto-generated constructor stub
	}

}
