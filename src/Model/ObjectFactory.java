package Model;

public class ObjectFactory {
	public ObjectFactory() {
		
	}
	public GameObject getObj(char c){		
		if(c=='#')
		{
			
			return new Wall();
		}
		else if(c=='@')
			return new Floor(false,true,new Box());		
		else if( c== ' ')
			return new Floor(false,false,new Space());
		else
			return null;
	}

}
