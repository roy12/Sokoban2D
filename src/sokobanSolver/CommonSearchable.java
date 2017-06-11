package sokobanSolver;
//implements Searchable and have all the Common methods of Boxsechable & Playersearchable
//TODO getters & setters & check all posible move (abstract)methods

import java.util.ArrayList;

import levels.Level;
import levels.Pointer2D;
import search.Searchable;
import search.State;

public class CommonSearchable implements Searchable<Pointer2D> {

	private Level lvl;
	private Pointer2D firstPos;
	private Pointer2D secondPos;
	
	@Override
	public State getInitialState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getGoalState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<State<Pointer2D>> getAllPossibleStates(State s) {
		// TODO Auto-generated method stub
		return null;
	}

}
