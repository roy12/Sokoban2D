package sokobanSolver;

import java.util.HashMap;
import java.util.LinkedList;

import levels.GameObject;
import levels.Level;
import levels.Position;
import search.Action;
import search.EnumAction;
import search.Searcher;
import search.Solution;
import search.State;


//extends CommonSearchable & connect between the sokoban solver & the searcher
//own a searcher and checking with it if box can reach from one position to another (consider the player moves too) 

public class BoxSearchable extends CommonSearchable{
	
	private Searcher<Position> searcher ;
	private PlayerSearchable playerSearchable;
	private Position playerPosition;
	private char [][] charMap;
	private LinkedList<Position> boxPosition;
	private Position currentBoxSearchable;
	

	public BoxSearchable (Position firstPos, Position secondPos, Level lvl,Searcher<Position> searcher,PlayerSearchable playerSearchable) {
		super(lvl,firstPos, secondPos);
		boxPosition=new LinkedList<>();
		for(GameObject it : lvl.getBoxes())
			boxPosition.add(it.getPos());
		this.searcher=searcher;
		this.playerSearchable=playerSearchable;
		if(playerSearchable!=null)
			this.playerPosition=playerSearchable.getFirstPos();
		initCharMap();
	}


	private void initCharMap() {
		
		GameObject[][] objectMap=this.getLvl().getMap();
		if(this.getLvl()!=null)
		{
			int width=this.getLvl().getWidth();
			int hight=this.getLvl().getHeight();
			charMap=new char[hight][width];
			for(int i=0;i<hight;i++)
			{
				for(int j=0;j<width;j++)
				{
					charMap[i][j]=objectMap[i][j].getChar();
				}
			}
		}		
		
	}
	
	public char[][] getCharMap() {
		return charMap;
	}


	public void setCharMap(char[][] charMap) {
		this.charMap = charMap;
	}

	public Position getPlayerNextPos (Position boxPos,EnumAction action)
	{
		Position pos=boxPos;
		switch(action)
		{
		case Up:
			pos.setX(pos.getX()+1);
		case Down:
			pos.setX(pos.getX()-1);
		case Right:
			pos.setY(pos.getY()-1);
		case Left:
			pos.setY(pos.getY()+1);	
		}
		return pos;
	}
	
	public Position getBoxNextPos (Position boxPos,EnumAction action)
	{
		Position pos=boxPos;
		switch(action)
		{
		case Up:
			pos.setX(pos.getX()-1);
		case Down:
			pos.setX(pos.getX()+1);
		case Right:
			pos.setY(pos.getY()+1);
		case Left:
			pos.setY(pos.getY()-1);	
		}
		return pos;
	}
	
	public HashMap<Action, State<Position>> getAllPossibleStates(State<Position> s)
	{
		Position temp=null;
		if(s.getCameFrom()!=null)
		{
			temp=s.getCameFrom().getState();
			playerPosition=temp;
			boxPosition.remove(currentBoxSearchable);
			boxPosition.add(s.getState());
			playerSearchable.setCurrentBoxPos(boxPosition);
		}
		
		Solution playerPath=null;
		playerSearchable.setFirstPos(playerPosition);
		playerSearchable.setLvl(getLvl());
		State <Position> state=null;
		Position boxNextPos=null;
		Action a=null;
		HashMap<Action, State<Position>> possibleStates=new HashMap<>();
		Position boxPos=s.getState();
		for(EnumAction action:EnumAction.values())
		{
			if(this.checkPossibleMove(boxPos,action))
			{
				playerSearchable.setFirstPos(playerPosition);
				playerSearchable.setSecondPos(this.getPlayerNextPos(boxPos, action));
				playerSearchable.setLvl(getLvl());
				playerPath=searcher.search(playerSearchable);
				if(playerPath!=null)
				{
					boxNextPos=this.getBoxNextPos(boxPos, action);
					//a=new Action(action,playerPath.getActionList())
					state=new State<Position>(s,s.getCost()+1,boxNextPos,a);
					possibleStates.put(a, state);
				}
			}
		}
		if(s.getCameFrom()!=null)
		{
			boxPosition.remove(s.getState());
			boxPosition.add(currentBoxSearchable);
		}
		
		return possibleStates;
	}
	
	public boolean checkPossibleMove(Position currentPosition, EnumAction ea)
	{
		Position playerPos=null;
		Position goalPos=null;
		Position pos1=currentPosition;
		Position pos2=currentPosition;
		switch(ea)
		{
		case Up:
			pos1.setX(pos1.getX()+1);
			pos2.setX(pos2.getX()-1);
			playerPos=pos1;
			goalPos=pos2;
			break;
		case Down:
			pos1.setX(pos1.getX()-1);
			pos2.setX(pos2.getX()+1);
			playerPos=pos1;
			goalPos=pos2;
			break;
		case Right:
			pos1.setY(pos1.getY()-1);
			pos2.setY(pos2.getY()+1);
			playerPos=pos1;
			goalPos=pos2;
			break;
		case Left:
			pos1.setY(pos1.getY()+1);
			pos2.setY(pos2.getY()-1);
			playerPos=pos1;
			goalPos=pos2;
			break;
		}
		if(this.getLvl().posiblePosition(playerPos)&&this.getLvl().posiblePosition(goalPos))
		{
			char player=charMap[playerPos.getX()][playerPos.getY()];
			char goal=charMap[goalPos.getX()][goalPos.getY()];
			if((player=='A'||player=='o'||player==' ')&&(goal=='A'||goal=='o'||goal==' '))
				return true;
			else if(player=='#'||goal=='#')
				return false;
			else
			{
				for(Position pos:this.boxPosition)
				{
					if(playerPos.equals(pos)||goalPos.equals(pos))
						return false;
				}
				return true;
			}
		}
		return false;
	}


	public Searcher<Position> getSearcher() {
		return searcher;
	}


	public void setSearcher(Searcher<Position> searcher) {
		this.searcher = searcher;
	}


	public PlayerSearchable getPlayerSearchable() {
		return playerSearchable;
	}


	public void setPlayerSearchable(PlayerSearchable playerSearchable) {
		this.playerSearchable = playerSearchable;
	}


	public Position getPlayerPosition() {
		return playerPosition;
	}


	public void setPlayerPosition(Position playerPosition) {
		if(playerSearchable!=null)
			playerSearchable.setFirstPos(playerPosition);
		this.playerPosition = playerPosition;
	}


	public LinkedList<Position> getBoxPosition() {
		return boxPosition;
	}


	public void setBoxPosition(LinkedList<Position> boxPosition) {
		this.boxPosition = boxPosition;
	}


	public Position getCurrentBoxSearchable() {
		return currentBoxSearchable;
	}


	public void setCurrentBoxSearchable(Position currentBoxSearchable) {
		this.currentBoxSearchable = currentBoxSearchable;
	}
	
	
	
}
