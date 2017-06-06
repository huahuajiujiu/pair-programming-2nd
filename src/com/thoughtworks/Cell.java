package com.thoughtworks;

public class Cell {
	public Cell(int row, int col, int state) {
		this.row = row;
		this.col = col;
		this.state = state;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getState() {
		return state;
	}

	int row;
	int col;
	int state;
}
