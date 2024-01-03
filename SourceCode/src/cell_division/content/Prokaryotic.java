package cell_division.content;

import java.util.ArrayList;

public class Prokaryotic extends Cells {
	private String name;
	private ArrayList<Components> components;
	private String path;
	private Double[] keyFrames;
	
	public Prokaryotic(String name) {
		this.name = name;
	}
	
	public ArrayList<Components> getComponents(){
		return this.components;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setComponents(ArrayList<Components> components) {
		this.components = components;
	}
	
	public void Meiosis() {
	}
	
	public void Amitosis() {
		this.path = "/cell_division/videos/Amitosis.mp4";
		this.keyFrames = new Double[] {0d, 4.5d, 11d, 27d, 32d, 47d};
	}
	
	public void Mitosis() {
		
	}
	
	public String getDirectory() {
		return this.path;
	}
	
	public Double[] getKeyFrames() {
		return this.keyFrames;
	}
}
