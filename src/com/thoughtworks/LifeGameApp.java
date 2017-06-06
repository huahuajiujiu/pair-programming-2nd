package com.thoughtworks;

public class LifeGameApp {
	public static void main(String[] args) {
		Cell[] liveCells = { new Cell(0, 0, 1), new Cell(0, 2, 1), new Cell(0, 5, 1), new Cell(1, 1, 1),
				new Cell(1, 4, 1), new Cell(1, 7, 1), new Cell(1, 9, 1), new Cell(2, 0, 1), new Cell(2, 2, 1),
				new Cell(2, 5, 1), new Cell(2, 7, 1), new Cell(3, 4, 1), new Cell(4, 1, 1), new Cell(4, 3, 1),
				new Cell(4, 5, 1), new Cell(4, 7, 1), new Cell(4, 9, 1), new Cell(5, 0, 1), new Cell(5, 2, 1),
				new Cell(5, 4, 1), new Cell(5, 6, 1), new Cell(5, 8, 1), new Cell(6, 5, 1), new Cell(7, 4, 1),
				new Cell(7, 8, 1), new Cell(8, 0, 1), new Cell(8, 1, 1), new Cell(8, 2, 1), new Cell(8, 5, 1),
				new Cell(8, 7, 1), new Cell(8, 8, 1), new Cell(8, 9, 1), new Cell(9, 4, 1), new Cell(9, 8, 1), };

		LifeGame game = new LifeGame();
		game.init(liveCells);

		LifeGameRender render = new LifeGameRender(game);

		while (true) {
			try {
				Thread.sleep(500);
				game.next();
				render.show();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
