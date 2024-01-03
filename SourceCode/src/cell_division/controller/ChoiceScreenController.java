package cell_division.controller;

import java.io.IOException;

import cell_division.content.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChoiceScreenController{
	
	private Cells chosenCell;
    @FXML
    private Button btnReturn;

    @FXML
    private Button btnViewComponents;

    @FXML
    private Button btnViewProcess1;

    @FXML
    private Button btnViewProcess2;
    
    @FXML
    private Label lblCellType;
    
    @FXML
    public void initialize() {
    	if(chosenCell instanceof Prokaryotic) {
    		lblCellType.setText("Prokaryotic functions");
    		btnViewProcess2.setVisible(false);
        	btnViewProcess1.setText("Amitosis");
        	HBox.setMargin(btnViewProcess1, new Insets(0, 0, 0, 295));
    	}
    	if(chosenCell instanceof Eukaryotic) {
    		lblCellType.setText("Eukaryotic functions");
        	btnViewProcess1.setText("Mitosis");
        	btnViewProcess2.setText("Meiosis");
    	}
    }
    
    @FXML
    void btnReturnPreessed(ActionEvent event) {
    	try {
    		final String MAIN_FXML_FILE_PATH = "/cell_division/screen/MainScreen.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MAIN_FXML_FILE_PATH));
    		fxmlLoader.setController(new MainScreenController());
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void btnViewComponentsPressed(ActionEvent event) {
    	if(chosenCell instanceof Prokaryotic) {
    		
    	}
    	if(chosenCell instanceof Eukaryotic) {
    		
    	}
    }

    @FXML
    void viewProcess1(ActionEvent event) {
    	try {
    		final String PROCESS_FXML_FILE_PATH = "/cell_division/screen/ProcessScreen.fxml";
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PROCESS_FXML_FILE_PATH));;
        	ProcessController processController = new ProcessController();

        	//Amitosis
        	if(chosenCell instanceof Prokaryotic) {
        		chosenCell.Amitosis();
        		processController = new ProcessController(chosenCell, chosenCell.getDirectory(), chosenCell.getKeyFrames());
        	}
        	//Mitosis
        	if(chosenCell instanceof Eukaryotic) {
        		chosenCell.Mitosis();
        		processController = new ProcessController(chosenCell, chosenCell.getDirectory(), chosenCell.getKeyFrames()); 
        	}
        	fxmlLoader.setController(processController);
        	Parent root = fxmlLoader.load();
        	
        	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Processing");
        	stage.show();	
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void viewProcess2(ActionEvent event) {
    	try {
    		final String PROCESS_FXML_FILE_PATH = "/cell_division/screen/ProcessScreen.fxml";
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PROCESS_FXML_FILE_PATH));;
        	ProcessController processController = new ProcessController(); 		
        	if(chosenCell instanceof Eukaryotic) {
        		chosenCell.Meiosis();
        		processController = new ProcessController(chosenCell, chosenCell.getDirectory(), chosenCell.getKeyFrames());
        	}
        	fxmlLoader.setController(processController);
        	Parent root = fxmlLoader.load();
        	
        	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Processing");
        	stage.show();	
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }

    public ChoiceScreenController(Prokaryotic a) {
    	this.chosenCell = a;	
    }

    public ChoiceScreenController(Eukaryotic a) {
    	this.chosenCell = a;
    }
}
