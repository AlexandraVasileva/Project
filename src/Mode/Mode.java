package mode;

import java.awt.Font;

public class Mode {
	
	private String name;
	private int sizeOfType;
	private String font;

	public Mode(String name){
		this.name = name;
		sizeOfType = 12;
		font ="Serif"; 
	}
	
	public Mode(String font, int size){
		this.sizeOfType=size;
		this.font = font; 
	}
	
	public int getSizeOfType(){
		return sizeOfType;
	}
	
	public String getFont(){
		return font;
	}
	
	public String getName(){
		return name;
	}

	public void setSizeOfType(int size){
		this.sizeOfType = size;
	}
	
	public void setFont(String font){
		this.font = font; 
	}

	public void setName(String name){
		this.name = name; 
	}


}
