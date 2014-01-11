package main.java.conway;

import java.util.ArrayList;

import main.java.gui.elements.Cell;

public class GameLogic {
	private Cell[][] grid;
	private int numNotes;
	private int numColumns;

	public GameLogic(Cell[][] grid, int numNotes, int numColumns) {
		this.grid = grid;
		this.numNotes = numNotes;
		this.numColumns = numColumns;
	}

	// iterate through the grid once and return a grid of the next lifecycle
//	public Cell[][] lifecycle() {
	public boolean lifecycle(int x, int y){
//		Cell[][] nextCycle = new Cell[numNotes][numColumns];

//		for (int y = 0; y < numNotes; y++) {
//			for (int x = 0; x < numColumns; x++) {
				// examine surrounding ~8 cells
				// decide if current coordinate is alive or dead
				
				BorderPosition borderPosition;
				System.out.println("x: " + x + " y: " + y);
				if(x == 0){
					if(y == 0){
						borderPosition = BorderPosition.TOPLEFT;
					}
					else if(y == numNotes-1){
						borderPosition = BorderPosition.BOTTOMLEFT;
					}
					else{
						borderPosition = BorderPosition.LEFT;
					}
				}
				else if(y == 0){
					if(x == 0){
						borderPosition = BorderPosition.TOPLEFT;
					}
					else if(x == numColumns-1){
						borderPosition = BorderPosition.TOPRIGHT;
					}
					else{
						borderPosition = BorderPosition.TOP;
					}
				}
				else if(x == numColumns-1){
					if(y == 0){
						borderPosition = BorderPosition.TOPRIGHT;
					}
					else if(y == numNotes-1){
						borderPosition = BorderPosition.BOTTOMRIGHT;
					}
					else{
						borderPosition = BorderPosition.RIGHT;
					}
				}
				else if(y == numNotes-1){
					if(x == 0){
						borderPosition = BorderPosition.BOTTOMLEFT;
					}
					else if(x == numColumns-1){
						borderPosition = BorderPosition.BOTTOMRIGHT;
					}
					else{
						borderPosition = BorderPosition.BOTTOM;
					}
				}
				else{
					borderPosition = BorderPosition.CENTER;
				}

//				Cell nextCell = new Cell();
 				
				int aliveNeighbors = 0;
				ArrayList<Cell> neighbors = new ArrayList<Cell>();
				
				System.out.println("Cell " + x + "," + y + ": " + borderPosition);
				
				if(borderPosition == BorderPosition.TOPLEFT){
					System.out.println(x + " " + y);
					neighbors.add(grid[x+1][y]);
					neighbors.add(grid[x][y+1]);
					neighbors.add(grid[x+1][y+1]);
				}
				else if( borderPosition == BorderPosition.TOP){
					System.out.println(x + " " + y);
					neighbors.add(grid[x - 1][y]);
					neighbors.add(grid[x + 1][y]);
					neighbors.add(grid[x - 1][y + 1]);
					neighbors.add(grid[x][y + 1]);
					neighbors.add(grid[x + 1][y + 1]);
				}
				else if( borderPosition == BorderPosition.TOPRIGHT){
					neighbors.add(grid[x - 1][y]);
					neighbors.add(grid[x - 1][y + 1]);
					neighbors.add(grid[x][y + 1]);
				}
				else if( borderPosition == BorderPosition.LEFT){
					neighbors.add(grid[x][y - 1]);
					neighbors.add(grid[x + 1][y - 1]);
					neighbors.add(grid[x + 1][y]);
					neighbors.add(grid[x][y + 1]);
					neighbors.add(grid[x + 1][y + 1]);
				}
				else if( borderPosition == BorderPosition.RIGHT){
					neighbors.add(grid[x - 1][y - 1]);
					neighbors.add(grid[x][y - 1]);
					neighbors.add(grid[x - 1][y]);
					neighbors.add(grid[x - 1][y + 1]);
					neighbors.add(grid[x][y + 1]);
				}
				else if( borderPosition == BorderPosition.BOTTOMLEFT){
					neighbors.add(grid[x][y - 1]);
					neighbors.add(grid[x + 1][y - 1]);
					neighbors.add(grid[x + 1][y]);
				}
				else if( borderPosition == BorderPosition.BOTTOM){
					neighbors.add(grid[x - 1][y - 1]);
					neighbors.add(grid[x][y - 1]);
					neighbors.add(grid[x + 1][y - 1]);
					neighbors.add(grid[x - 1][y]);
					neighbors.add(grid[x + 1][y]);
				}
				else if( borderPosition == BorderPosition.BOTTOMRIGHT){
					neighbors.add(grid[x - 1][y - 1]);
					neighbors.add(grid[x][y - 1]);
					neighbors.add(grid[x - 1][y]);
				}
				else{
					neighbors.add(grid[x - 1][y - 1]);
					neighbors.add(grid[x][y - 1]);
					neighbors.add(grid[x + 1][y - 1]);
					neighbors.add(grid[x - 1][y]);
					neighbors.add(grid[x + 1][y]);
					neighbors.add(grid[x - 1][y + 1]);
					neighbors.add(grid[x][y + 1]);
					neighbors.add(grid[x + 1][y + 1]);
				}
				System.out.println("****************");
				for (Cell neighbor : neighbors) {
					if (neighbor.isAlive()) {
						aliveNeighbors++;
					}
				}

				boolean nextCellAlive = false;
				if(grid[x][y].isAlive()){
					if ((aliveNeighbors < 2) || (aliveNeighbors > 3)) {
//						nextCell.kill();
						nextCellAlive = false;
					}
				}
				else{
					if(aliveNeighbors == 3){
//						nextCell.live();
						nextCellAlive = true;
					}
				}
				
//				nextCycle[x][y] = nextCell;
				
//			}
//		}

//		return nextCycle;
				return nextCellAlive;
	}
}
