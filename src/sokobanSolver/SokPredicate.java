package sokobanSolver;

import plan.Predicate;

//extends Predicate

public class SokPredicate extends plan.Predicate{

	public SokPredicate(String type, String id, String value) {
		super(type, id, value);
		
	}
	
	public boolean isContradict(Predicate p)
	{
		return super.isContradict(p) || (!getId().equals(p.getId())&& getValue().equals(p.getValue())||(getValue().equals(p.getValue())&&(!getType().equals(p.getType()))));
	}
	
	public void print()
	{
		System.out.println("type="+this.getType());
		System.out.println("id="+this.getId());
		System.out.println("value="+this.getValue());
	}
}
