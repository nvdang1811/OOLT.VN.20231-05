package hust.soict.cell_division.controller;

import java.io.File;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProcessController{
	private boolean isPlaying = false;
	private Double[] keyPoint;
	//private Cell cell;
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
    
    @FXML
    void sliderClicked(MouseEvent event) {
    	
    }
    
    @FXML
    void sliderDragged(MouseEvent event) {
    	
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

    }
    
    public void initialize() {
    	
    	this.slider = new Slider(0, 500, 0);
    	
    	this.keyPoint = new Double[]{0d, 60d, 120d, 380d};
    	
    	Media media = new Media(getClass().getResource("/hust/soict/cell_division/videos/Meiosis.mp4").toString());
    	mediaPlayer = new MediaPlayer(media);
    	mediaPlayer.setAutoPlay(true);
    	btnPlay.setText("Pause");
    	isPlaying = true;
    	mediaView.setMediaPlayer(mediaPlayer);
    	
    }
}

