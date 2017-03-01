package view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import Model.GameObject;
import Model.Level;
import javafx.beans.property.IntegerProperty;


public class ClientHandler extends Observable implements View{

	boolean stop = false;
	Displayable displayable;
	OutputStream out;
	InputStream in;
	
	public void startCustomIO(InputStream in,OutputStream out)
	{
		this.out = out;
		this.in = in;
		
		Scanner scan = new Scanner(in);
		PrintStream writer = new PrintStream(out);
	
		
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				while(!stop)
				{
					writer.print("Enter a command :");
					String line = scan.nextLine();
					String[] arr = line.split(" ");
					List<String> params = new LinkedList<String>();
					for(String s : arr)
					{
						
						params.add(s);
						
					}
					setChanged();
					notifyObservers(params);
					if(line.equals("exit"))
						break;
				}
				
			}
		});
		t.start();
		
			
			
	}
	public void setOutputStream(OutputStream out)
	{
		this.out = out;
	}
	public void setInputStream(InputStream in)
	{
		this.in = in;
	}
	
	public void stop()
	{
		stop = true;
		
	}
	

	public void displayFinished() {
		
		System.out.println("Level Finished !");
		
	}
	@Override
	public void displayLevel(Level lvl) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void displayError(String msg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bindSteps(IntegerProperty steps) {
		// TODO Auto-generated method stub
		
	}

	
	

}
