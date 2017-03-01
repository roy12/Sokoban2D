package levels;

import java.io.Serializable;

public class Level implements Serializable {
	private int height;
	private int width;
	private LevelObject[][] map;
	
	void setHeight(int n){
		this.height=n;
	}
	void setWidth(int n){
		this.width=n;
	}
	public int getHeight(){
		return this.height;
	}
	public int getWidth(){
		return this.width;
	}
	public LevelObject[][] getMap() {
		return map;
	}
	public void setMap(LevelObject[][] map) {
		this.map = map;
	}
	
}
