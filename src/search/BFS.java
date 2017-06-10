package search;

import java.util.ArrayList;
import java.util.HashSet;


public class BFS extends CommonSearcher {

	@Override
	public int getNumberOfNodesEvaluated() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Solution search(Searchable s) {
		addToOpenList(s.getInitialState());
		HashSet<State> closedSet=new HashSet<State>();
		while(openList.size() > 0){
			State n=popOpenList();// dequeue
			closedSet.add(n);
			if(n.equals(s.getGoalState()))
				//return backTrace(s.getGoalState(), s.getInitialState());
				return backTrace(s.getGoalState());
			
			// private method, back traces through the parents
			ArrayList<State> successors=s.getAllPossibleStates(n); //however it is implemented
			for(State state : successors){
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
