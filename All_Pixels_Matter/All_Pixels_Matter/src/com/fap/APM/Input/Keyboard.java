package com.fap.APM.Input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[199];
	public boolean up, rigth, down, left, potionLife, potionMagic, potionExperience, dammage;
	
	public void tickKeyboard() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		rigth = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];		
		potionLife = keys[KeyEvent.VK_G];
		potionMagic = keys[KeyEvent.VK_H];
		potionExperience = keys[KeyEvent.VK_J];
		dammage = keys[KeyEvent.VK_T];
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {

	}
}