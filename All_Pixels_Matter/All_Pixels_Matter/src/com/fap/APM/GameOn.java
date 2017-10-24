package com.fap.APM;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.fap.APM.Graphics.DrawManager;
import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Input.Keyboard;
import com.fap.APM.Phy.GameClock;
import com.fap.APM.World.WorldList;
import com.fap.APM.World.WorldMaker;

public class GameOn extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private boolean running = false;
    private Thread thread;
    private ScreenDisplay screen;
    private Keyboard keyboard;
	public JFrame frame;

    private BufferedImage imageInFrame = new BufferedImage(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();

    public GameOn () {
        setPreferredSize(new Dimension(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT));
        frame = new JFrame();
        screen = new ScreenDisplay(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT);
        keyboard = new Keyboard();
        addKeyListener(keyboard);
        WorldMaker.shared().createPlayer("Zercos", keyboard);
    }
    
    public synchronized void startGame() {
    	running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

	public void run() {
		requestFocus();

		while(running) {
		    GameClock.shared().clockTick(frame, keyboard);
			renderGame();
		}

		stopGame();
	}

	public void renderGame() {
		 BufferStrategy BufferStrategy = getBufferStrategy();

		if (BufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clearScreen();

		int xOffset = (int) WorldList.players.get(0).getXEntity() - ControlRoom.SCREEN_CENTER_X;
		int yOffset = (int) WorldList.players.get(0).getYEntity() - ControlRoom.SCREEN_CENTER_Y;
		DrawManager.shared().renderMap(xOffset, yOffset, screen);

		for (int i = 0; i < pixelsInFrame.length; i++) {
			pixelsInFrame[i] = screen.pixelsScreen[i];
		}

		Graphics graphics = BufferStrategy.getDrawGraphics();
		graphics.setColor(Color.BLUE);
		graphics.fillRect(0, 0, ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT);
		graphics.drawImage(imageInFrame, 0, 0, ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT, null);
		graphics.dispose();
		BufferStrategy.show();
	}

	public synchronized void stopGame() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}