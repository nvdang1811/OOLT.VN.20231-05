package cell_division.controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import cell_division.content.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ProcessController{
	private boolean isPlaying = false;
	private Double[] keyPoint;
	private Cells cell;
    @FXML
    private Button btnNext;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnRestart;

    @FXML
    private Button btnReturn;

    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
    
    @FXML
    private Slider slider;
   
    private String directory; 
    
    public ProcessController() {
    	
    }
    public ProcessController(Cells cell, String directory, Double[] keyFrames) {
    	this.cell = cell;
    	this.directory = directory;
    	this.keyPoint = keyFrames;
    }
    
    @FXML
    void btnNextPressed(ActionEvent event) {
    	Double key;
    	key = findCheckpoint(mediaPlayer.getCurrentTime().toSeconds(), keyPoint, false);
    	if(key == -1d) return;
    	mediaPlayer.seek(new Duration(key * 1000));
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
    	if(isPlaying == false) {
        	mediaPlayer.play();   
        	isPlaying = true;
        	btnPlay.setText("Pause");
    	}
    	else {
    		mediaPlayer.pause();
    		isPlaying = false;
    		btnPlay.setText("Play");
    	}
    }
    
    Double findCheckpoint(Double playing, Double[] ascendList, boolean findBefore) {
    	System.out.println(playing);
    	for(int i = 0; i < ascendList.length; i++) {
    		if(playing < ascendList[i]) {
    			if(findBefore && i < 2) return 0d;
    			if(findBefore) return ascendList[i-2];
    			else return ascendList[i];
    		}
    	}
    	if(findBefore) return ascendList[ascendList.length - 2];
    	else return -1d;
    }
    @FXML
    void btnPreviousPressed(ActionEvent event) {
    	Double key;
    	key = findCheckpoint(mediaPlayer.getCurrentTime().toSeconds(), keyPoint, true);
    	if(key == -1d) return;
    	mediaPlayer.seek(new Duration(key * 1000));
    }

    @FXML
    void btnRestartPressed(ActionEvent event) {
    	mediaPlayer.seek(new Duration(0));
    }

    @FXML
    void btnReturnPressed(ActionEvent event) {
    	try {
    		mediaPlayer.pause();
			final String CHOICE_FXML_FILE_PATH = "/cell_division/screen/ChoiceScreen.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CHOICE_FXML_FILE_PATH));
			fxmlLoader.setController(new ChoiceScreenController(this.cell));
			Parent root = fxmlLoader.load();
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Cart");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void initialize() {
    	Media media = new Media(getClass().getResource(directory).toString());
    	mediaPlayer = new MediaPlayer(media);
    	mediaPlayer.setAutoPlay(true);
    	btnPlay.setText("Pause");
    	isPlaying = true;
    	mediaView.setMediaPlayer(mediaPlayer);
    	
    	slider.setMax(1000);
    	slider.setMin(0);
    	
    	mediaPlayer.setOnReady(new Runnable(){
    		public void run() {		
    			slider.setMax(mediaPlayer.getTotalDuration().toSeconds());
    		}
    	});

    	slider.setOnMouseDragged(new EventHandler<MouseEvent>() {
    		public void handle(MouseEvent arg0) {
    			mediaPlayer.seek(Duration.seconds(slider.getValue()));
    		}
    	});
    	
    	slider.setOnMousePressed(new EventHandler<MouseEvent>() {
    		public void handle(MouseEvent arg0) {
    			mediaPlayer.seek(Duration.seconds(slider.getValue()));
    		}
    	});
    	
    	mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
    		public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
    			slider.setValue(newValue.toSeconds());
    		}
    	});	
    }
}

