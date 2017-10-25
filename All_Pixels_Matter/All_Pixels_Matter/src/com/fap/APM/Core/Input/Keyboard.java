package com.fap.APM.Core.Input;
import com.fap.APM.Core.ControlRoom;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private static Keyboard INSTANCE = null;
    private boolean[] keys = new boolean[199];
    public boolean up, rigth, down, left, potionLife, potionMagic, potionExperience, damage;

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
        damage = keys[KeyEvent.VK_T];
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
            System.out.println("\nKeyPressed:(" + e.getKeyChar() + "," + e.getKeyCode() + "," + e.getExtendedKeyCode() + ") " + e.getID() + " "+ e.getModifiers() + " " + e.getKeyLocation());
        }
    }

    public void keyTyped(KeyEvent e) {
        if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
            System.out.println("KeyTyped:(" + e.getKeyChar() + "," + e.getKeyCode() + "," + e.getExtendedKeyCode() + ") " + e.getID() + " "+ e.getModifiers() + " " + e.getKeyLocation());
        }
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
            System.out.println("KeyReleased:(" + e.getKeyChar() + "," + e.getKeyCode() + "," + e.getExtendedKeyCode() + ") " + e.getID() + " " + e.getModifiers() + " " + e.getKeyLocation());
        }
    }
}

// Missing Tab Button
// 27 == ESC
// 192 == ` (Console)
// 16 == LShift/RShift
// 157 == Command
// 117 == Control
// 18 == Option
// 32 == Space
// 81 ==
// 10 == Enter
// 8 == BackSpace
// 81 == Q, 87 == W, 69 == E, 82 == R, 84 == T
// 65 == A, 83 == S, 68 == D, 70 == F, 71 == G
// 90 == Z, 88 == X, 67 == C, 86 == V, 66 == B
// 48 == 0 ... 57 == 9