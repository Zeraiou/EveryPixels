package com.fap.APM;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Input.Keyboard;
import com.fap.APM.Units.Player;
import com.fap.APM.Units.Zombie;
import com.fap.APM.World.Map;

public class GameOn extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;

	private boolean running = false;
	private final int screenWidth = 800;
    private final int screenHeight = 600;
    
    private Thread thread;
    public JFrame frame;
    private ScreenDisplay screen;
    private Keyboard keyboard;
    private Map map;
    private Player player;
    private Zombie zombie;

    private BufferedImage imageInFrame = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();

    public GameOn () {
        setPreferredSize(new Dimension(screenWidth, screenHeight));

        frame = new JFrame();
        screen = new ScreenDisplay(screenWidth, screenHeight);
        map = new Map(ControlRoom.MAP_PIXEL_SPRITE_PATH);

        keyboard = new Keyboard();
        addKeyListener(keyboard);

        player = new Player(ControlRoom.STARTING_X, ControlRoom.STARTING_Y, keyboard);
        map.addEntity(player);
        zombie = new Zombie(ControlRoom.STARTING_X, ControlRoom.STARTING_Y);
        map.addEntity(zombie);
    }
    
    public synchronized void startGame() {
    	running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

	public void run() {
		long lastTime = System.nanoTime();
		long clock1Sec = System.currentTimeMillis();
		double delta = 0;
		int fps = 0;
		int tps = 0;

		requestFocus();

		while(running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / ControlRoom.NANOSECONDE;
			lastTime = currentTime;
			while (delta >= 1) {
                keyboard.tickKeyboard();
                map.tickMap();
				tps++;
				delta--;
			}
			renderGame();
			fps++;

			if (System.currentTimeMillis() - clock1Sec > 1000) {
				clock1Sec += 1000;
				frame.setTitle(ControlRoom.GAME_TITLE + "    |     " + "Fps : "
						+ fps + " , Tps : " + tps
						+ "        |       " + " Pixels -- X : "
						+ (int) player.getXEntity() + ", Y: "
						+ (int) player.getYEntity() + "        |       "
						+ "Tuiles -- X : "
						+ (int) (player.getXEntity() / 12) + ", Y: "
						+ (int) (player.getYEntity() / 12)
						+ "        |       " + " Souris -- X : ");
				//		+ (int) Souris.SaisirX() + " , Y : "
				//		+ (int) Souris.SaisirY());
				fps = 0;
				tps = 0;
			}
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

		int xOffset = (int) player.getXEntity() - (screen.screenWidth / 2);
		int yOffset = (int) player.getYEntity() - (screen.screenHeight / 2);
		map.renderMap(xOffset, yOffset, screen);

		for (int i = 0; i < pixelsInFrame.length; i++) {
			pixelsInFrame[i] = screen.pixelsScreen[i];
		}

		Graphics graphics = BufferStrategy.getDrawGraphics();
		graphics.setColor(Color.BLUE);
		graphics.fillRect(0, 0, screenWidth, screenHeight);
		graphics.drawImage(imageInFrame, 0, 0, getWidth(), getHeight(), null);
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