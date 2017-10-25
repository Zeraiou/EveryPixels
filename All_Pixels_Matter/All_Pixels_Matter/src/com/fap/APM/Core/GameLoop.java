package com.fap.APM.Core;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.*;
import com.fap.APM.Core.Input.Keyboard;
import com.fap.APM.Core.Input.Mouse;
import com.fap.APM.Graphics.Phy.GameClock;

public class GameLoop extends Canvas implements Runnable {

    private BufferedImage imageInFrame = new BufferedImage(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();
    private static final long serialVersionUID = 1L;
    private boolean running;
	public JFrame frame;

    public GameLoop() {
        setPreferredSize(new Dimension(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT));
        frame = new JFrame();

        addKeyListener(Keyboard.shared());
        addMouseListener(Mouse.shared());

        WorldMaker.shared().createPlayer();
        WorldMaker.shared().createZombie();
        WorldMaker.shared().createEspirito();
    }

	public void run() {
		requestFocus();
        running = true;

		while(running) {
		    GameClock.shared().clockTick(frame);
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
}