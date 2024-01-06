package cell_division.content;

import java.util.ArrayList;

public class Eukaryotic extends Cells{
	private String name;
	private ArrayList<Components> components;
	private String path;
	private Double[] keyFrames;
	public Eukaryotic(String name) {
		this.name = name;
		this.components = new ArrayList<Components>();
		this.components.add(new Components("Lysosome", "Membrane-bound vesicles containing digestive enzymes.\nBreak down cellular waste and debris."));
		this.components.add(new Components("Golgi vesicles", "Part of the Golgi complex that modifies, sorts, and packages proteins for secretion."));
		this.components.add(new Components("Rough ER", "Network of membranes extending from the nuclear envelope.\nRough ER has ribosomes and is involved in protein synthesis"));
		this.components.add(new Components("Smooth ER", "Network of membranes extending from the nuclear envelope.\nSmooth ER is involved in lipid synthesis."));
		this.components.add(new Components("Cell membrane", "Outer boundary of the cell that separates it from the external environment.\nRegulates the passage of substances in and out of the cell."));
		this.components.add(new Components("Centrioles", "Cylindrical, microtube-based structures. Play a crucial role in cell division by aiding in the formation of the spindle apparatus and in cellular processes."));
		this.components.add(new Components("Golgi apparatus", "Stack of membranes that modifies, sorts, and packages proteins for secretion."));
		this.components.add(new Components("Mitochondrion", "Powerhouse of the cell.\nGenerates energy (ATP) through cellular respiration."));
		this.components.add(new Components("Nucleolus", "Site within the nucleus where ribosomes are produced and assembled."));
		this.components.add(new Components("Nucleus", "A membrane-bound organelle that stores the cell's DNA.\n It directs the synthesis of proteins and ribosomes, and plays a crucial role in cell division, growth and reproduction."));;
		this.components.add(new Components("Microtubules", "Hollow structures made of alpha and beta tubulin proteins, forming part of a eukaryotic cell's cytoskeleton.\n They play key roles in cell movement, cell division and intracellular material transport"));
		this.components.add(new Components("Cytoplasm", "Gel-like substance filling the cell.\nHouses organelles and is the site of many cellular activities."));
		this.components.add(new Components("Ribosome", "Found in the cytoplasm or attached to the endoplasmic reticulum.\nSite of protein synthesis."));	
		
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

	public String getDirectory() {
		return this.path;
	}
	
	public Double[] getKeyFrames() {
		return this.keyFrames;
	}
	
	public Double[] getComponentsX() {
		Double[] x = {40d, 26d, 14d, 26d, 20d, 26d, 254d, 312d, 312d, 322d, 322d, 312d, 306d};
		return x;
	}
	
	public Double[] getComponentsY() {
		Double[] y = {46d, 82d, 122d, 194d, 219d, 272d, 23d, 46d, 95d, 176d, 232d, 260d, 297d};
		return y;
	}
	
	public String getImage() {
		return "/cell_division/images/Eukaryotic-cell.jpg";
	}
}
