package Command;


import java.util.List;

public abstract class Command 
{	
	protected List<String> params;
	
	public void setParams(List<String> params) {
		this.params = params;
	}
	
	public boolean isExit()
	{
		return false;
	}
	public abstract void execute();
}
		
	
