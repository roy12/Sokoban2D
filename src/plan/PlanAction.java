package plan;

import java.util.LinkedList;

import search.EnumAction;

public class PlanAction extends Predicate
{

	private LinkedList<EnumAction> subActions;
	private Clause preConditions,effects;
	private EnumAction ea;

	
	public LinkedList<EnumAction> getSubActions()
	{
		return subActions;
	}


	public void setSubActions(LinkedList<EnumAction> subActions)
	{
		this.subActions = subActions;
	}


	public EnumAction getEa()
	{
		return ea;
	}


	public void setEa(EnumAction ea)
	{
		this.ea = ea;
	}


	public Clause getPreConditions()
	{
		return preConditions;
	}


	public void setPreConditions(Clause preConditions)
	{
		this.preConditions = preConditions;
	}


	public Clause getEffects()
	{
		return effects;
	}


	public void setEffects(Clause effects)
	{
		this.effects = effects;
	}


	public PlanAction(String type, String id, String value) {
		super(type, id, value);	
	}
}
