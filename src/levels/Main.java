package levels;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
			//Text
			FileInputStream textin = new FileInputStream("C:\\Users\\moshe\\Desktop\\מדעי המחשב\\שנה ב'\\פיתוח תכנה מתקדם\\אבן דרך\\1\\textLvls\\Level1.txt");
			Level textLevel = new TextLevelLoader().loadLevel(textin);
			
			//Object
			FileOutputStream fileOut =new FileOutputStream("C:\\Users\\moshe\\Desktop\\מדעי המחשב\\שנה ב'\\פיתוח תכנה מתקדם\\אבן דרך\\1\\textLvls\\LevelSer1.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(textLevel);
			fileOut.close();
			FileInputStream objIn = new FileInputStream("C:\\Users\\moshe\\Desktop\\מדעי המחשב\\שנה ב'\\פיתוח תכנה מתקדם\\אבן דרך\\1\\textLvls\\LevelSer1.ser");
			Level objectLevel = new ObjectLevelLoader().loadLevel(objIn);
			objIn.close();
			
			//XML
			XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("C:\\Users\\moshe\\Desktop\\מדעי המחשב\\שנה ב'\\פיתוח תכנה מתקדם\\אבן דרך\\1\\textLvls\\LevelSer1.xml")));
			x.writeObject(objectLevel);
			x.close();
			FileInputStream xmlIn = new FileInputStream("C:\\Users\\moshe\\Desktop\\מדעי המחשב\\שנה ב'\\פיתוח תכנה מתקדם\\אבן דרך\\1\\textLvls\\LevelSer1.xml");
			Level xmlLevel = new XMLLevelLoader().loadLevel(xmlIn);
			System.out.println(xmlLevel.getMap()[1][1].getClass()+ " xml");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error in main");
		}
	}
	}
