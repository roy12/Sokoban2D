package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import view.View;

public class MyModel extends Model {
	private Level lvl=null;
	private String str=null;
	
	private int stepC = 0;
	
	public MyModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void move(String s)
	{
		if(!lvl.isComplete())
		{
		if(s.contains("Down"))
		{
			lvl.setLastMove("Down");
			@SuppressWarnings("unused")
			Movement m=new MoveDown(lvl);			
		}
		else if(s.contains("Right"))
		{
			lvl.setLastMove("Right");
			@SuppressWarnings("unused")
			Movement m=new MoveRight(lvl);
		}
		else if(s.contains("Left"))
		{
			lvl.setLastMove("Left");
			@SuppressWarnings("unused")
			Movement m=new MoveLeft(lvl);
		}
		else if(s.contains("Up"))
		{
			lvl.setLastMove("Up");
			@SuppressWarnings("unused")
			Movement m=new MoveUp(lvl);
		}
		else 
		{
			System.out.println("Unknown Command");
		}
		setStepC(getStepC() + 1);
		
		this.setChanged();
		List<String> params = new LinkedList<String>();
		display();
		params.add("GuiDisplay");
		this.notifyObservers(params);
		}
	}
	
	public void load(String str) throws FileNotFoundException
	{
		this.str=str;
		FileInputStream in = new FileInputStream(str);
		ExtensionFinder ef = new ExtensionFinder(str);
		String str2 = ef.getStr2();
		if (str2.contains("txt")){
			this.lvl = new TextLevelLoader().loadLevel(in);		//Load is ok
		}
		else if (str2.contains("xml")){
			this.lvl = new XMLLevelLoader().loadLevel(in);		//Load is NOT ok, we load Model here! we need to load Level.
		}
		else if (str2.contains("ser")){
			this.lvl = new ObjectLevelLoader().loadLevel(in);	//Load is NOT ok, we load Model here! we need to load Level.
		}
		else {
			System.out.println("Wrong Path");
		}
		
		setStepC(0);
		
		
		this.setChanged();
		List<String> params = new LinkedList<String>();
		display();
		params.add("GuiDisplay");
		this.notifyObservers(params);
	}
	
	public void save(String str) throws IOException
	{
		if (lvl !=null)
		{
			ExtensionFinder ef = new ExtensionFinder(str);
			String str2 = ef.getStr2();
			if (str2!=null)
			{
			if (str2.contains("txt")){
				@SuppressWarnings("unused")
				TextLevelSaver textSave = new TextLevelSaver(lvl,str);	//Save is ok 
			}
			else if (str2.contains("xml")){
				@SuppressWarnings("unused")
				XMLLevelSaver xmlSave = new XMLLevelSaver(this.lvl, str);	//Save is NOT ok, we send (Model,str) here.
			}
			else if (str2.contains("ser")){
				@SuppressWarnings("unused")
				ObjectLevelSaver objectSave = new ObjectLevelSaver(lvl, str);	//Save is NOT ok, we send (Model,str) here.
			}
			else {
				System.out.println("Wrong Path");
			}
			}
			else
			{
				System.out.println("i dont know to save in that filetype");				
			}
		}
		else
		{
			System.out.println("You can't save an empty Level");
	}	
			
		
}
	
	public void exit()
	{
		/*System.out.println("Save before exit ?");
		String str="";
		while(!str.contains("yes") & !str.contains("no"))
		{
			Scanner s = new Scanner(System.in);
			str = s.nextLine();	
			if (str.contains("yes"))
			{
				System.out.println("save as ? ");
				s = new Scanner(System.in);
				str = s.nextLine();
				SaveLevelCommand save = new SaveLevelCommand(this);
				
				System.exit(0);
			}
			else if(str.contains("no"))
			{
				
				System.exit(0);
			}
			else 
				{System.out.println("yes/no");}
		}*/
		//belong to CLI
		System.exit(0);
	}
	
	public void display() {		
		for(int i=0;i<this.lvl.getHeight();i++){	
			for(int j=0;j<this.lvl.getWidth();j++){
				System.out.print(this.lvl.getMap()[i][j].getType());
			}
		System.out.println();
		}
	}
	
	public void guiDisplay(View view){
	view.displayLevel(lvl);
	}
	public void restart()
	{		
		if (str!=null)
		{
			try {
				load(str);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getStepC() {
		return stepC;
	}

	public void setStepC(int stepC) {
		this.stepC = stepC;
	}
}



