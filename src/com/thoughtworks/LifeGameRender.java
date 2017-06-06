package com.thoughtworks;

public class LifeGameRender {
	private LifeGame game;

	public LifeGameRender(LifeGame game) {
		this.game = game;
	}

	public void show() {
		System.out.println("-----------Next State-----------");
		for (int i = 0; i < LifeGame.rows; i++) {
			for (int j = 0; j < LifeGame.cols; j++) {
				int index = i * LifeGame.cols + j;
				if (game.cells[index].getState() == 0) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
	}
}
