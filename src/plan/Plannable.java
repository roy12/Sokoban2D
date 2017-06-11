package plan;

import java.util.Set;

import search.Action;

public interface Plannable {
	Clause getGoal();
	Clause getKnowledgebase();
	Set<Action> getsatisfyingActions(Predicate top);
	Action getsatisfyingAction(Predicate top);
}
