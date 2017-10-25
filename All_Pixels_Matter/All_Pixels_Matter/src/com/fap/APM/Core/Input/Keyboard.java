package com.fap.APM.Core.Input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private static Keyboard INSTANCE = null;
    private boolean[] keys = new boolean[199];
    public boolean up, rigth, down, left, potionLife, potionMagic, potionExperience, dammage;

    private Keyboard() { }
    public static Keyboard shared() {
        if (INSTANCE == null) {
            INSTANCE = new Keyboard();
        }
        return INSTANCE;
    }

    public void updateKeyboard() {
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

//	public void player() {
//		switch (key) {
//			case 1: key.esc;
//				Menu.shared().openUserInterface();
//				break;
//			case 2:  key up;
//				player.move()
//				break;
//			case 3:  monthString = "March";
//				break;
//			case 4:  monthString = "April";
//				break;
//			case 5:  monthString = "May";
//				break;
//			case 6:  monthString = "June";
//				break;
//			case 7:  monthString = "July";
//				break;
//			case 8:  monthString = "August";
//				break;
//			case 9:  monthString = "September";
//				break;
//			case 10: monthString = "October";
//				break;
//			case 11: monthString = "November";
//				break;
//			case 12: monthString = "December";
//				break;
//			default: monthString = "Invalid month";
//				break;
//		}
//	}


}
