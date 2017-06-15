package sokobanSolver;

import java.util.List;
import levels.Level;
import plan.PlanAction;
import plan.Strips;

public class SokSolver {
	
	private SokSolution solution;
	
	public SokSolution solveLevel(Level lvl) 
	{ 
		SokPlannable ps=new SokPlannable(lvl); 
	Strips strips=new Strips(); 
	List<PlanAction> list=strips.plan(ps); 
	solution=new SokSolution(list);		 
	return solution; 		 
	} 


}
