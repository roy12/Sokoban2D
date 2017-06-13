package search;

import java.util.List;

import levels.Level;
import levels.Position;

public class State<T> {
	private State<T> cameFrom;
	private Action action;
	private Level lvl;
	private T state;
	private double cost;
	private List<Position> boxesPos;
	
	public State(State<T> s) {
		this.cameFrom=s.cameFrom;
		this.action=s.action;
		this.lvl=s.lvl;		
	}
	public State(State<T> cameFrom,double cost,T state,Action a)
	{
		this.cameFrom=cameFrom;
		this.cost=cost;
		this.state=state;
		this.action=a;
	}
	
	public State() {
		// TODO Auto-generated constructor stub
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

	public T getState() {
		return state;
	}

	public void setState(T state) {
		this.state = state;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setAction(Action action) {
		this.action = action;
	}
}
