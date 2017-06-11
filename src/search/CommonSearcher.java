package search;

import java.util.LinkedList;
import java.util.PriorityQueue;

public abstract class CommonSearcher<T> implements Searcher<T> {
	protected int evaluatedNodes;
	protected PriorityQueue<State<T>> openList;
	
	public CommonSearcher () {
		openList=new PriorityQueue<State<T>>();
		evaluatedNodes =0;
	}
	
	public int getNumberOfNodesEvaluated() {		
		return evaluatedNodes;
	}
	
	/**
	 * how to get from state to state
	 * @param goalState
	 * @return
	 */
	protected Solution backTrace(State<T> goalState) {
		LinkedList<Action> actions = new LinkedList<Action>();
		
		State<T> currState = goalState;
		while (currState.getCameFrom() != null) {			
			actions.addFirst(currState.getAction());
			currState = currState.getCameFrom();
		}
		
		Solution sol = new Solution();
		sol.setActions(actions);
		return sol;
	}
	
	protected State<T> popOpenList() {
		evaluatedNodes++;
		return openList.poll();
	}
	
	protected void addToOpenList(State<T> s){
		this.openList.add(s);
	}
	
	protected boolean openListContains(State<T> s){
		return this.openList.contains(s);
	}
}
