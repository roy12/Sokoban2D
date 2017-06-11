package sokobanSolver;
//implements Searchable and have all the Common methods of Boxsechable & Playersearchable
//TODO getters & setters & check all posible move (abstract)methods

import java.util.ArrayList;

import levels.Level;
import levels.Position;
import search.Searchable;
import search.State;

public class CommonSearchable implements Searchable<Position> {

	private Level lvl;
	private Position firstPos;
	private Position secondPos;
	
	public CommonSearchable(Level lvl,Position firstPos,Position secondPos) {
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

	
	@Override
	public State<Position> getInitialState() {
		
		return null;
	}

	@Override
	public State<Position> getGoalState() {
		
		return null;
	}

	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State s) {
		
		return null;
	}
}
