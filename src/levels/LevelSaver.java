package levels;

import java.io.InputStream;
import java.io.OutputStream;
public interface LevelSaver {
	public default Level saveLevel(OutputStream out){
		return null;
	}

}
