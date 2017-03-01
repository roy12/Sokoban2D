package levels;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectLevelLoader implements LevelLoader {
@Override
public Level loadLevel(InputStream in) {
	Level newLevel = new Level();

	try {
		ObjectInputStream os = new ObjectInputStream(in);
		try {
			newLevel = (Level) os.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error in objectOutputStream");
		}
		os.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("error from objectLoader");
	}
	return newLevel;
}
}
