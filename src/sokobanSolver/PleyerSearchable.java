package sokobanSolver;

import levels.Level;
import levels.Position;

//extends CommonSearchable & connect between the sokoban solver & the searcher
//own a searcher and checking with it if a player can reach from one position to another

public class PleyerSearchable extends CommonSearchable {

	public PleyerSearchable(Level lvl, Position firstPos, Position secondPos) {
		super(lvl, firstPos, secondPos);
		// TODO Auto-generated constructor stub
	}

}
