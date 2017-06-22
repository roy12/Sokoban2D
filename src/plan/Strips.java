package plan;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import search.Action;

public class Strips  implements Planner{

	private Plannable myPlannable;

	@Override
	public List<PlanAction> plan(Plannable plannable)
	{		
		Stack<Predicate> predicatesStack = new Stack<>();
		LinkedList<PlanAction> plan=new LinkedList<>();
		this.myPlannable = plannable;
		predicatesStack.push(plannable.getGoal());
		Predicate topPredicate = null;		
		while (!predicatesStack.isEmpty()) {			
			topPredicate = predicatesStack.peek();		
			if (!(topPredicate instanceof PlanAction))
			{System.out.println("1");			
				if (!plannable.getKnowledgebase().satisfies(topPredicate))//unsatisfied
				{		System.out.println("2");			
					if(topPredicate instanceof Clause)//multiple and unsatisfied
					{				System.out.println("3");
						Clause c=(Clause) topPredicate;
						for(Predicate p : c.getPredicates() )
							predicatesStack.push(p);
					}
					else//single and unsatisfied
					{			System.out.println("4");
						predicatesStack.pop();				
						Set<PlanAction> actions=plannable.getSatisfyingActions(topPredicate);
						System.out.println("4.5");
						if(actions!=null)
						{System.out.println("5");
							for (PlanAction a : actions)
							{
								predicatesStack.push(a);
								predicatesStack.push(a.getPreConditions());								
							}
						}
						else
						{System.out.println("6");						
							if(predicatesStack.size()>1)//there is another predicate
							{System.out.println("7");
								System.out.println("trying another way");
								predicatesStack.pop();
								Predicate p=predicatesStack.pop();
								predicatesStack.push(topPredicate);								
							}
							else
							{System.out.println("8");
								System.out.println("*****block*****");								
								return null;								
							}
						}
					}
				} 
				else
				{
					predicatesStack.pop();					
				}
			}
			else//top is action
			{				
				predicatesStack.pop();
				PlanAction action=(PlanAction)topPredicate;
				plannable.getKnowledgebase().update(action.getEffects());
				plan.addLast(action);				
			}
		}	
		return plan;
	}

	public Strips() {
		super();		
	}

}
