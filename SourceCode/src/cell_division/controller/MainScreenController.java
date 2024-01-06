package cell_division.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import javafx.scene.*;
import cell_division.content.*;

public class MainScreenController{

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnQuit;

    @FXML
    void btnHelpPressed(ActionEvent event) {
    	try {
    		final String HELP_FXML_FILE_PATH = "/cell_division/screen/HelpScreen.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELP_FXML_FILE_PATH));
    		ArrayList<String> listofImages = new ArrayList<String>();
    		for(int i = 1; i <=6; i++) {
    			listofImages.add("/cell_division/images/tutorial" + i + ".png");
    		}
    		fxmlLoader.setController(new HelpScreenController(listofImages));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Help");
    		stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void btnQuitPressed(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Are you sure?");
    	alert.setHeaderText(null);
    	alert.setContentText("Do you want to quit?");
    	ButtonType btnYes = new ButtonType("Yes");
    	ButtonType btnNo = new ButtonType("No");
    	alert.getButtonTypes().setAll(btnYes, btnNo);
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if(result.get() == btnNo) {
    		alert.close();
    	} else {
    		alert.close();
    		Node source = (Node) event.getSource();
        	Stage stage = (Stage) source.getScene().getWindow();
        	stage.close();
    	}
    	
    	
    }

    @FXML
    void eukaryoticChoosen(MouseEvent event) {
    	try {
    		final String CHOICE_FXML_FILE_PATH = "/cell_division/screen/ChoiceScreen.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CHOICE_FXML_FILE_PATH));
    		fxmlLoader.setController(new ChoiceScreenController(new Eukaryotic("Example")));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Choose function");
    		stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}  	
    }

    @FXML
    void prokaryoticChosen(MouseEvent event) {
    	try {
    		final String CHOICE_FXML_FILE_PATH = "/cell_division/screen/ChoiceScreen.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CHOICE_FXML_FILE_PATH));
    		fxmlLoader.setController(new ChoiceScreenController(new Prokaryotic("Example")));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Choose function");
    		stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	} 
    }

}

