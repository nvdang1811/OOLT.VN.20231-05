package cell_division.controller;

import java.io.IOException;

import cell_division.content.Cells;
import cell_division.content.Eukaryotic;
import cell_division.content.Prokaryotic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ComponentScreenController {
	
	private Cells chosenCell;
	private boolean lock = false;
	private int lockingID = 0;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btnReturn;

    @FXML
    private TextFlow fieldFunction;

    @FXML
    private Label fieldName;

    @FXML
    private ImageView imgView;

    @FXML
    private Text textFunction;

    @FXML
    private Label lblCellName;
    
    @FXML
    void btnReturnPressed(ActionEvent event) {
    	try {
    		imgView.setImage(null);
			final String CHOICE_FXML_FILE_PATH = "/cell_division/screen/ChoiceScreen.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CHOICE_FXML_FILE_PATH));
				fxmlLoader.setController(new ChoiceScreenController(chosenCell));	
			Parent root = fxmlLoader.load();
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Choose function");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    public ComponentScreenController(Cells a) {
    	this.chosenCell = a;
    }
    
    public void initialize() {
    	if(chosenCell instanceof Prokaryotic) {
    		lblCellName.setText("Prokaryotic Cell");
    	}
    	if(chosenCell instanceof Eukaryotic) {
    		lblCellName.setText("Eukaryotic Cell");
    	}
        imgView.setImage(new Image(chosenCell.getImage()));
        
    	for(int i = 1; i <= chosenCell.getComponents().size(); i++) {
    		Button btnTmp = new Button("btn" + i);
    		int index = i;
    		btnTmp.setPrefSize(50, 30);
			btnTmp.setLayoutX(chosenCell.getComponentsX()[index-1]);
			btnTmp.setLayoutY(chosenCell.getComponentsY()[index-1]);
			btnTmp.setOpacity(0);
    		btnTmp.setOnAction(btnComponentsPressed -> {
    			if (lockingID == index && lock) {
    				lock = !lock;
    				lockingID = 0;
    			} else {
    				lockingID = index;
    				lock = true;
    			}
    			
    			fieldName.setText(chosenCell.getComponents().get(index-1).getName());
    			textFunction.setText(chosenCell.getComponents().get(index-1).getFunction());

    		});	
    		btnTmp.setOnMouseEntered(btnMouseEntered -> {
    			if(lock) return;
    			fieldName.setText(chosenCell.getComponents().get(index-1).getName());
    			textFunction.setText(chosenCell.getComponents().get(index-1).getFunction());
    		});
    		anchorPane.getChildren().add(btnTmp);
   		}
   	}
}
