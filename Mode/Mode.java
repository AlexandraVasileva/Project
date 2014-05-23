package Mode;

import java.awt.Font;

public class Mode {
	private int sizeOfType;
	private String font;
	private int style;
	public Mode(){
		sizeOfType=5;
		font ="Serif"; 
		style=Font.BOLD;
	}
	public Mode(String font,int style,int size){
		this.sizeOfType=size;
		this.font =font; 
		this.style=style;
	}
	public int getSizeOfType(){
		return sizeOfType;
	}
	public String getFont(){
		return font;
	}
	public int getStyle(){
		return style;
	}
	public void setSizeOfType(Mode mode){
		this.sizeOfType=5;
	}
	public void setFont(Mode mode){
		this.font ="Serif"; 
	}
	public void setStyle(Mode mode){
		mode.style=Font.BOLD;
	}
	
	

}
