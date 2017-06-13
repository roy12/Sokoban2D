package search;

import java.util.ArrayList;
import java.util.HashMap;

import levels.Position;

public interface Searchable<T> {
	public State<T> getInitialState();
	public State<T> getGoalState();
	public HashMap<Action,State<T>> getAllPossibleStates(State<T> s);
}
