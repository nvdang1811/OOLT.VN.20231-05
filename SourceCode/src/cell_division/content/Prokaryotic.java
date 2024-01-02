package cell_division.content;

import java.util.ArrayList;

public class Prokaryotic extends Cells {
	private String name;
	private ArrayList<Components> components;
	public Prokaryotic() {
		// TODO Auto-generated constructor stub
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
		
	}
	
	public void Mitosis() {
		
	}
}
