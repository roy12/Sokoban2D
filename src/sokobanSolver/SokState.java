package sokobanSolver;

import java.util.ArrayList;
import java.util.List;

import levels.Position;

public class SokState {

	private Position playerPosition; 
	private ArrayList<Position> boxPosition; 
	
	public SokState() {
		super();
		this.setPlayerPosition(new Position());
		this.setBoxPosition(new ArrayList<>());
		
	}
	public SokState(Position playerPosition, ArrayList<Position> boxList) {
		super(); 
		this.setPlayerPosition(playerPosition); 
		this.setBoxPosition(boxList);
	}
	public Position getPlayerPosition() {
		return playerPosition;
	}
	public void setPlayerPosition(Position playerPosition) {
		this.playerPosition = playerPosition;
	}
	public ArrayList<Position> getBoxPosition() {
		return boxPosition;
	}
	public void setBoxPosition(ArrayList<Position> boxPosition) {
		this.boxPosition = boxPosition;
	}
	public String toString()
	{
		return "player: ("+this.getPlayerPosition()+") box: (" + this.getBoxPosition()+ ")";
	}
	public boolean eaquals(Object obj)
	{
		if (boxListComparing(this.boxPosition, ((SokState) obj).boxPosition))
			return true;
		else
			return false;
	}
	public boolean boxListComparing(List<Position> a, List<Position> b)
	{
		if(a.size()!=b.size())
			return false;
		else
		{
		int count=a.size();
		for (Position p1 : a) {
			for (Position p2 : b) {
				if (p1.equals(p2))
					count--;
			}
		}
		if(count==0)
			return true;
		else
			return false;
		}
	}

}
