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
	
	private int screenWidth = 800;
    private int screenHeight = 600;

    private boolean running = false;
    
    private Thread thread;
    protected JFrame frame;
    private ScreenDisplay screen;
    private Keyboard keyboard;
    private Map map;
    private Player player;
    private Zombie zombie;
    
    
    private BufferedImage imageInFrame = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();

    
    
    public GameOn () {
    	Dimension sizeGame = new Dimension(screenWidth, screenHeight);
        setPreferredSize(sizeGame);
        frame = new JFrame();
        screen = new ScreenDisplay(screenWidth, screenHeight);
        
      //  map = new Map("/Map/Map64.png");
        map = new Map("/Map/Map512.png");
       // map = new Map("/Map/Map1024.png");
        //map = new Map("/Map/Map8192.png");
        
        
        
        
        keyboard = new Keyboard();
        addKeyListener(keyboard);
       
        
       player = new Player(map.xStatingPosition, map.yStartingPosition, keyboard);
       map.addEntity(player);
      // zombie = new Zombie(map.xStatingPosition, map.yStartingPosition);
       //map.addEntity(zombie);

    }
    
    public synchronized void startGame() {
    	running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }
    
  



	public void run() {
		long lastTime = System.nanoTime();
		long clock1Sec = System.currentTimeMillis();

		final double NANOSECONDE = 1000000000.0 / 60.0;
		double delta = 0;
		int fps = 0;
		int tps = 0;
		requestFocus();
		while(running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / NANOSECONDE;
			lastTime = currentTime;
			while (delta >= 1) {
				tickGame();
				tps++;
				delta--;
			}

			renderGame();
			fps++;

			if (System.currentTimeMillis() - clock1Sec > 1000) {
				clock1Sec += 1000;
				frame.setTitle(Keeper.gameTitle + "    |     " + "Fps : "
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
		
	
	
	public void tickGame() {
		
		
		keyboard.tickKeyboard();
		
		
		map.tickMap();
		
	}

	public void renderGame() {
		 BufferStrategy BufferStrategy = getBufferStrategy();

	        if (BufferStrategy == null) {
	           createBufferStrategy(3);
	            return;
	        }
	        
	        screen.clearScreen();
	        
	      
	    	int xOffset = (int) player.getXEntity() - (screen.widthScreen / 2);
	    	int yOffset = (int) player.getYEntity() - (screen.heightScreen / 2);
	    	
	        
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