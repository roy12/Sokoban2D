package search;

import java.util.ArrayList;
import java.util.HashSet;


public class BFS<T> extends CommonSearcher<T> {

	@Override
	public int getNumberOfNodesEvaluated() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Solution search(Searchable<T> s) {
		addToOpenList(s.getInitialState());
		HashSet<State<T>> closedSet=new HashSet<State<T>>();
		while(openList.size() > 0){
			State<T> n=popOpenList();// dequeue
			closedSet.add(n);
			if(n.equals(s.getGoalState()))
				//return backTrace(s.getGoalState(), s.getInitialState());
				return backTrace(s.getGoalState());
			
			// private method, back traces through the parents
			ArrayList<State<T>> successors=s.getAllPossibleStates(n); //however it is implemented
			for(State<T> state : successors){
				if(!closedSet.contains(state) && !openListContains(state)){
					state.setCameFrom(n);
					addToOpenList(state);
				} else{
					// else do nothing
				}
			}
		}
		// throw exception or return null;
		return null;
	}
}
