package levels;

import java.util.ArrayList;
import java.util.Timer;

public class Level {
	
	private GameObject[][] map;
	private int width;
	private int height;
	private Position start;
	private Position pl;//player location
	private int numOfTargets;
	private ArrayList <Floor> targets;
	private GameObject[][] backupmap;
	String lastMove;
	
	
	
	public String getLastMove() {
		return lastMove;
	}

	public void setLastMove(String lastMove) {
		this.lastMove = lastMove;
	}

	public GameObject[][] getBackupmap() {
		return backupmap;
	}

	public void setBackupmap(GameObject[][] backupmap) {
		this.backupmap = backupmap;
	}

	public Level (Level lvl) {
		this.width=lvl.getWidth();
		this.height=lvl.getHeight();
		this.map=lvl.getMap();
		this.start=lvl.getStart();
		this.pl=lvl.getPl();
		this.numOfTargets=lvl.getNumOfTargets();
		lastMove="Down";
	}
	
	public Level (int width,int height,GameObject[][] map,Position start,Position pl, int numOfTargets,ArrayList <Floor> targets) {
		this.width=width;
		this.height=height;
		this.map=map;
		this.backupmap=map;
		this.start=start;
		this.pl=pl;
		this.numOfTargets=numOfTargets;
		this.targets=targets;
		lastMove="Down";
	}
public Level() {
	// TODO Auto-generated constructor stub
}

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

	public Position getStart() {
		return start;
	}

	public void setStart(Position start) {
		this.start = start;
	}

	public Position getPl() {
		return pl;
	}

	public void setPl(Position pl) {
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
