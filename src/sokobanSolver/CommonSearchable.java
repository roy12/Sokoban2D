package sokobanSolver;
//implements Searchable and have all the Common methods of Boxsechable & Playersearchable
//TODO getters & setters & check all posible move (abstract)methods

import java.util.ArrayList;
import java.util.HashMap;

import levels.Level;
import levels.Position;
import search.Action;
import search.EnumAction;
import search.Searchable;
import search.State;

public abstract class CommonSearchable implements Searchable<Position> {

	private Level lvl;
	private Position firstPos;
	private Position secondPos;
	
	public CommonSearchable(Level lvl,Position firstPos,Position secondPos) {
		super();
		this.lvl=lvl;
		this.firstPos=firstPos;
		this.secondPos=secondPos;
	}
	
	public Level getLvl() {
		return lvl;
	}

	public void setLvl(Level lvl) {
		this.lvl = lvl;
	}

	public Position getFirstPos() {
		return firstPos;
	}

	public void setFirstPos(Position firstPos) {
		this.firstPos = firstPos;
	}

	public Position getSecondPos() {
		return secondPos;
	}

	public void setSecondPos(Position secondPos) {
		this.secondPos = secondPos;
	}	
	
	public State<Position> getInitialState() {
		State<Position> start=new State<>(null,0,firstPos,null);
		return start;
	}
	
	public State<Position> getGoalState() {
		State<Position> goal=new State<>(null,0,secondPos,null);
		return goal;
	}

	public abstract boolean checkPossibleMove(Position currentPosition,EnumAction ea);
		
}
