package sokobanSolver;

import java.util.ArrayList;

import levels.Position;
import search.Searcher;
import search.Action;
import search.BFS;
import search.Searchable;

public class Test {

	public static void main(String[] args) {
		// for the State<T> class, T = Position which includes x,y for this example
		// or new Dijkstra<>();
		Searcher<Position> searcher=new BFS<Position>();
		// or any Searchable
		Searchable<Position> searchable=new MySearchable<Position>();
		ArrayList<Action> actions = searcher.search(searchable);
		// see the actions
		for(Action a : actions)
		System.out.println(a);
		System.out.println("# of nodes evaluated " + searcher.getNumberOfNodesEvaluated());

	}

}
