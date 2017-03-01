package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import Command.Command;
import Command.DisplayLevelCommand;
import Command.ExitCommand;
import Command.GuiDisplayerLevelCommand;
import Command.LoadLevelCommand;
import Command.MoveCommand;
import Command.RestartCommand;
import Command.SaveLevelCommand;
import Controller.Controller;
import Controllr.Server.MyServer;
import Model.MyModel;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import view.ClientHandler;
import view.View;


public class MyController implements Observer {
	private MyModel model;
	private View view;
	private Controller controller;
	private Map<String, Command> commands;
	MyServer server;
	
	IntegerProperty steps;
		
	
	public MyController(MyModel model, View view) {
		this.model = model;
		this.view = view;
		
		steps = new SimpleIntegerProperty();
		view.bindSteps(steps);
		
		initCommands();
		controller = new Controller();
		controller.start();
	}
	protected void initCommands() {
		commands = new HashMap<String, Command>();
		commands.put("Move", new MoveCommand(model));	
		commands.put("Display", new DisplayLevelCommand(model, view));
		commands.put("GuiDisplay", new GuiDisplayerLevelCommand(model, view));
		commands.put("Load", new LoadLevelCommand(model));
		commands.put("Save", new SaveLevelCommand(model));
		commands.put("Exit", new ExitCommand(model));
		commands.put("Restart", new RestartCommand(model));
	}	

	@Override
	public void update(Observable o, Object arg) {
		List<String> params = (List<String>) arg;
		String commandKey = params.remove(0);
		Command c = commands.get(commandKey);
		if (c == null) {
			view.displayError("Command " + commandKey + " not found");
			return;
		}
		c.setParams(params);
		controller.insertCommand(c);
		
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				steps.set(model.getStepC());
				
			}
		});
	}
	public void startServer(ClientHandler handler,int port)
	{
		handler.addObserver(this);
		server = new MyServer(port,handler);
		server.start();
	}

	public void stopServer()
	{
		if(server != null)
			server.stop();
		
	}

	public void safeExit()
	{
		stopServer();
		if(controller != null)
			controller.stop();
	}	
	
}
