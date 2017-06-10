 package search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Action {
	protected String name;
	protected String[] args;
	protected List<Predicate> preconditions = new ArrayList<Predicate>();
	protected List<Predicate> addList = new ArrayList<Predicate>();
	protected List<Predicate> deleteList = new ArrayList<Predicate>();
	protected Map<String, List<String>> illegalAssignments = new HashMap<>();
	
	public Action() {
		
	}
	
	public Action(String name, String... args) {
		this.name = name;
		this.args = args;
	}

	public List<Predicate> getPreconditions() {
		return preconditions;
	}

	public List<Predicate> getAddList() {
		return addList;
	}

	public List<Predicate> getDeleteList() {
		return deleteList;
	}

	public Map<String, List<String>> getIllegalAssignments() {
		return illegalAssignments;
	}

	public void setIllegalAssignments(Map<String, List<String>> illegalAssignments) {
		this.illegalAssignments = illegalAssignments;
	}

	public Action instantiate(Map<String, Object> assignment) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public String getName() {
		return name;
	}
}
