package plan;

import java.util.List;

import search.Action;

public interface Planner {

	public List<PlanAction> plan(Plannable plannable); 
}
