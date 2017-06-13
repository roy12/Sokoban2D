package sokobanSolver;
//implements Plannable
//try to satisfy predicates by action or "break" it to few predicates and updates

import java.util.Set;

import search.Action;
import plan.Clause;
import plan.Plannable;
import plan.Predicate;

public class SokPlannable implements Plannable {

	@Override
	public Clause getGoal() {
		
		return null;
	}

	@Override
	public Clause getKnowledgebase() {
		
		return null;
	}

	@Override
	public Set<Action> getsatisfyingActions(Predicate top) {
		
		return null;
	}

	@Override
	public Action getsatisfyingAction(Predicate top) {
		
		return null;
	}

}
