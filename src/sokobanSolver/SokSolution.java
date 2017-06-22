package sokobanSolver;

import java.util.LinkedList;
import java.util.List;

import plan.PlanAction;
import search.EnumAction;

public class SokSolution {
	
	private List<EnumAction> solution;
	
	public SokSolution(List<PlanAction> solutionList) 
	{ 
		super();
		if (solutionList!=null)
		{
			solution=new LinkedList<>(); 
			for (PlanAction pa : solutionList) 
			{ 
				for(EnumAction action : pa.getSubActions()) 
				{ 
					solution.add(action); 
				} 
			}
		}
		else
		{
			solution=null;
		}
	}
	
	public void print() 
	{ 
		System.out.println("Solution is: "); 
		System.out.println(toString()); 
	} 
	
	public String toString() 
	{ 
		String str=""; 
		for(EnumAction ea : solution) 
		{ 
			str+=ea.toString(); 
			str+=" "; 
		}		
	return str; 
	} 


}
