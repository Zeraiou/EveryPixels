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
	private static Mouse INSTANCE = null;

    private Mouse() { }
    public static Mouse shared() {
        if (INSTANCE == null) {
            INSTANCE = new Mouse();
        }
        return INSTANCE;
    }

	public static int getMouseX() {
		return mouseX;
	}
	
	public static int getMouseY() {
	    return mouseY;
	}
	
	public static int getButton() {
        if (ControlRoom.MOUSE_INPUT_OUT == true) {
            System.out.println("getButton Method Called: " + mouseButton);
        }
	    return mouseButton;
	}
	
	public static int getAlternatePushReleaseButton() {
        if (ControlRoom.MOUSE_INPUT_OUT == true) {
            System.out.println("getAlternatePushReleaseButton Method Called: " + alternatePushReleaseButton);
        }
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
            System.out.println("Mouse Clicked 1:" + mouseButton);
        } else if (mouseButton == 2) {
            System.out.println("Mouse Clicked 2:" + mouseButton);
        } else if (mouseButton == 3) {
            System.out.println("Mouse Clicked 3:" + mouseButton);
        } else if (mouseButton == 0) {
            System.out.println("Mouse Clicked 0" + mouseButton);
        } else {
            System.out.println("Unrecognized Mouse Clicked: " + mouseButton);
        }
	}

	public void mousePressed(MouseEvent e) {
		mouseButton = e.getButton();
		alternatePushReleaseButton++;
		if (ControlRoom.MOUSE_INPUT_OUT == true) {
            if (mouseButton == 1) {
                System.out.println("Mouse Pressed 1:" + mouseButton);
            } else if (mouseButton == 2) {
                System.out.println("Mouse Pressed 2:" + mouseButton);
            } else if (mouseButton == 3) {
                System.out.println("Mouse Pressed 2:" + mouseButton);
            } else if (mouseButton == 0) {
                System.out.println("Mouse Pressed 2:" + mouseButton);
            } else {
                System.out.println("Unrecognized Mouse Pressed:" + mouseButton);
            }
        }
	}
	
	public void mouseReleased(MouseEvent e) {
        if (ControlRoom.MOUSE_INPUT_OUT == true) {
            if (mouseButton == 1) {
                System.out.print("Mouse Released 1:" + mouseButton + " ");
            } else if (mouseButton == 2) {
                System.out.print("Mouse Released 2: " + mouseButton + " ");
            } else if (mouseButton == 3) {
                System.out.print("Mouse Released 3: " + mouseButton + " ");
            } else if (mouseButton == 0) {
                System.out.print("Mouse Released 0: " + mouseButton + " ");
            } else {
                System.out.print("Unrecognized Mouse Released: " + mouseButton + " ");
            }
        }
        mouseButton = MouseEvent.NOBUTTON;
        alternatePushReleaseButton = 0;

        if (ControlRoom.MOUSE_INPUT_OUT == true) {
            System.out.print("MouseButton.NOBUTTON (0,0)/" + "(" + mouseButton + "," + alternatePushReleaseButton + ") ");
        }
	}

	public void mouseEntered(MouseEvent e) {
		mouseButton = MouseEvent.NOBUTTON;
		alternatePushReleaseButton = 0;

        if (ControlRoom.MOUSE_INPUT_OUT == true) {
            System.out.println("- Mouse Entered");
        }
	}

	public void mouseExited(MouseEvent e) {
		mouseButton = MouseEvent.NOBUTTON;
		alternatePushReleaseButton = 0;

        if (ControlRoom.MOUSE_INPUT_OUT == true) {
            System.out.print("Mouse Exited ");
        }
	}
}