package search;

public class Predicate {
	private String name;
	private String[] args;
	
	public Predicate(String name, String... args) {
		this.name = name;
		this.args = args;
	}
	
	@Override
	public boolean equals(Object obj) {
		Predicate p = (Predicate)obj;
		if (!name.equals(p.name))
			return false;
		if (args != null) {
			if (args.length != p.args.length)
				return false;
			for (int i = 0; i < args.length; i++) {
				if (!args[i].equals(p.args[i]))
					return false;
			}
		}		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		
		if (args != null) {
			sb.append("(");
			for (String arg : args) {
				sb.append(arg + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(")");
		}
		return sb.toString();
	}
	
	@Override
	public int hashCode() {		
		return toString().hashCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}
}
