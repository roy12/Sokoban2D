package Model;

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
	

}
