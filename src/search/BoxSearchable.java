package search;

import java.util.ArrayList;

public class BoxSearchable extends SokobanSearchable {

	public ArrayList<State> getAllPossibleStates(State s) {
		/**
		 * complete 
		 */
		ArrayList<State> posStates=new ArrayList<>();
		
		/*State s1=new State(s);
		Pointer2D current,s1to1,s1to2;
		current=new Pointer2D(s.getLvl().getPl());
		s1to1=new Pointer2D(current.getX()+1, current.getY());
		s1to2=new Pointer2D(current.getX()+2, current.getY());
		MovementPolicy mp1=new MovementPolicy(s1.getLvl(),current,s1to1,s1to2);
		
		State s2=new State(s);
		Pointer2D s2to1,s2to2;		
		s2to1=new Pointer2D(current.getX()-1, current.getY());
		s2to2=new Pointer2D(current.getX()-2, current.getY());
		MovementPolicy mp2=new MovementPolicy(s2.getLvl(),current,s2to1,s2to2);
		
		State s3=new State(s);
		Pointer2D s3to1,s3to2;		
		s3to1=new Pointer2D(current.getX(), current.getY()+1);
		s3to2=new Pointer2D(current.getX(), current.getY()+2);
		MovementPolicy mp3=new MovementPolicy(s3.getLvl(),current,s3to1,s3to2);
		
		State s4=new State(s);
		Pointer2D s4to1,s4to2;		
		s4to1=new Pointer2D(current.getX(), current.getY()-1);
		s4to2=new Pointer2D(current.getX(), current.getY()-2);
		MovementPolicy mp4=new MovementPolicy(s4.getLvl(),current,s4to1,s4to2);
		
		if(s1!=s.getCameFrom() && mp1.isPossible())
			posStates.add(s1);
		if(s2!=s.getCameFrom() && mp2.isPossible())
			posStates.add(s2);
		if(s3!=s.getCameFrom() && mp3.isPossible())
			posStates.add(s3);
		if(s4!=s.getCameFrom() && mp4.isPossible())
			posStates.add(s4);

		*/
		
		return posStates;
		
	}
}
