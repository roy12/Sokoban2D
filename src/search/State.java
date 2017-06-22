package search;

import java.util.List;

import levels.Level;
import levels.Position;

public class State<T> {
	private State<T> cameFrom;
	private Action action;
	private T state;
	private double cost;
	
	
	public State(State<T> s) {
		this.cameFrom=s.cameFrom;
		this.action=s.action;
		this.state=s.state;
		this.cost=s.cost;
	}
	public State(State<T> cameFrom,double cost,T state,Action a)
	{
		this.cameFrom=cameFrom;
		this.cost=cost;
		this.state=state;
		this.action=a;
	}	
	public State() {
		super();		
		this.cameFrom=null;
		this.cost=1000;
		this.action=null;
		this.state=null;
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
	public boolean equals(Object obj)
	{		
		return state.equals(((State)obj).state);		
	}
	public int hashCode()
	{
		return state.hashCode();		
	}
}
