package levels;

public class Position {
	private int x;
	private int y;
	
	public Position() {
		// TODO Auto-generated constructor stub
	}
	
	public Position(int x,int y) {
		this.x=x;
		this.y=y;	
	}
	public Position(Position p) {
		this.x=p.x;
		this.y=p.y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void setPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

}
