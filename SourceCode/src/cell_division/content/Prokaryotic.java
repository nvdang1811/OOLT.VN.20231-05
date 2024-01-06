package cell_division.content;

import java.util.ArrayList;

public class Prokaryotic extends Cells {
	private String name;
	private ArrayList<Components> components;
	private String path;
	private Double[] keyFrames;
	
	public Prokaryotic(String name) {
		this.name = name;
		this.components = new ArrayList<Components>();
		this.components.add(new Components("DNA", "Central region containing the cell's genetic material in a single circular DNA molecule."));
		this.components.add(new Components("Mesosome", "Play a vital part in DNA replication, cell wall synthesis, and respiration"));
		this.components.add(new Components("Ribosome", "Cellular structures for protein synthesis, reading genetic information and assembling amino acids."));
		this.components.add(new Components("Cytoplasm", "Gel-like substance filling the cell interior, supporting metabolic activities."));
		this.components.add(new Components("Bacterial flagellum", "Whip-like appendage for cell movement, propelling the cell forward."));
		this.components.add(new Components("Capsule", "The capsule of a prokaryotic cell is a thick, outermost layer made of polysaccharide that provides protection, helps in moisture retention, and aids in adhesion to surfaces or other cells1"));
		this.components.add(new Components("Cell wall", "Rigid outer layer providing structural support and shape, located outside the plasma membrane."));
		this.components.add(new Components("Plasma membrane", "Lipid bilayer surrounding the cell, regulating substance passage and maintaining integrity."));
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
	
	public Double[] getComponentsX() {
		Double[] x = {120d, 187d, 239d, 291d, 406d, 181d, 120d, 44d};
		return x;
	}
	
	public Double[] getComponentsY() {
		Double[] y = {108d, 83d, 48d, 48d, 108d, 278d, 278d, 290d};
		return y;
	}
	
	public String getImage() {
		return "/cell_division/images/prokaryotic-cell.png";
	}
}
