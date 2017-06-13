package sokobanSolver;

import java.util.ArrayList;
import java.util.HashMap;

import levels.GameObject;
import levels.Level;
import levels.Position;
import search.Action;
import search.EnumAction;
import search.Searchable;
import search.State;

public class SokSearchable implements Searchable<SokState> {

	private Level lvl;
	private State <SokState> initialstate;
	private State <SokState> goalstate;
	
	public SokSearchable(Level lvl) {
		super();
		this.lvl=lvl;
		this.initInitialState();
		this.initGoalState();		
	}
	
	public void setInitialstate(State <SokState> initialstate) {
		this.initialstate = initialstate;
	}

	public void setGoalstate(State <SokState> goalstate) {
		this.goalstate = goalstate;
	}
	@Override
	public State<SokState> getInitialState() {	
		return initialstate;
	}
	@Override
	public State<SokState> getGoalState() {	
		return goalstate;
	}
	@Override
	public HashMap<Action, State<SokState>> getAllPossibleStates(State<SokState> s) {
		HashMap<Action,State<SokState>> possibleStates=new HashMap<>(); 
		State<SokState> resultState=null; 
		Position playerPos=null;
		//TODO

		return possibleStates;
	}

	public Level getLvl() {
		return lvl;
	}

	public void setLvl(Level lvl) {
		this.lvl = lvl;
	}
	public void initGoalState()
	{
		if(lvl!=null)
		{
			SokState inerState=new SokState();
			inerState.setPlayerPosition(lvl.getPl());
			ArrayList<GameObject> targetst=lvl.getTargets();
			ArrayList<Position> positionList=new ArrayList<>();
			for(GameObject d: targetst)
				positionList.add(d.getPos());
			inerState.setBoxPosition(positionList);
			State<SokState> returnState=new State<>(null,1000,inerState,null);
			this.goalstate=returnState;
			System.out.println("goal state:"+goalstate.getState().getPlayerPosition()+" "+goalstate.getState().getBoxPosition().get(0));
		}
	}
	public void initInitialState()
	{
		if(lvl!=null)
		{
			SokState inerState=new SokState();
			inerState.setPlayerPosition(lvl.getPl());	
			ArrayList<GameObject> boxes=lvl.getBoxes();
			ArrayList<Position> positionList=new ArrayList<>();
			for(GameObject b: boxes)
				positionList.add(b.getPos());
			inerState.setBoxPosition(positionList);
			State<SokState> returnState=new State<>(null,1000,inerState,null);
			this.goalstate=returnState;
			System.out.println("goal state:"+goalstate.getState().getPlayerPosition()+" "+goalstate.getState().getBoxPosition().get(0));
		}
	}
	public boolean checkDirection(Position PlayerPos,EnumAction ea)
	{
		Position firstPos=PlayerPos;
		Position secondPos=PlayerPos;
		
		switch(ea)
		{
		case Up:			
			firstPos.setX(firstPos.getX()-1);
			secondPos.setX(secondPos.getX()-2);
			break;
		case Down:			
			firstPos.setX(firstPos.getX()+1);
			secondPos.setX(secondPos.getX()+2);
			break;
		case Right:			
			firstPos.setY(firstPos.getY()+1);
			secondPos.setY(secondPos.getY()+2);
			break;
		case Left:			
			firstPos.setY(firstPos.getY()-1);
			secondPos.setY(secondPos.getY()-2);
			break;		
		}
		if(!(lvl.getGameObjectByPosition(firstPos)==null))
		{
			if(lvl.getGameObjectByPosition(firstPos).getChar()==' ')
				return true;
			if(lvl.getGameObjectByPosition(firstPos).getChar()=='@')
			{
				if((lvl.getGameObjectByPosition(secondPos).getChar()==' ')||(lvl.getGameObjectByPosition(secondPos).getChar()=='o'))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
	public State<SokState> createState(State<SokState> state, Action action)
	{
		Position firstPos=state.getLvl().getPl();
		Position secondPos=state.getLvl().getPl();
		State<SokState> createdState=new State();
		switch (action.getEa()) 
		{
		case Up:			
			firstPos.setX(firstPos.getX()-1);
			secondPos.setX(secondPos.getX()-2);
			break;
		case Down:			
			firstPos.setX(firstPos.getX()+1);
			secondPos.setX(secondPos.getX()+2);
			break;
		case Right:			
			firstPos.setY(firstPos.getY()+1);
			secondPos.setY(secondPos.getY()+2);
			break;
		case Left:			
			firstPos.setY(firstPos.getY()-1);
			secondPos.setY(secondPos.getY()-2);
			break;	
		}
		createdState.setState(new SokState());
		for (Position p: state.getState().getBoxPosition())
		{
			if(p.equals(firstPos))
			{
				//createdState.getstate().getBoxPosition().add(secondPos);
			}
			else
			{
				//createdState.getstate().getBoxPosition().add(p);
			}
		
		}
		createdState.getState().setPlayerPosition(firstPos);
		createdState.setAction(action); 
		System.out.println("new state: "+createdState.getState()+" "+createdState.getAction()); 
		return createdState; 		
	}

}
