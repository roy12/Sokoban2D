package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import Model.Level;
import javafx.beans.property.IntegerProperty;



public class CLI extends Observable implements View {
	
	public void start() {
		
		Scanner scanner = new Scanner(System.in);
		Thread thread = new Thread(new Runnable() {
			
			
			public void run() {
				
				while (true) {
					System.out.println("Enter command: ");
					String commandLine = scanner.nextLine();
					
					String[] arr = commandLine.split(" ");
					List<String> params = new LinkedList<String>();									
					
					for (String s: arr) {
						params.add(s);
					}
					
					setChanged();
					notifyObservers(params);
					
					if (commandLine.equals("Exit"))
					{						
						break;						
					}
				}				
			}
		});
		thread.start();		
	}

	
	public void displayError(String msg) {
		System.out.println("Error: " + msg);
		
	}


	public void displayLevel(Level lvl) {
		for(int i=0;i<lvl.getHeight();i++){	
			for(int j=0;j<lvl.getWidth();j++){				
				System.out.print(lvl.getMap()[i][j].getType());				
			}
		System.out.println();
		}
		
	}


	@Override
	public void bindSteps(IntegerProperty steps) {
		// TODO Auto-generated method stub
		
	}

}



