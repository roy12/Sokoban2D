package levels;

import java.io.Serializable;

public class GameObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public boolean isEmpty(){return false;};
	
	public GameObject() {
		
	}	
	
	public char getType()
	{
		return ' ';

	}
	
	public char getChar(GameObject lo){
		if (lo instanceof Wall)
			return '#';
		else if(lo instanceof Player)
			return 'A';
		else if (lo instanceof Box)
			return '@';
		else if (lo instanceof Target)
			return 'o';
		return ' ';
	}
	

}
