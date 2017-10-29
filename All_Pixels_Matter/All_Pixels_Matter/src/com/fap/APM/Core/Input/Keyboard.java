package com.fap.APM.Core.Input;
import com.fap.APM.ControlRoom;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    public InputManager inputManager;
    private static Keyboard INSTANCE = null;

    private Keyboard() {
        inputManager = new InputManager();
    }

    public static Keyboard shared() {
        if (INSTANCE == null) {
            INSTANCE = new Keyboard();
        }
        return INSTANCE;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
            System.out.println("KeyReleased:(" + e.getKeyChar() + "," + e.getKeyCode() + "," + e.getExtendedKeyCode() + ") " + e.getID() + " " + e.getModifiers() + " " + e.getKeyLocation());
        }

        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT ) {
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        }
    }
}