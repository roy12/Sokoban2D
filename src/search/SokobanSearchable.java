package search;

import java.util.ArrayList;

import Model.Policy.MovementPolicy;
import levels.GameObject;
import levels.Point2D;
import levels.Pointer2D;

public abstract class SokobanSearchable implements Searchable{
	private State initialState;
	private State goalState;
	
	@Override
	public State getInitialState() {
		// TODO Auto-generated method stub
		return initialState;
	}

	@Override
	public State getGoalState() {
		// TODO Auto-generated method stub
		return goalState;
	}

	
}
