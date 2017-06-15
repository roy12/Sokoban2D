 package search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import plan.Clause;
import plan.Predicate;

public abstract class Action {
	
	private EnumAction ea;
	private LinkedList<EnumAction> history;
	
	public LinkedList<EnumAction> getPath()
	{
		
		LinkedList<EnumAction> list=new LinkedList<>();
		
		if(history!=null)
		{
			for(int i=0;i<history.size();i++)
				list.addLast((EnumAction) history.toArray()[i]);
		}
		list.addLast(ea);

		return list;
	}
	
	public EnumAction getEa() {
		return ea;
	}

	public void setEa(EnumAction ea) {
		this.ea = ea;
	}
	public LinkedList<EnumAction> getHistory() {
		return history;
	}

	public void setHistory(LinkedList<EnumAction> history) {
		this.history = history;
	}
	
	public String toString()
	{
		String str="";
		if (this.history!=null)
		{
			for(EnumAction a: this.history)
				str+=a.toString()+",";
		}
		if(this.ea!=null)
			str+=this.ea+",";
		return str;		
	}
	public Action(EnumAction ea, LinkedList<EnumAction> history) {
		super();
		this.ea = ea;
		this.history = history;
	}	
	
}
