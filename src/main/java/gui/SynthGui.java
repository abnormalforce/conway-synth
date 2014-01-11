package main.java.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.java.gui.elements.Cell;

public class SynthGui {
	JFrame frame = new JFrame();
	JButton[][] grid;
	
	private static final int NUM_COLUMNS = 8;
	private static final int NUM_NOTES = 8;
	
	public static void main(String[] args){
		new SynthGui();
	}
	
	public SynthGui(){
		frame.setLayout(new GridLayout(NUM_COLUMNS, NUM_NOTES));
		grid = new JButton[NUM_COLUMNS][NUM_NOTES];
		
		for(int y = 0; y < NUM_NOTES; y++){
			for(int x = 0; x < NUM_COLUMNS; x++){
				Cell newCell = new Cell();
				newCell.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent click) {
						((Cell)click.getSource()).update();
					}
				});
				grid[x][y] = newCell;
				frame.add(newCell);
			}
		}
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
