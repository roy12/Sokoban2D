package plan;

import java.util.List;

public interface Planner {

	List<Action> plan(Plannable plannable);
}
