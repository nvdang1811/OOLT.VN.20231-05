package cell_division.content;

import java.util.ArrayList;

public class Eukaryotic extends Cells{
	private String name;
	private ArrayList<Components> components;
	private final String pathMeiosis = "./../videos/Meiosis.mp4";

	@Override
	public void Amitosis() {
	}

	@Override
	public void Meiosis() {
	}

	@Override
	public void Mitosis() {
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

	public String getDirectoryMeiosis() {
		return this.pathMeiosis;
	}
}
