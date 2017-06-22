package search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import jdk.nashorn.internal.ir.CallNode.EvalArgs;


public class BFS<T> extends CommonSearcher<T>
{
	@Override
	public Solution search(Searchable<T> searchable)
	{
		openList=new PriorityQueue<>(new Comparator<State<T>>()
		{

			@Override
			public int compare(State<T> arg0, State<T> arg1)
			{				
				return (int)(arg0.getCost()-arg1.getCost());
			}
		});	
		HashSet<State<T>> closed=new HashSet<>();
		closed.clear();
		State<T> state=searchable.getInitialState();
		//state.setCameFrom(getFinalState());
		this.openList.add(state);
		State<T> currentState=null;	
		System.out.println("roy");
		while(!this.openList.isEmpty())
		{			System.out.println("gil");
			currentState=this.openList.poll();
			this.evaluatedNodes++;			
			closed.add(currentState);
			if(currentState.equals(searchable.getGoalState()))
					{			
						Solution solution=new Solution();
						solution.setEa(backTrace(currentState));
						setFinalState(currentState);
						return solution;
					}
			HashMap<Action,State<T>> map=searchable.getAllPossibleStates(currentState);

				for(Action action : map.keySet())
				{
					State<T> s=map.get(action);
					if(!closed.contains(s))
					{
						if(!openList.contains(s))
							openList.add(s);
						else
						{
							for(State<T> os : openList)
							{
								if(os.equals(s))
								{
									if(s.getCost()<os.getCost())
									{
										openList.remove(os);
										os.setCost(s.getCost());
										openList.add(os);
									}
								}
							}
						}
					}

				}

			
		}
		return null;
	
		
	}

	public BFS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
