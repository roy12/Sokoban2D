package search;

import levels.Level;

public class State extends Level {
	private State cameFrom;
	private Action action;
	
	public State getCameFrom(){
		return cameFrom;
	}
	
	public void setCameFrom(State s){
		cameFrom = s;
	}
	
	public Action getAction() {
		return action;
	}
}
