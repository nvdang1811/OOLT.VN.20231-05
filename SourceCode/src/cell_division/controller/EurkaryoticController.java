import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SampleController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Thêm các mục vào ChoiceBox
        choiceBox.getItems().addAll("Eukaryotic", "Prokaryotic");
    }
    

    @FXML
    private Label selection;


    @FXML
    protected void handleBackButtonAction() {
        System.out.println("Back button clicked");
        // Thêm logic xử lý khi người dùng nhấn nút Back
    }
}
