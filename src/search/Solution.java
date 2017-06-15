package search;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	private LinkedList<EnumAction> ea = new LinkedList<EnumAction>();

	public Solution(LinkedList<EnumAction> solution) {
		super();
		this.ea = solution;
	}
	public Solution() {
		super();
		ea=new LinkedList<>();
	}
	public List<EnumAction> getEa() {
		return ea;
	}

	public void setEa(LinkedList<EnumAction> actions) {
		this.ea = actions;
	}	
	
	public void showSolution()
	{
		if (ea!=null)
		{
			for (EnumAction action : ea)
			{
				System.out.println(action.toString()+" ");
			}
		}
	}
}
