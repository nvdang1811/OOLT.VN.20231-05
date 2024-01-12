package cell_division.content;

import java.util.ArrayList;

public abstract class Cells{
	private String cellName;
	private ArrayList<Components> components;
	public abstract String getDirectory();
	public abstract Double[] getKeyFrames();
	public abstract ArrayList<Components> getComponents();
	public abstract Double[] getComponentsX();
	public abstract Double[] getComponentsY();
	public abstract String getImage();
	public abstract void Amitosis();
	public abstract void Meiosis();
	public abstract void Mitosis();
}
