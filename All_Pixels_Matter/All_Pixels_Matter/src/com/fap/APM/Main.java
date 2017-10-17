package com.fap.APM;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {

	        GameOn game = new GameOn();

	        game.frame.setResizable(false);
	        game.frame.setTitle(Keeper.gameTitle);
	        game.frame.add(game);
	        game.frame.pack();
	        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        game.frame.setLocationRelativeTo(null);
	        game.frame.setVisible(true);

	        game.startGame();
	    }
}
