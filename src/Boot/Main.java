package Boot;
	
import java.io.File;

import Controller.MyController;
import Model.MyModel;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ClientHandler;
import view.MainWindowController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;
//test

public class Main extends Application {
	
	public static boolean server = false;
	public static int port;
	
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			BorderPane root = (BorderPane)loader.load();
			MainWindowController view = loader.getController();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Sokoban-Leauge");	
			
			//music
			playMusic();
		
			primaryStage.setOnCloseRequest(event -> {
				view.exit();
			});
			
			
			
			init(view);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private void init(MainWindowController view) {
		MyModel model = new MyModel();
		MyController controller = new MyController(model, view);
		
		if(server == true)
		{
			System.out.println("running with server");
			controller.startServer(new ClientHandler(),port);
		}
		
		model.addObserver(controller);
		view.addObserver(controller);
		view.start();	
	}
	
	public static void playMusic()
	{
		String musicFile = "./recources/OpenGame/MoZZ.mp3";     // For example
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);			
		mediaPlayer.setCycleCount(10);		
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.play();
		
	}
	
	public static void main(String[] args) {
		
		if (args.length >= 2  && args[0].compareToIgnoreCase("-server")==0)
		{
			server = true;
			port = Integer.parseInt(args[1]);
		}
		else System.out.println("running without server");
		
		launch(args);
	}
}
/*

}*/