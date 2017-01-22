package Model;

import java.util.ArrayList;

public class Level {
	
	private GameObject[][] map;
	private int width;
	private int height;
	private Pointer2D start;
	private Pointer2D pl;//player location
	private int numOfTargets;
	private ArrayList <Floor> targets;
	
	public Level (int width,int height,GameObject[][] map,Pointer2D start,Pointer2D pl, int numOfTargets,ArrayList <Floor> targets) {
		this.width=width;
		this.height=height;
		this.map=map;
		this.start=start;
		this.pl=pl;
		this.numOfTargets=numOfTargets;
		this.targets=targets;
	}
	
public Level() {}

	public GameObject[][] getMap() {
		return map;
	}

	public void setMap(GameObject[][] map) {
		this.map = map;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Pointer2D getStart() {
		return start;
	}

	public void setStart(Pointer2D start) {
		this.start = start;
	}

	public Pointer2D getPl() {
		return pl;
	}

	public void setPl(Pointer2D pl) {
		this.pl = pl;
	}

	public int getNumOfTargets() {
		return numOfTargets;
	}

	public void setNumOfTargets(int numOfTargets) {
		this.numOfTargets = numOfTargets;
	}

	public ArrayList <Floor> getTargets() {
		return targets;
	}

	public void setTargets(ArrayList <Floor> targets) {
		this.targets = targets;
	}
	
	public Boolean isComplete()
	{
		boolean flag=true;
		for (int i=0; i<targets.size(); i++) {		
		if (!targets.get(i).isContainBox())
		{
			flag=false;
		}
		}
		return flag;
	}
	
	

}
