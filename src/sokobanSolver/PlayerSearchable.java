package sokobanSolver;

import java.util.HashMap;
import java.util.LinkedList;
import levels.GameObject;
import levels.Level;
import levels.Position;
import levels.Wall;
import search.Action;
import search.EnumAction;
import search.State;

//extends CommonSearchable & connect between the sokoban solver & the searcher
//own a searcher and checking with it if a player can reach from one position to another

public class PlayerSearchable extends CommonSearchable {
	
	private LinkedList<Position> currentBoxPositions;
	private char[][] charMap;

	public PlayerSearchable(Level lvl, Position firstPos, Position secondPos) {
		super(lvl, firstPos, secondPos);
	
	}	
	
	public LinkedList<Position> getCurrentBoxPositions() {
		return currentBoxPositions;
	}

	public void setCurrentBoxPositions(LinkedList<Position> currentBoxPositions) {
		this.currentBoxPositions = currentBoxPositions;
	}

	public HashMap<Action, State<Position>> getAllPossibleStates(State<Position> s)
	{
		HashMap<Action,State<Position>> possibleStates=new HashMap<>();
		Position currentPos=s.getState();		
		if(checkPossibleMove(currentPos,EnumAction.Up))
		{				
			possibleStates.put(new Action(EnumAction.Up,null), new State<Position>(s,s.getCost()+1,currentPos.getUp(),new Action(EnumAction.Up, null)));
		}
		if(checkPossibleMove(currentPos,EnumAction.Down))
		{			
			possibleStates.put(new Action(EnumAction.Down,null), new State<Position>(s,s.getCost()+1,currentPos.getDown(),new Action(EnumAction.Down, null)));
		}
		if(checkPossibleMove(currentPos,EnumAction.Right))
		{				
			possibleStates.put(new Action(EnumAction.Right,null), new State<Position>(s,s.getCost()+1,currentPos.getRight(),new Action(EnumAction.Right, null)));
		}
		if(checkPossibleMove(currentPos,EnumAction.Left))
		{			
			possibleStates.put(new Action(EnumAction.Left,null), new State<Position>(s,s.getCost()+1,currentPos.getLeft(),new Action(EnumAction.Left, null)));
		}
		
		return possibleStates;
	}
	
	public boolean checkPossibleMove(Position currentPos,EnumAction ea)
	{	
		GameObject go=null;
		Position pos=null;
		
		switch(ea)
		{
		case Up:
			pos=currentPos.getUp();
			break;
		case Down:
			pos=currentPos.getDown();
			break;
		case Right:
			pos=currentPos.getRight();
			break;
		case Left:
			pos=currentPos.getLeft();
			break;	
		}
		
		if (pos!=currentPos && pos!=null)
		{
			if(this.getLvl().posiblePosition(pos))
			{
				for(Position p : currentBoxPositions)
				{
					if(pos.equals(p))
						return false;
				}
				
				go=this.getLvl().getGameObjectByPosition(pos);
				if(go instanceof Wall)
					return false;
				return true;
			}
			else
				return false;
		}
		
		return false;
	}

	public char[][] getCharMap() {
		return charMap;
	}

	public void setCharMap(char[][] charMap) {
		this.charMap = charMap;
	}

}
