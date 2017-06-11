package search;

import levels.Level;

public class State<T> {
	private State<T> cameFrom;
	private Action action;
	private Level lvl;
	
	public State(State<T> s) {
		this.cameFrom=s.cameFrom;
		this.action=s.action;
		this.lvl=s.lvl;
	}
	
	public State<T> getCameFrom(){
		return cameFrom;
	}
	
	public void setCameFrom(State<T> s){
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
