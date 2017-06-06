package com.thoughtworks;

import java.util.ArrayList;

public class LifeGame {
	static int rows = 10;
	static int cols = 10;
	static int[][] temp = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };

	public Cell[] cells;
	private ArrayList<Cell> liveOrDie = new ArrayList<>();

	public LifeGame() {
		cells = new Cell[rows * cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				cells[i * cols + j] = new Cell(i, j, 0);
			}
		}

	}

	public void init(Cell[] liveCells) {

		for (int i = 0; i < liveCells.length; i++) {
			Cell cell = liveCells[i];
			int index = cell.getRow() * cols + cell.getCol();
			cells[index] = new Cell(cell.getRow(), cell.getCol(), cell.getState());
		}
	}

	public void next() {
		getChangedState();
		updateState();
	}

	private void updateState() {
		for (Cell cell : liveOrDie) {
			int index = cell.getRow() * cols + cell.getCol();
			cells[index] = new Cell(cell.getRow(), cell.getCol(), cell.getState());
		}
	}

	private void computeCellState(int index) {
		ArrayList<Cell> neighborCells = getNeighborCell(index);
		int neighborSum = 0;

		for (Cell neighbor : neighborCells) {
			neighborSum += neighbor.getState();
		}
		if (neighborSum < 2 || neighborSum > 3)
			liveOrDie.add(new Cell(cells[index].getRow(), cells[index].getCol(), 0));

		else if (neighborSum == 3) {
			liveOrDie.add(new Cell(cells[index].getRow(), cells[index].getCol(), 1));
		}
	}

	private ArrayList<Cell> getNeighborCell(int index) {
		int i = cells[index].getRow();
		int j = cells[index].getCol();
		ArrayList<Cell> neighborCell = new ArrayList<>();
		for (int k = 0; k < temp.length; k++) {
			int newRow = i + temp[k][0];
			int newCol = j + temp[k][1];
			if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
				continue;
			}
			int newIndex = newRow * cols + newCol;
			neighborCell.add(new Cell(newRow, newCol, cells[newIndex].getState()));
		}
		return neighborCell;
	}

	private void getChangedState() {
		for (int i = 0; i < cells.length; i++) {
			computeCellState(i);
		}
	}

}
