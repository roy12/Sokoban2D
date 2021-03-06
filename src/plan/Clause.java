package plan;

import java.util.HashSet;
import java.util.Set;

public class Clause extends Predicate{

	HashSet<Predicate> predicates;
	
	private void updateDescription(){
		value="{";
		for(Predicate p : predicates){
			value+=p.toString()+" & ";
		}
		value+="}";
	}
	
	public Clause(Predicate...predicates) {
		super("And", "", "");
		this.predicates = new HashSet<>();
		if (predicates != null) {
			for (Predicate p : predicates) {
				this.predicates.add(p);
			}
			updateDescription();
		}
	}

	public void update(Predicate effect) {
		{			
			HashSet<Predicate> removeablePredicates = new HashSet<>();			
			if (predicates.size() > 0)
			{			
				for (Predicate p : predicates) 
				{					
					if (p != null) 
					{
						if (effect instanceof Clause)
						{
							if (p.isContradict( (Clause) effect))
									removeablePredicates.add(p);
						} 
						else
						{

							if (p.contradicts(effect))

								removeablePredicates.add(p);
						}
					}					
				}				
				predicates.removeAll(removeablePredicates);
				if(effect instanceof Clause)
					updateClause((Clause)effect);
				else
					this.predicates.add(effect);
				updateDescription();				
			}
			else 
			{				
				predicates.add(effect);
				updateDescription();
			}		
 
		}
	}
	
	private void updateClause(Clause c)
	{
		for(Predicate p : c.getPredicates())
		{
			if(p instanceof Clause)
			{
				updateClause((Clause)p);
			}
			else
				this.predicates.add(p);
		}
	}
	
	
	
	public void add(Predicate p){
		if(predicates==null)
			predicates=new HashSet<>();		
		this.predicates.add(p);
		updateDescription();
	}
	
	@Override
	public boolean satisfies(Predicate p)
	{			
		if (p instanceof Clause)
		{				
			return satisfiesC((Clause)p);
		}
		else
		{			
			for(Predicate pr : predicates)
			{
				if(pr.satisfies(p))
				{
					return true;
				}
			}
			return false;
		}
	}
	
	public boolean isContradict(Predicate p) 
	{ 
		if (p instanceof Clause) 
			return isContradictClause((Clause) p); 
		else 
		{ 
			for (Predicate predicate : predicates)
			{ 
				if (p.isContradict(p)) 
					return true; 
			} 
			return false; 
		} 
		 
	} 

	public boolean isContradictClause(Clause c) 
	{ 
		for (Predicate p : c.getPredicates()) { 
			if (!isContradict(p)) 
				return false; 
		} 
		return true; 	 
	} 

	
	public boolean satisfiesC(Clause clause){
		for(Predicate p : clause.getPredicates()){
			if(!satisfies(p))
				return false;
		}
		return true;
	}

	public Set<Predicate> getPredicates() {
		return predicates;
	}

}
