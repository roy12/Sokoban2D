package sokobanSolver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import Model.TextLevelLoader;
import levels.Level;
import search.EnumAction;

public class RoyTest {

	public static void main(String[] args) {
		
		Level lvl;
		TextLevelLoader tll=new TextLevelLoader();
		
		try { 			
			lvl=(Level) tll.loadLevel((new FileInputStream(new File("recources\\levels\\Level1.txt")))); 
			SokSolver sokobanSolver=new SokSolver();
			lvl.printLevel();				
			System.out.println(sokobanSolver.solveLevel(lvl).toString());
					
			} catch (FileNotFoundException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
			} catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
			}


	}

}
