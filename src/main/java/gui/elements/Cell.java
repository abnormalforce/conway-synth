package main.java.gui.elements;

import java.awt.Color;

import javax.swing.JButton;

public class Cell extends JButton{
	private static final Color aliveColor = Color.CYAN;
	private static final Color deadColor = Color.BLACK;
	
	private Color color;	
	private boolean isAlive;
	
	public Cell(){
		super(" ");
		isAlive=false;
		color = Color.BLACK;
		setBackground(color);
	}
	
	public void update(){
		if(isAlive){
			kill();
		}
		else{
			live();
		}
	}
	
	public void live(){
		isAlive = true;
		color = aliveColor;
		setBackground(color);
	}
	
	public void kill(){
		isAlive = false;
		color = deadColor;
		setBackground(color);
	}
	
	public boolean isAlive(){
		return isAlive;
	}
}
