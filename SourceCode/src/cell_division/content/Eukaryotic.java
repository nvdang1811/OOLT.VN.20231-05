package cell_division.content;

import java.util.ArrayList;

public class Eukaryotic extends Cells{
	private String name;
	private ArrayList<Components> components;
	private String path;
	private Double[] keyFrames;
	public Eukaryotic(String name) {
		this.name = name;
	}
	@Override
	public void Amitosis() {
		
	}

	@Override
	public void Meiosis() {
		this.path = "./../videos/Meiosis.mp4";
		this.keyFrames = new Double[] {0d, 111d, 120d, 131d, 180d, 202d, 211d, 214d};
	}

	@Override
	public void Mitosis() {
		this.path = "/cell_division/videos/Mitosis.mp4";
		this.keyFrames = new Double[] {0d, 47d, 72d, 81d, 93d};
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

	public String getDirectory() {
		return this.path;
	}
	
	public Double[] getKeyFrames() {
		return this.keyFrames;
	}
}
