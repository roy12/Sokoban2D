package Model;

import java.io.IOException;
import java.io.OutputStream;

public interface LevelSaver {
	
	
	//public default void saveLevel(Level lv) throws IOException{}
	
	public default Level saveLevel(OutputStream out){
		return null;
}
}