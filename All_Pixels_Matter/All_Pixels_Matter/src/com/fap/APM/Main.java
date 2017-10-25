package com.fap.APM;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Core.GameLoop;
import javax.swing.JFrame;

public class Main {

	private static GameLoop gameLoop;
    private static Thread thread;
    
	public static void main(String[] args) {

		gameLoop = new GameLoop();
		gameLoop.frame.setResizable(false);
		gameLoop.frame.setTitle(ControlRoom.GAME_TITLE);
		gameLoop.frame.add(gameLoop);
		gameLoop.frame.pack();
		gameLoop.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameLoop.frame.setLocationRelativeTo(null);
		gameLoop.frame.setVisible(true);

		startGame();
	}

	private static synchronized void startGame() {

		thread = new Thread(gameLoop, "Display");
		thread.start();
	}
}