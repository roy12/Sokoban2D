package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import levels.Level;

public class MainWindowController extends Observable implements View, Initializable {
	
	
	@FXML
	GuiDisplayer gd;
	
	@FXML
	public void exitApplication(ActionEvent event) {
	    exit();
	}
	
	@FXML
	Label stepsLabel;

	@FXML
	Label timerLabel;
	
	private IntegerProperty seconds;
	private Timeline timeline;
	private Boolean firstMove=true;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		seconds = new SimpleIntegerProperty(0); 
		timerLabel.textProperty().bind(seconds.asString()); 

		gd.displayOpenPage();
		
		timeline = new Timeline(); 
		timeline.setCycleCount(Timeline.INDEFINITE); 
		timeline.setRate(1.0); 
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1000000),new KeyValue(seconds,1000000))); 

		gd.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->gd.requestFocus());
		
		gd.setOnKeyPressed(new EventHandler<KeyEvent>(){
			
			public void handle(KeyEvent event) {		
				
				List<String> params=new LinkedList<String>();
				
				if(firstMove){ 
				timeline.playFromStart(); 
				firstMove = false; 
				}

				
				if(event.getCode()== KeyCode.UP)
				{			
					params.add("Move");
					params.add("Up");			
				}
				else if(event.getCode()== KeyCode.DOWN)
				{	
					params.add("Move");
					params.add("Down");	
				}
				else if(event.getCode()== KeyCode.RIGHT)
				{	
					params.add("Move");
					params.add("Right");		
				}
				else if(event.getCode()== KeyCode.LEFT)
				{			
					params.add("Move");
					params.add("Left");						
				}
				setChanged();
				notifyObservers(params);		
			}
		});
		
		
	}
	
	public void saveFile(){
		List<String> params = new LinkedList<String>();	
		FileChooser fc = new FileChooser();
		fc.setTitle("Choose Directory");
		fc.setInitialDirectory(new File("./recources"));
		File chosen = fc.showSaveDialog(null);
		if(chosen!=null)
			System.out.println(chosen.getName());
		
		params.add("Save");
		params.add(chosen.getName());
		setChanged();
		notifyObservers(params);
	}

	
	public void openFile(){
				
		List<String> params = new LinkedList<String>();	
		
		FileChooser fc = new FileChooser();
		fc.setTitle("Choose File");
		fc.setInitialDirectory(new File("./recources/levels"));
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Text","*.txt"),
				new ExtensionFilter("XML","*.xml"),
				new ExtensionFilter("Object","*.obj")
				);
		File chosen = fc.showOpenDialog(null);
		if(chosen!=null){
			System.out.println(chosen.getName());
		
		params.add("Load");
		params.add(chosen.getPath());
		setChanged();
		notifyObservers(params);
		
		 firstMove=true;
			 
			timeline.stop(); 
			seconds.set(0);
		
			 
			} 

		
	}
	
	public void restartLevel()
	{
		firstMove=true;		 
		seconds.set(0);		
		List<String> params=new LinkedList<String>();
		params.add("Restart");
		setChanged();
		notifyObservers(params);
	}
	
	public void exit()
	{
		List<String> params=new LinkedList<String>();
		params.add("Exit");
		
		setChanged();
		notifyObservers(params);
		System.exit(0);
	}	
	@Override
	public void displayLevel(Level lvl) {
		if(lvl!=null){
			try {
				gd.setData(lvl);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(lvl.isComplete())
				try {
					timeline.stop();
					Thread.sleep(400);					
					gd.finishLevel();	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
						
		}
	}

	@Override
	public void displayError(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {		
		
	}
	
	public void bindSteps(IntegerProperty stepsC)
	{
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				stepsLabel.textProperty().bind((stepsC).asString());
				
			}
		});
	}
	public void bindTimer(IntegerProperty timerC)
	{
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				
				
			}
		});
	}

}
