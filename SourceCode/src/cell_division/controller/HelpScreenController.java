package cell_division.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

import javafx.stage.*;
import javafx.scene.*;

public class HelpScreenController {
	private ArrayList<String> listofImages;
	private int index = 0;
    @FXML
    private Button btnNext;

    @FXML
    private Button btnPrevious;
    
    @FXML
    private Button btnReturn;

    @FXML
    private ImageView imgView;

    public HelpScreenController(ArrayList<String> listofImages) {
    	this.listofImages = listofImages;
    }
    @FXML
    void btnNextPressed(ActionEvent event) {
    	index++;
    	if(index == listofImages.size()-1) btnNext.setVisible(false);
    	else btnNext.setVisible(true);
    	if(index != 0) btnPrevious.setVisible(true);
    	
    	Image displayImg = new Image(listofImages.get(index));
    	imgView.setImage(displayImg);
    }

     @FXML
	void btnPreviousPressed(ActionEvent event) {
    	 index--;
    	 if(index == 0) btnPrevious.setVisible(false);
    	 else btnPrevious.setVisible(true);
    	 if(index != listofImages.size()-1) btnNext.setVisible(true);
    	 
    	 Image displayImg = new Image(listofImages.get(index));
     	 imgView.setImage(displayImg);
	    }

     @FXML
    void btnReturnPressed(ActionEvent event) {
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
    
    public void initialize() {
    	btnPrevious.setVisible(false);
    	Image displayImg = new Image(listofImages.get(index));
    	imgView.setImage(displayImg);
    	
    }

}

