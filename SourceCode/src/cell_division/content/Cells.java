package cell_division.content;

import java.util.ArrayList;

public abstract class Cells implements Process{
	private String cellName;
	private ArrayList<Components> components;
	public abstract String getDirectory();
	public abstract Double[] getKeyFrames();
	public abstract ArrayList<Components> getComponents();
	public abstract Double[] getComponentsX();
	public abstract Double[] getComponentsY();
	public abstract String getImage();
}
