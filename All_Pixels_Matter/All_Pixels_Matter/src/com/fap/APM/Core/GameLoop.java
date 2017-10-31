package com.fap.APM.Core;
import com.fap.APM.Core.Input.Keyboard;
import com.fap.APM.Core.Input.Mouse;
import com.fap.APM.Graphics.Phy.AI;
import com.fap.APM.Graphics.Phy.CollisionManager;
import com.fap.APM.WorldObjects.Units.Player;
import com.fap.APM.WorldObjects.WorldList;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import static com.fap.APM.Core.ControlRoom.TITLE_INFO_OUT;

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

	private static synchronized void startGame(GameLoop gameLoop) {
		Thread thread = new Thread(gameLoop, "Display");
		thread.start();
	}

    @Override
    public void run() {
        addKeyListener(Keyboard.shared());
        Keyboard.shared().inputManager.loadInputActions(frame);
        addMouseListener(Mouse.shared());
        ControlRoom.PLAYER = new Player();
        requestFocus();
        running = true;

        while (running) {
            if (nextTick() == true) {
                worldTick();
                CollisionManager.shared().collisionDetection();
                WorldMaker.shared().removeEntity();
                renderScreen();
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
        graphics.dispose();
        BufferStrategy.show();
    }

    private void setTitleInfo() {
        if (TITLE_INFO_OUT == true) {
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

