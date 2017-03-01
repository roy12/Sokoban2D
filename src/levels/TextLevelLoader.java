package levels;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TextLevelLoader implements LevelLoader {
public TextLevelLoader() {
	// TODO Auto-generated constructor stub
}
@Override
	public Level loadLevel(InputStream in) {
	
	Level newLevel = new Level();
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	ObjectFactory oj = new ObjectFactory();
	String line= null;
	LevelObject[][] map = null;
	int height=0;
	int width=0;
	int n=0;
	char[] charArr = null;
	String[] arr = null;
	
	//read first line to adjust level size
	
	try {
		line = br.readLine();
	} catch (IOException e) {
		System.out.println("error reading file");
	}
	
//	if(line!=null){
//		charArr = line.toCharArray();
//		while(charArr[n]!=' ')
//		{
//			height+=Character.getNumericValue(charArr[n]);
//			n++;
//			if(charArr[n]==' '){
//				n++;
//				break;
//			}
//			height*=10;
//		}
//		while (charArr[n]!=' '){
//			width+=Character.getNumericValue(charArr[n]);
//			n++;
//			if(n==charArr.length)
//				break;
//			if(charArr[n]==' ')
//				break;
//			width*=10;
//		}
	
	if(line!=null){
		charArr= line.toCharArray();
		height = Character.getNumericValue(charArr[0]);
		width = Character.getNumericValue(charArr[1]);
	}
		newLevel.setHeight(height);
		newLevel.setWidth(width);
		map = new LevelObject[height][width];
	
	//read line > 1 to define objects and positions
	
	for (int i=0;i<newLevel.getHeight();i++){
		try {
			line =br.readLine();
		} catch (IOException e) {
			System.out.println("error reading file");
		}
		if (line!=null){
			charArr = line.toCharArray();
			for(int j=0;j<charArr.length;j++){
				map[i][j]= oj.getObj(charArr[j],new Point2D(i,j));
			}
		}
		newLevel.setMap(map);
	}
	return newLevel;
}
}
