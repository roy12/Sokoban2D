package sokobanSolver;

import java.util.List;
import levels.Level;
import plan.PlanAction;
import plan.Strips;

public class SokSolver {
	
	private SokSolution solution;
	
	public SokSolution solveLevel(Level lvl) 
	{		
	SokPlannable sp=new SokPlannable(lvl);	
	Strips strips=new Strips(); 
	List<PlanAction> list=strips.plan(sp); 
	if (list==null)
	{
		System.out.println("no solution found");
	}
	solution=new SokSolution(list);		 
	return solution; 		 
	} 
}
