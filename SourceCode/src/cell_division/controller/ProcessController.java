package cell_division.controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

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
   
    private String directory; 
    
    public ProcessController() {
    	
    }
    public ProcessController(String directory) {
    	this.directory = directory;
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
    
    
    void updateSlider() {
    	System.out.println(mediaPlayer.getTotalDuration().toSeconds());
    	slider.setMax(400);
    	slider.setMin(0);
    	slider.valueProperty().addListener(new ChangeListener<Number>() {
    		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
    			if(slider.isValueChanging()) {
    				System.out.println("Updating recorded");
    				//Duration seekTo = new Duration(slider.getValue() * 1000);
    				mediaPlayer.seek(Duration.seconds(slider.getValue()));
    			}
    		}
    	}); 
    	
    	mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
    		public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
    			slider.setValue(newValue.toSeconds());
    		}
    	});	
    }
    
    public void initialize() {
    	this.keyPoint = new Double[]{0d, 60d, 120d, 380d};
    	
    	Media media = new Media(getClass().getResource("/cell_division/videos/Meiosis.mp4").toString());
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

