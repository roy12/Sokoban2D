 package search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import plan.Clause;
import plan.Predicate;

public abstract class Action extends Predicate{
	

	protected String name;
	protected String[] args;
	public List<Predicate> preconditions = new ArrayList<Predicate>();
	protected List<Predicate> addList = new ArrayList<Predicate>();
	protected List<Predicate> deleteList = new ArrayList<Predicate>();
	protected Map<String, List<String>> illegalAssignments = new HashMap<>();
	public Clause effects;
	
	
	public Action(String type, String id, String value) {
		super(type, id, value);
		
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
