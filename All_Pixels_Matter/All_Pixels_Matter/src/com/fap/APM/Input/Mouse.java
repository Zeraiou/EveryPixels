package com.fap.APM.Input;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener{

	private static int mouseX = -1;
	private static int mouseY = -1;
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