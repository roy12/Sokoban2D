package levels;

public class CharFactory {
public CharFactory() {
	// TODO Auto-generated constructor stub
}
public char getChar(LevelObject lo){
	if (lo instanceof Wall)
		return '#';
	else if(lo instanceof Player)
		return 'A';
	else if (lo instanceof Crate)
		return '@';
	else if (lo instanceof Target)
		return 'o';
	return ' ';
}
}
