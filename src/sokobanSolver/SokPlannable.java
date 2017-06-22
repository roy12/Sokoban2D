package sokobanSolver;
//implements Plannable
//try to satisfy predicates by action or "break" it to few predicates and updates

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import levels.GameObject;
import levels.Level;
import levels.Position;
import search.Action;
import search.BFS;
import search.EnumAction;
import search.Solution;
import plan.Clause;
import plan.PlanAction;
import plan.Plannable;
import plan.Predicate;

public class SokPlannable implements Plannable {
	
	private Level lvl;
	private Clause goal;
	private Clause kb;
	private BFS mainBFS;
	private BoxSearchable boxSearchable;
	private Position playerPosition;
	private LinkedList<Position> boxesPositions;
	
	
	
	public SokPlannable (Level lvl)
	{
		super();
		this.lvl=lvl;
		boxesPositions=new LinkedList<>();
		mainBFS=new BFS<>();
		if(lvl != null)
		{
			kb=new Clause(null); 
			goal=new Clause(null); 
			SokPredicate p = null; 
			Clause g = new Clause(null);
			int boxesCounter=1;
			
			for (int i=0;i<lvl.getWidth();i++)
			{
				for(int j=0;j<lvl.getHeight();j++)
				{	
					
					switch(lvl.getMap()[i][j].getType()) 
					{ 
					case 'A': 						
						p=new SokPredicate("PlayerAt", "Player", "("+i+","+j+")"); 
						playerPosition=new Position(i, j); 
						kb.update(p);					
						break; 
					case ' ': 						
						p=new SokPredicate("ClearAt", "("+i+","+j+")" , "("+i+","+j+")"); 
						kb.update(p);						
						break; 
					case '@': 					
						p=new SokPredicate("BoxAt", "b"+boxesCounter, "("+i+","+j+")"); 
						boxesPositions.add(new Position(i, j)); 
						kb.update(p);							 
						boxesCounter++;						
						break; 
					case 'o': 						
						p=new SokPredicate("ClearAt", "("+i+","+j+")" , "("+i+","+j+")"); 
						kb.update(p);						
						break;
					case '#':						
						break;
					}				
				}				
			}
			HashMap<String, String> hm= this.getBoxesAndDestCoupled(lvl);			
			for(String id : hm.keySet()) 
				{				
					p=new SokPredicate("BoxAt", id, hm.get(id));					
					goal.update(p); 
				}			
			boxSearchable=new BoxSearchable(playerPosition, playerPosition, lvl, mainBFS, new PlayerSearchable(lvl, playerPosition, playerPosition)); 
			boxSearchable.getPlayerSearchable().setCurrentBoxPositions(boxesPositions);		 
			
		}
	}
	
	private HashMap <String, String> getBoxesAndDestCoupled(Level lvl)
	{
		HashMap<String, String> coupleTable=new HashMap<>(); 
		ArrayList<Position> bl=new ArrayList<>(); 
		for( GameObject b : lvl.getBoxes())
		{
			bl.add(b.getPos());
		}
		ArrayList<Position> dl=new ArrayList<>();
		for (GameObject d : lvl.getTargets()) 
		{ 
			dl.add(d.getPos()); 
		}
		for(int i=0;i<dl.size();i++) 
		{ 
			coupleTable.put("b"+(i+1), dl.get(i).toString()); 
		} 
		return coupleTable;
	}
	
	
	

	@Override
	public Clause getGoal() {
		
		return this.goal;
	}

	@Override
	public Clause getKnowledgebase() {		
		return this.kb;
	}

	
	public Set<PlanAction> getSatisfyingActions(Predicate top) {		
		Set<PlanAction> satisfyingActions=null;
		Predicate boxKbPred=null; 
		Predicate playerKbPred=null; 
		Position playerPos=null,boxPos=null,goalPos=null;
		if(top.getType().equals("BoxAt"))
		{
			for(Predicate p : kb.getPredicates())
			{
				if(top.getId().equals(p.getId()))
				{
					boxKbPred=p;
				}
				if(p.getType().equals("PlayerAt"))
				{					
					playerKbPred=p;
				}				
			}
			
			playerPos=new Position(playerKbPred.getValue().toCharArray()[1]-48, playerKbPred.getValue().toCharArray()[3]-48);			
			boxPos=new Position(boxKbPred.getValue().toCharArray()[1]-48, boxKbPred.getValue().toCharArray()[3]-48); 
			goalPos=new Position(top.getValue().toCharArray()[1]-48, top.getValue().toCharArray()[3]-48); 		
			PlayerSearchable ps=new PlayerSearchable(lvl,playerPos, boxPos); 
			ps.setCurrentBoxPositions(boxesPositions); 
			BFS pbfs=new BFS<>(); 
			boxSearchable.setFirstPos(boxPos); 
			boxSearchable.setSecondPos(goalPos); 
			boxSearchable.setSearcher(pbfs); 
			boxSearchable.setPlayerPosition(playerPos); 
			boxSearchable.setCurrentBoxPositions(boxesPositions); 
			boxSearchable.setCurrentSearchableBox(boxPos);	
			Solution solution=mainBFS.search(boxSearchable); 
		
			
			if(solution != null)
			{
				
				playerPosition=(Position) mainBFS.getFinalState().getCameFrom().getState(); 
				boxesPositions.remove(boxPos); 
				boxesPositions.add(goalPos); 						 
				satisfyingActions=new HashSet<>(); 
				PlanAction pa=new PlanAction("MoveBox",top.getId() , top.getValue()); 
				pa.setEffects(new Clause( 
											new SokPredicate("BoxAt", pa.getId(), pa.getValue()), 
											new SokPredicate("PlayerAt", "Player", playerPosition.toString()), 
											new SokPredicate("ClearAt", playerPos.toString(), playerPos.toString()))); 
				pa.setPreConditions(new Clause(new SokPredicate("ClearAt", top.getValue(), top.getValue()))); 
				pa.setSubActions((LinkedList<EnumAction>) solution.getEa()); 
				satisfyingActions.add(pa); 
				} 
			else 
			{				
				return null;
			}
		}
		System.out.println("working");
		return satisfyingActions;		
	}
	private Clause getSolutionPreConditions(Solution solution,Position pos)
	{
		Clause pre=new Clause(null); 
		Position next=null; 
		EnumAction ea=null; 
		for(int i=0;i<solution.getEa().size()-1;i++) 
		{ 
			
		ea=solution.getEa().get(i);
		next=pos;
		
		switch(ea) 
		{ 
		case Up: 
			next.setX(next.getX()-1);
			break; 
		case Down: 
			next.setX(next.getX()+1); 
			break; 
		case Left: 
			next.setY(next.getY()-1);
			break; 
		case Right: 
			next.setY(next.getY()+1);	
			break; 
		} 
		pre.update(new Predicate("ClearAt", next.toString(), next.toString())); 
		pos=next;
		}

		return pre;
	}
}
