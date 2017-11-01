package com.fap.APM.Core;
import com.fap.APM.Helpers.ControlRoom;
import com.fap.APM.Core.Input.Keyboard;
import com.fap.APM.Core.Input.Mouse;
import com.fap.APM.GUI.ManagerGUI;
import com.fap.APM.Graphics.Phy.AI;
import com.fap.APM.Graphics.Phy.CollisionManager;
import com.fap.APM.Graphics.Units.Player;
import com.fap.APM.Helpers.Helper;

import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GameLoop extends Canvas implements Runnable {

    private BufferedImage imageInFrame = new BufferedImage(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();
    private static final long serialVersionUID = 1L;
    public JFrame frame = new JFrame();
    long clock1Sec = System.currentTimeMillis();
    long lastTime = System.nanoTime();
    private boolean running;
    double delta = 0;

	public static void main(String[] args) {
		GameLoop gameLoop = new GameLoop();
		gameLoop.setPreferredSize(new Dimension(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT));
		gameLoop.frame.setResizable(false);
		gameLoop.frame.setTitle(ControlRoom.GAME_TITLE);
        gameLoop.frame.add(gameLoop);
		gameLoop.frame.pack();
		gameLoop.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameLoop.frame.setLocationRelativeTo(null);
		gameLoop.frame.setVisible(true);
        startGame(gameLoop);
	}

	private void GameLoop() {
        new WorldMaker();
        new GUIMaker();
        new InGameClock();
        new Keyboard();
        new Mouse();
        new DrawManager();
        new EffectsManager();
        new CollisionManager();
        new AI();

        
        AI.shared().generateResource(10);
    }

    @Override
    public void run() {
	    addInputDevices();

        ControlRoom.PLAYER = new Player();
        requestFocus();
        running = true;

        while (running) {
            if (nextTick() == true) {
                InGameClock.shared().tickInGameClock();
            	worldTick();
                CollisionManager.shared().collisionDetection();
                WorldMaker.shared().removeEntity();
                renderScreen();
                prepareForNextTick();
            }
        }
        running = false;
    }

    private boolean nextTick() {
        boolean timeForNewTick = false;
        long currentTime = System.nanoTime();
        delta += (currentTime - lastTime) / ControlRoom.NANOSECONDE;
        lastTime = currentTime;

        if (delta >= 1) {
            ControlRoom.TPS++;
            ControlRoom.FPS++;
            delta--;
            timeForNewTick = true;
        }

        setTitleInfo();
        if (timeForNewTick == true) {
            return true;
        }
        return false;
    }

    private void worldTick() {
        ControlRoom.PLAYER.nextTick();
        AI.shared().monstersNextTick();
        EffectsManager.shared().effectsNextTick();
        GUIMaker.shared().tickGUI();
    }

    private void renderScreen() {
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
        GUIMaker.shared().managerGUI.renderManagerGUI(graphics);
        graphics.dispose();
        BufferStrategy.show();
    }

    private static void prepareForNextTick() {
        // Helper.currentPlayerTileCoords();
        //CollisionManager.shared().setNextActiveScope();
    }

    private static synchronized void startGame(GameLoop gameLoop) {
        Thread thread = new Thread(gameLoop, "Display");
        thread.start();
    }

    private void addInputDevices() {
        Keyboard.shared().inputManager.loadInputActions(frame);
        addKeyListener(Keyboard.shared());
        addMouseListener(Mouse.shared());
    }

    private void setTitleInfo() {
        if (ControlRoom.TITLE_INFO_OUT == true) {
            if (System.currentTimeMillis() - clock1Sec > 1000) {
                clock1Sec += 1000;
                frame.setTitle(ControlRoom.GAME_TITLE + " | Fps: " + ControlRoom.FPS + ", Tps: " + ControlRoom.TPS
                        + " | Pixels (" + (int) ControlRoom.PLAYER.posX + "," + (int) ControlRoom.PLAYER.posY + ") | Tile: (" + (int) (ControlRoom.PLAYER.posX / 12) + "," + (int) (ControlRoom.PLAYER.posY / 12) + ") | "
                        + "Mouse: (" + Mouse.shared().getMouseX() + "," + Mouse.shared().getMouseY() + ")");
                ControlRoom.FPS = 0;
                ControlRoom.TPS = 0;
            }
        }
    }
}

