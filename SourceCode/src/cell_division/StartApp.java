package cell_division;

import cell_division.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApp extends Application{
	
	public void start(Stage primaryStage) throws Exception {
		final String PROCESS_FXML_FILE_PATH = "/cell_division/screen/ProcessScreen.fxml";
		final String MAIN_FXML_FILE_PATH = "/cell_division/screen/MainScreen.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PROCESS_FXML_FILE_PATH));
		ProcessController mainController = new ProcessController();
		fxmlLoader.setController(mainController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Process");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
