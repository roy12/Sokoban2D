package plan;

import java.util.List;

import search.Action;

public interface Planner {

	List<Action> plan(Plannable plannable);
}
