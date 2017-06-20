package sokobanSolver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import Model.TextLevelLoader;
import levels.Level;


public class Test {

	public static void main(String[] args) {

		Level lvl;
		
		TextLevelLoader tll=new TextLevelLoader(); 	
					 
		//String arg0Suffix="",arg1Suffix=""; 
		//String []arr; 
		//arg0Suffix=args[0].substring(args[0].length()-3, args[0].length()); 
		try { 
			//lvl=(Level) tll.loadLevel((new FileInputStream(new File(args[0])))); 
			lvl=(Level) tll.loadLevel((new FileInputStream(new File("recources\\levels\\Level1.txt  ")))); 
			SokSolver sokobanSolver=new SokSolver(); 
			Writer writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1])))); 
			writer.write(sokobanSolver.solveLevel(lvl).toString()); 
			writer.close(); 
			} catch (FileNotFoundException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
			} catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
			}

	}

}

//recources\\levels\\Level1.txt
