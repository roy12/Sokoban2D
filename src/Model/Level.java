package Model;

import java.util.ArrayList;
import java.util.Timer;

public class Level {
	
	private GameObject[][] map;
	private int width;
	private int height;
	private Pointer2D start;
	private Pointer2D pl;//player location
	private int numOfTargets;
	private ArrayList <Floor> targets;
	private Timer timer;
	long tStart;	
	double elapsedSeconds ;
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
		tStart=System.currentTimeMillis();
		elapsedSeconds=0;
		lastMove="Down";
	}
	
	public Level (int width,int height,GameObject[][] map,Pointer2D start,Pointer2D pl, int numOfTargets,ArrayList <Floor> targets) {
		this.width=width;
		this.height=height;
		this.map=map;
		this.backupmap=map;
		this.start=start;
		this.pl=pl;
		this.numOfTargets=numOfTargets;
		this.targets=targets;
		tStart=System.currentTimeMillis();
		elapsedSeconds=0;
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
	
	public double getTime()
	{
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		elapsedSeconds=tDelta/1000;
		return elapsedSeconds;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
}
