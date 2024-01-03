package cell_division.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import java.io.IOException;
import javafx.stage.*;
import javafx.scene.*;

public class HelpScreenController {

    @FXML
    private Button btnReturn;

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

}

