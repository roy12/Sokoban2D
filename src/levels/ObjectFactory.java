package levels;

public class ObjectFactory {
public ObjectFactory() {
	// TODO Auto-generated constructor stub
}
public LevelObject getObj(char c, Point p){
	if(c=='#')
		return new Wall();
	else if(c=='A')
		return new Player();
	else if(c=='@')
		return new Crate();
	else if(c=='o')
		return new Target();
	else
		return null;
}
}
