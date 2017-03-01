package levels;

import java.beans.XMLDecoder;
import java.io.InputStream;

public class XMLLevelLoader implements LevelLoader {
	public XMLLevelLoader() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Level loadLevel(InputStream in) {
		Level newLevel = new Level();
		
		XMLDecoder xd = new XMLDecoder(in);
		newLevel = (Level) xd.readObject();
		return newLevel;
		
	}
	
}
