package search;

import java.util.ArrayList;

public class SokobanSearchable implements Searchable{
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

	@Override
	public ArrayList<State> getAllPossibleStates(State s) {
		/**
		 * complete 
		 */
		ArrayList<State> posStates=new ArrayList<>();
		
		
		//return posStates;
		
	}
}
