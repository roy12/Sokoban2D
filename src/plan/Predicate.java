package plan;

public class Predicate {
	
	String type,id,value;
	
	public Predicate(String type, String id, String value) {
		super();
		this.type = type;
		this.id = id;
		this.value = value;
	}
	
	public boolean satisfies(Predicate p){
		return (type.equals(p.type) && (id.equals(p.id) || p.id.equals("?")) && value.equals(p.value));
	}

	public boolean contradicts(Predicate p) {		
		return (type.equals(p.type) && id.equals(p.id) && !value.equals(p.value));
	}
	public boolean isContradict(Predicate p)
	{
		if(p instanceof Clause)
			return isContradictClause((Clause) p);
		else
			return type.equals(p.type)&&id.equals(p.id)&&!value.equals(p.value);
		
	}
	public boolean isContradictClause(Clause c) 
	{ 
		for(Predicate p : c.getPredicates()) 
		{ 
			if(isContradict(p)) 
				return true; 
		} 
		return false;		 
	} 

	
	
	@Override
	public int hashCode(){
		return (type+id+value).hashCode();
	}
	
	@Override
	public String toString(){
		return type+"_"+id+"="+value;
	}
	
	public boolean equals(Predicate p){
		return (type.equals(p.type) && id.equals(p.id) && value.equals(p.value));
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setValue(String value) {
		this.value = value;
	}


}
