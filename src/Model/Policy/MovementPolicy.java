package Model.Policy;

import Model.Floor;
import Model.GameObject;
import Model.Level;
import Model.Pointer2D;

public class MovementPolicy {
	
public MovementPolicy(Level lvl,Pointer2D location,Pointer2D to1,Pointer2D to2) {
	
	GameObject[][] map=lvl.getMap();
	GameObject current = map[location.getX()][location.getY()];	//this block (x,y)
	GameObject next = map[to1.getX()][to1.getY()];	//next block (x+1,x-1,y+1,y-1)
	
	
	
	if(next instanceof Floor)
	{
		GameObject last = map[to2.getX()][to2.getY()];	//last block (x+2,x-2,y+2,y-2)
		if(next.isEmpty())
		{
			Floor f1 = (Floor)current;
			Floor f2 = (Floor)next;
			f1.switchContain(f2);
			
			// * new * //
			lvl.setPl(to1);	//saves player original place to real time movement
		}
		else if(last instanceof Floor & last.isEmpty())
		{	
			Boolean targetCheck=false;
			Floor f1 = (Floor)next;
			Floor f2 = (Floor)last;
			if(f2.isTarget())
			{
				targetCheck=true;
			}
			f1.switchContain(f2);
			f1 = (Floor)current;
			f2 = (Floor)next;
			f1.switchContain(f2);
			
			if(targetCheck)
			{
				if(lvl.isComplete())
				{
					System.out.println("Level Completed, You Have Win!!!!");
				}
					
			}
			// * new * //
			lvl.setPl(to1);
			//saves player original place to real time movement
		}
	}
	else
	{
		lvl.setPl(location);
	}
}
}
