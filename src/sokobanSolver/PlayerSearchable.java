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
	
	private LinkedList<Position> BoxPositions;
	private char[][] charMap;

	public PlayerSearchable(Level lvl, Position firstPos, Position secondPos) {
		super(lvl, firstPos, secondPos);
		// TODO Auto-generated constructor stub
	}

	public void setCurrentBoxPos(LinkedList<Position> boxPosition) {
		// TODO Auto-generated method stub
		
	}

	public LinkedList<Position> getBoxPositions() {
		return BoxPositions;
	}

	public void setBoxPositions(LinkedList<Position> boxPositions) {
		BoxPositions = boxPositions;
	}
	
	public HashMap<Action, State<Position>> getAllPossibleStates(State<Position> s)
	{
		HashMap<Action,State<Position>> possibleStates=new HashMap<>();
		Position currentPos=s.getState();
		Position pos=currentPos;
		if(checkPossibleMove(currentPos,EnumAction.Up))
		{			
			pos.setX(pos.getX()-1);
			possibleStates.put(new Action(EnumAction.Up,null), new State<>(s,s.getCost()+1,pos,new Action(EnumAction.Up, null)));
		}
		if(checkPossibleMove(currentPos,EnumAction.Down))
		{			
			pos.setX(pos.getX()+1);
			possibleStates.put(new Action(EnumAction.Down,null), new State<>(s,s.getCost()+1,pos,new Action(EnumAction.Down, null)));
		}
		if(checkPossibleMove(currentPos,EnumAction.Right))
		{			
			pos.setY(pos.getY()+1);
			possibleStates.put(new Action(EnumAction.Right,null), new State<>(s,s.getCost()+1,pos,new Action(EnumAction.Right, null)));
		}
		if(checkPossibleMove(currentPos,EnumAction.Left))
		{			
			pos.setY(pos.getY()-1);
			possibleStates.put(new Action(EnumAction.Left,null), new State<>(s,s.getCost()+1,pos,new Action(EnumAction.Left, null)));
		}
		
		return possibleStates;
	}
	
	public boolean checkPossibleMove(Position currentPos,EnumAction ea)
	{
		char c;
		GameObject go=null;
		Position pos=currentPos;
		
		switch(ea)
		{
		case Up:
			pos.setX(pos.getX()-1);
			break;
		case Down:
			pos.setX(pos.getX()+1);
			break;
		case Right:
			pos.setY(pos.getY()+1);
			break;
		case Left:
			pos.setY(pos.getY()-1);
			break;	
		}
		
		if (pos!=currentPos && pos!=null)
		{
			if(this.getLvl().posiblePosition(pos))
			{
				for(Position p : BoxPositions)
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
