package com.fap.APM.Core;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.*;
import com.fap.APM.Core.Input.Keyboard;
import com.fap.APM.Core.Input.Mouse;
import com.fap.APM.Graphics.Phy.AI;
import com.fap.APM.WorldObjects.Units.Player;
import com.fap.APM.WorldObjects.WorldList;

public class GameLoop extends Canvas implements Runnable {

    private BufferedImage imageInFrame = new BufferedImage(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();
    private static final long serialVersionUID = 1L;
    public JFrame frame = new JFrame();
    long clock1Sec = System.currentTimeMillis();
    long lastTime = System.nanoTime();
    private boolean running;
    double delta = 0;

    public GameLoop() {
        setPreferredSize(new Dimension(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT));
        ControlRoom.PLAYER = new Player();
        Keyboard.shared().loadInputActions(frame);
        addKeyListener(Keyboard.shared());
        addMouseListener(Mouse.shared());
    }

	public void run() {
		requestFocus();
        running = true;

		while(running) {
		    nextTick();

			renderScreen();
		}

        running = false;
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

    public void nextTick() {
        long currentTime = System.nanoTime();
        delta += (currentTime - lastTime) / ControlRoom.NANOSECONDE;
        lastTime = currentTime;

        if (delta >= 1) {
            worldTick();
            WorldMaker.shared().removeEntity();
            ControlRoom.TPS++;
            delta--;
        }

        ControlRoom.FPS++;


        if (System.currentTimeMillis() - clock1Sec > 1000) {
            clock1Sec += 1000;
            frame.setTitle(ControlRoom.GAME_TITLE + " | Fps: "
                    + ControlRoom.FPS + ", Tps: " + ControlRoom.TPS
                    + " | Pixels (" + (int) ControlRoom.PLAYER.posX + "," + (int) ControlRoom.PLAYER.posY + ") | "
                    + "Tile: (" + (int) (ControlRoom.PLAYER.posX / 12) + "," + (int) (ControlRoom.PLAYER.posY / 12) + ") | "
                    + "Mouse: (" + Mouse.shared().getMouseX() + "," + Mouse.shared().getMouseY() + ")");
            ControlRoom.FPS = 0;
            ControlRoom.TPS = 0;
        }
    }

    private void worldTick() {
        ControlRoom.PLAYER.nextTick();

        for (int i = 0; i < WorldList.monsters.size(); i++) {
            WorldList.monsters.get(i).nextTick();
        }

        for (int i = 0; i < WorldList.particles.size(); i++) {
            WorldList.particles.get(i).nextTick();
        }

        AI.shared().tickAI();
    }
}