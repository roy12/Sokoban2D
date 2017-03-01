package Model;

public class Player extends MoveAbleObject{
	
	private static final long serialVersionUID = 1L;

	private Pointer2D location;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(Pointer2D location) {
		this.location=location;
	}
	
	public Pointer2D getLocation() {
		return location;
	}

	public void setLocation(Pointer2D location) {
		this.location = location;
	}
}
//update location