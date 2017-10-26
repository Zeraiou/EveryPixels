package com.fap.APM.Core.Input;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.WorldObjects.WorldList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    //private static Keyboard INSTANCE = null;
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static final String MOVE_UP = "move up";
    private static final String MOVE_DOWN = "move down";
    private static final String MOVE_LEFT = "move left";
    private static final String MOVE_RIGHT = "move right";
    private static final String FIRE = "fire";
    private JLabel keyMapper;

    //private Keyboard() { }

//    public static Keyboard shared() {
//        if (INSTANCE == null) {
//            INSTANCE = new Keyboard();
//        }
//        return INSTANCE;
//    }

    public void loadInputActions(JFrame frame) {
        JLabel tempW = new JLabel();
        tempW.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), MOVE_UP);
        tempW.getActionMap().put(MOVE_UP, new moveUp());
        frame.add(tempW);

        JLabel tempS = new JLabel();
        tempS.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), MOVE_DOWN);
        tempS.getActionMap().put(MOVE_DOWN, new moveDown());
        frame.add(tempS);

        JLabel tempA = new JLabel();
        tempA.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), MOVE_LEFT);
        tempA.getActionMap().put(MOVE_LEFT, new moveLeft());
        frame.add(tempA);

        JLabel tempD = new JLabel();
        tempD.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), MOVE_RIGHT);
        tempD.getActionMap().put(MOVE_RIGHT, new moveRight());
        frame.add(tempD);
    }

    private void mapKeys() {
//        map("W", MOVE_UP, new moveUp());
//        map("S", MOVE_DOWN, new moveDown());
//        map("A", MOVE_LEFT, new moveLeft());
//        map("D", MOVE_RIGHT, new moveRight());

        keyMapper.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), MOVE_UP);
        keyMapper.getActionMap().put(MOVE_UP, new moveUp());
        keyMapper.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), MOVE_DOWN);
        keyMapper.getActionMap().put(MOVE_DOWN, new moveDown());
        keyMapper.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), MOVE_LEFT);
        keyMapper.getActionMap().put(MOVE_LEFT, new moveLeft());
        keyMapper.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), MOVE_RIGHT);
        keyMapper.getActionMap().put(MOVE_RIGHT, new moveRight());
    }

    private void map(String keyName, String actionName, AbstractAction action) {
        keyMapper.getInputMap(IFW).put(KeyStroke.getKeyStroke(keyName), actionName);
        keyMapper.getActionMap().put(actionName, action);
    }

    private class moveUp extends AbstractAction {
        public moveUp() {
            System.out.println("KeyMap Created: W");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("KeyPush: W - NORTH");
            WorldList.players.get(0).walk(1);
        }
    }

    private class moveDown extends AbstractAction {
        public  moveDown() {
            System.out.println("KeyMap Created: S");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("KeyPush: S - SOUTH");
            WorldList.players.get(0).walk(2);
        }
    }

    private class moveLeft extends AbstractAction {
        public  moveLeft() {
            System.out.println("KeyMap Created: A");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("KeyPush: W - WEST");
            WorldList.players.get(0).walk(3);
        }
    }

    private class moveRight extends AbstractAction {
        public  moveRight() {
            System.out.println("KeyMap Created: D");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("KeyPush: E - EAST");
            WorldList.players.get(0).walk(4);
        }
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
        WorldList.players.get(0).move = false;
    }
}