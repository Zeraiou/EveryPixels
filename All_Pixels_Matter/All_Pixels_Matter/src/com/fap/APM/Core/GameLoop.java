package com.fap.APM.Core;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import com.fap.APM.Core.Input.Keyboard;
import com.fap.APM.Graphics.Phy.GameClock;

public class GameLoop extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private boolean running = false;
    private Thread thread;
	public JFrame frame;

    private BufferedImage imageInFrame = new BufferedImage(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();

    public GameLoop() {
        setPreferredSize(new Dimension(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT));
        frame = new JFrame();
        addKeyListener(Keyboard.shared());
        WorldMaker.shared().createPlayer();
        WorldMaker.shared().createZombie();
    }

	public void run() {
		requestFocus();

		while(running) {
		    GameClock.shared().clockTick(frame);
			renderScreen();
		}

		stopGame();
	}

	public void renderScreen() {
		 BufferStrategy BufferStrategy = getBufferStrategy();

		if (BufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}

		DrawManager.shared().renderScreen();

		for (int i = 0; i < pixelsInFrame.length; i++) {
			pixelsInFrame[i] = DrawManager.shared().pixelsScreen[i];
		}

		Graphics graphics = BufferStrategy.getDrawGraphics();
		graphics.setColor(Color.BLUE);
		graphics.fillRect(0, 0, ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT);
		graphics.drawImage(imageInFrame, 0, 0, ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT, null);
		graphics.dispose();
		BufferStrategy.show();
	}

    public synchronized void startGame() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
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