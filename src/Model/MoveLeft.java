package Model;

import Model.Policy.MovementPolicy;
import levels.Level;
import levels.Position;

public class MoveLeft implements Movement {
	public MoveLeft() {
		// TODO Auto-generated constructor stub
	}
public MoveLeft(Level lvl) {
	Position to1, to2;
	to1 =new Position(lvl.getPl());
	to1.setY(to1.getY()-1);
	to2 =new Position(lvl.getPl());
	to2.setY(to2.getY()-2);
	
	@SuppressWarnings("unused")
	MovementPolicy mp = new MovementPolicy(lvl,lvl.getPl(),to1,to2);
}

}
