package com.fap.APM.Core.Input;
import com.fap.APM.Core.ControlRoom;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {

	private static int mouseX = ControlRoom.SCREEN_CENTER_X;
	private static int mouseY = ControlRoom.SCREEN_CENTER_Y;
	private static int mouseButton = MouseEvent.NOBUTTON;
	public static int alternatePushReleaseButton = 0;
	
	public static int getMouseX() {
		return mouseX;
	}
	
	public static int getMouseY() {
		return mouseY;
	}
	
	public static int getButton() {
		return mouseButton;
	}
	
	public static int getAlternatePushReleaseButton() {
		return alternatePushReleaseButton;
	}
	
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		alternatePushReleaseButton++;
	}
	
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseClicked(MouseEvent e) {
	    mouseButton = e.getButton();
	    if (mouseButton == 1) {
            System.out.println("Mouse Button 1: " + mouseButton);
        } else if (mouseButton == 2) {
            System.out.println("Mouse Button 2: " + mouseButton);
        } else if (mouseButton == 3) {
            System.out.println("Mouse Button 3: " + mouseButton);
        } else if (mouseButton == 0) {
            System.out.println("Mouse Button 0: " + mouseButton);
        } else {
            System.out.println("Default Mouse: " + mouseButton);
        }
	}

	public void mousePressed(MouseEvent e) {
		mouseButton = e.getButton();
		alternatePushReleaseButton++;	
	}
	
	public void mouseReleased(MouseEvent e) {
		mouseButton = MouseEvent.NOBUTTON;
		alternatePushReleaseButton = 0;
	}

	public void mouseEntered(MouseEvent e) {
		mouseButton = MouseEvent.NOBUTTON;
		alternatePushReleaseButton = 0;		
	}

	public void mouseExited(MouseEvent e) {
		mouseButton = MouseEvent.NOBUTTON;
		alternatePushReleaseButton = 0;	
	}
}