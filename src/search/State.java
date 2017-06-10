package search;

import levels.Level;

public class State extends Level {
	private State cameFrom;
	private Action action;
	private Level lvl;
	
	public State(State s) {
		this.cameFrom=s.cameFrom;
		this.action=s.action;
		this.lvl=s.lvl;
	}
	
	public State getCameFrom(){
		return cameFrom;
	}
	
	public void setCameFrom(State s){
		cameFrom = s;
	}
	
	public Action getAction() {
		return action;
	}

	public Level getLvl() {
		return lvl;
	}

	public void setLvl(Level lvl) {
		this.lvl = lvl;
	}
}
