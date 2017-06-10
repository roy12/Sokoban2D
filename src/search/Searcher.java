package search;

public interface Searcher {
	Solution search(Searchable s);
	int getNumberOfNodesEvaluated();
}
