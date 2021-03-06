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
	public String toString() 
	{ 
	return "("+x+","+y+")"; 
	} 
	public Position getUp()
	{
		return new Position(x-1,y);
	}
	public Position getDown()
	{
		return new Position(x+1,y);
	}
	public Position getLeft()
	{
		return new Position(x,y-1);
	}
	public Position getRight()
	{
		return new Position(x,y+1);
	}
	public boolean equals(Position p)
	{
		if(p.getX()==this.x&&p.getY()==this.y)
			return true;
		else
			return false;
	}

	@Override
	public boolean equals(Object obj) {
		if ((this.x == ((Position) obj).x) && (this.y == ((Position) obj).y))
			return true;
		else
			return false;

	}

	@Override
	public int hashCode() {
		String code = "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
		return code.hashCode();
	}


}
