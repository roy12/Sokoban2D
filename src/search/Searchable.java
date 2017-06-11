package search;

import java.util.ArrayList;

public interface Searchable<T> {
	public State<T> getInitialState();
	public State<T> getGoalState();
	ArrayList<State<T>> getAllPossibleStates(State<T> s);
}
