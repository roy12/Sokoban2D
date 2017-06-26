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
	private LinkedList<Position> currentBoxPositions;
	private Position currentSearchableBox;
	
	public void print()
	{
		System.out.println(searcher);
		System.out.println(playerSearchable);
		System.out.println(playerPosition);
		System.out.println(charMap);
		System.out.println(currentBoxPositions);
		System.out.println(currentSearchableBox);
	}

	public BoxSearchable (Position firstPos, Position secondPos, Level lvl,Searcher<Position> searcher,PlayerSearchable playerSearchable) {
		super(lvl,firstPos, secondPos);		
		currentBoxPositions=new LinkedList<>();
		for(GameObject it : lvl.getBoxes())
			currentBoxPositions.add(it.getPos());
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
	{	switch(action)
		{
		case Up:
			return boxPos.getDown();
		case Down:
			return boxPos.getUp();
		case Right:
			return boxPos.getLeft();
		case Left:
			return boxPos.getRight();
		}
	return null;
	}
	
	public Position getBoxNextPos (Position boxPos,EnumAction action)
	{		
		switch(action)
		{
		case Up:
			return boxPos.getUp();
		case Down:
			return boxPos.getDown();
		case Right:
			return boxPos.getRight();
		case Left:
			return boxPos.getLeft();
		}
		return null;
	}
	
	public HashMap<Action, State<Position>> getAllPossibleStates(State<Position> s)
	{
		Position temp=null; 
		//updating player/box positions for checking possibles moves 
		if(s.getCameFrom()!=null)//its not the initial state 
		{ 
		temp=s.getCameFrom().getState(); 
		playerPosition=temp; 
		currentBoxPositions.remove(currentSearchableBox); 
		currentBoxPositions.add(s.getState()); 
		playerSearchable.setCurrentBoxPositions(currentBoxPositions); 
		//System.out.println(currentBoxPositions); 
		} 
				 		 
		Solution playerPath=null; 
		playerSearchable.setFirstPos(playerPosition); 
		playerSearchable.setLvl(getLvl()); 
		State<Position> state=null; 
		Position boxNextPos=null; 
		Action a=null; 
		HashMap<Action, State<Position>> possibleStates=new HashMap<>(); 
		Position boxPos=s.getState(); 
		for(EnumAction action: EnumAction.values()) 
		{ 
			if(this.checkPossibleMove(boxPos, action)) 
		 	{ 
				playerSearchable.setFirstPos(playerPosition); 
		 		playerSearchable.setSecondPos(this.getPlayerNextPos(boxPos, action)); 
		 		playerSearchable.setLvl(getLvl()); 
		 		playerPath=searcher.search(playerSearchable); 
		 		if(playerPath!=null) 
		 		{ 
		 			boxNextPos=this.getBoxNextPos(boxPos, action); 
		 			a=new Action(action, (LinkedList<EnumAction>) playerPath.getEa()); 
		 			state=new State<Position>(s, s.getCost()+1,boxNextPos , a); 
					possibleStates.put(a, state); 
				} 
			} 
		}
		
		if(s.getCameFrom()!=null) 
		{ 
		 currentBoxPositions.remove(s.getState()); 
		 currentBoxPositions.add(currentSearchableBox); 
		//System.out.println(currentBoxPositions); 
		} 
		return possibleStates; 
	}
	
	
	public boolean checkPossibleMove(Position currentPosition, EnumAction ea)
	{
		Position playerPos=null; 
		Position goalPos=null; 
		switch(ea)
		{
		case Up:
			playerPos=currentPosition.getDown(); 
			goalPos=currentPosition.getUp(); 
			break; 

		case Down:
			playerPos=currentPosition.getUp(); 
			goalPos=currentPosition.getDown();			 
			break; 

		case Right:
			playerPos=currentPosition.getLeft(); 
			goalPos=currentPosition.getRight(); 
			break; 

		case Left:
			playerPos=currentPosition.getRight(); 
			goalPos=currentPosition.getLeft(); 
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
				for(Position pos:this.currentBoxPositions)
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

	public LinkedList<Position> getCurrentBoxPositions() {
		return currentBoxPositions;
	}

	public void setCurrentBoxPositions(LinkedList<Position> currentBoxPositions) {
		this.currentBoxPositions = currentBoxPositions;
	}

	public Position getCurrentSearchableBox() {
		return currentSearchableBox;
	}

	public void setCurrentSearchableBox(Position currentSearchableBox) {
		this.currentSearchableBox = currentSearchableBox;
	}
	
	
	
}
