package search;

import java.util.LinkedList;
import java.util.PriorityQueue;

public abstract class CommonSearcher implements Searcher {
	protected int evaluatedNodes;
	protected PriorityQueue<State> openList;
	
	public CommonSearcher () {
		openList=new PriorityQueue<State>();
		evaluatedNodes =0;
	}
	
	@Override
	public int getNumberOfNodesEvaluated() {		
		return evaluatedNodes;
	}
	
	/**
	 * how to get from state to state
	 * @param goalState
	 * @return
	 */
	protected Solution backTrace(State goalState) {
		LinkedList<Action> actions = new LinkedList<Action>();
		
		State currState = goalState;
		while (currState.getCameFrom() != null) {			
			actions.addFirst(currState.getAction());
			currState = currState.getCameFrom();
		}
		
		Solution sol = new Solution();
		sol.setActions(actions);
		return sol;
	}
	
	protected State popOpenList() {
		evaluatedNodes++;
		return openList.poll();
	}
	
	protected void addToOpenList(State s){
		this.openList.add(s);
	}
	
	protected boolean openListContains(State s){
		return this.openList.contains(s);
	}
}
