package com.fap.APM.Core.Input;
import com.fap.APM.Helpers.ControlRoom;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class InputManager {

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    public static List<Integer> movementKeys = new ArrayList<Integer>();

    public void loadInputActions(JFrame frame) {
        mapInputToAction(frame, "W", new moveUp(KeyEvent.VK_W));
        mapInputToAction(frame, "S", new moveDown(KeyEvent.VK_S));
        mapInputToAction(frame, "A", new moveLeft(KeyEvent.VK_A));
        mapInputToAction(frame, "D", new moveRight(KeyEvent.VK_D));

        mapInputToAction(frame, "UP", new moveUp(KeyEvent.VK_UP));
        mapInputToAction(frame, "DOWN", new moveDown(KeyEvent.VK_DOWN));
        mapInputToAction(frame, "LEFT", new moveLeft(KeyEvent.VK_LEFT));
        mapInputToAction(frame, "RIGHT", new moveRight(KeyEvent.VK_RIGHT));

        mapInputToAction(frame, "ESCAPE", new escape());
        mapInputToAction(frame, "SHIFT", new leftShift());
        mapInputToAction(frame, "CONTROL", new ctrl());
        mapInputToAction(frame, "ALT", new alt());
        mapInputToAction(frame, "TAB", new tab());
        mapInputToAction(frame, "CAPS_LOCK", new caps());
        mapInputToAction(frame, "SPACE", new space());
        mapInputToAction(frame, "ENTER", new enter());
        //mapInputToAction(frame, "`", new console());

        mapInputToAction(frame, "0", new fastItemSwitch(0));
        mapInputToAction(frame, "1", new fastItemSwitch(1));
        mapInputToAction(frame, "2", new fastItemSwitch(2));
        mapInputToAction(frame, "3", new fastItemSwitch(3));
        mapInputToAction(frame, "4", new fastItemSwitch(4));
        mapInputToAction(frame, "5", new fastItemSwitch(5));
        mapInputToAction(frame, "6", new fastItemSwitch(6));
        mapInputToAction(frame, "7", new fastItemSwitch(7));
        mapInputToAction(frame, "8", new fastItemSwitch(8));
        mapInputToAction(frame, "9", new fastItemSwitch(9));

        mapInputToAction(frame, "Q", new moveQ());
        mapInputToAction(frame, "E", new moveE());
        mapInputToAction(frame, "R", new moveR());
        mapInputToAction(frame, "F", new moveF());
        mapInputToAction(frame, "Z", new moveZ());
        mapInputToAction(frame, "X", new moveX());
        mapInputToAction(frame, "C", new moveC());
        mapInputToAction(frame, "V", new moveV());
    }

    private void mapInputToAction(JFrame frame, String keyName, AbstractAction action) {
        JLabel input = new JLabel();
        input.getInputMap(IFW).put(KeyStroke.getKeyStroke(keyName), keyName);
        input.getActionMap().put(keyName, action);
        frame.add(input);
    }

    private class moveUp extends AbstractAction {
        private int key;

        public moveUp(int key) {
            this.key = key;
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created: W");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:W " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
            ControlRoom.PLAYER.movement.setYDirection(-1);
            InputManager.addKeyIfNotInList(1);
        }
    }

    private class moveDown extends AbstractAction {
        private int key;

        public  moveDown(int key) {
            this.key = key;
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created: S");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:S " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
            ControlRoom.PLAYER.movement.setYDirection(1);
            InputManager.addKeyIfNotInList(2);
        }
    }

    private class moveLeft extends AbstractAction {
        private int key;

        public  moveLeft(int key) {
            this.key = key;
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created: A");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:A" + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
            ControlRoom.PLAYER.movement.setXDirection(-1);
            InputManager.addKeyIfNotInList(3);
        }
    }

    private class moveRight extends AbstractAction {
        private int key;

        public  moveRight(int key) {
            this.key = key;
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created: D");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:D " + System.currentTimeMillis() / 1000 + " " + e.getActionCommand());
            }
            ControlRoom.PLAYER.movement.setXDirection(1);
            InputManager.addKeyIfNotInList(4);
        }
    }

    private class escape extends AbstractAction {
        public  escape() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:ESCAPE");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:ESCAPE " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class leftShift extends AbstractAction {
        public  leftShift() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:LEFT_SHIFT");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:LEFT_SHIFT " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class ctrl extends AbstractAction {
        public  ctrl() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:CONTROL/CTRL");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:CONTROL/CTRL " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class alt extends AbstractAction {
        public  alt() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:ALT");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:ALT " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class tab extends AbstractAction {
        public  tab() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:TAB");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:TAB " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class caps extends AbstractAction {
        public  caps() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:CAPS_LOCK");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:CAPS_LOCK " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class space extends AbstractAction {
        public  space() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:SPACE BAR");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:SPACE BAR " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class enter extends AbstractAction {
        public  enter() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:ENTER");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:ENTER " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

//    private class console extends AbstractAction {
//        public  console() {
//            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
//                System.out.println("KeyMap Created:CONSOLE");
//            }
//        }
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
//                System.out.println("KeyPush:CONSOLE " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
//            }
//        }
//    }

    private class fastItemSwitch extends AbstractAction {
        private int number;

        public fastItemSwitch(int i) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created: " + i);
            }
            number = i;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush: " + number);
            }

        }
    }

    private class moveQ extends AbstractAction {
        public  moveQ() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:Q");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:Q " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class moveE extends AbstractAction {
        public  moveE() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:E");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:E " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class moveR extends AbstractAction {
        public  moveR() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:R");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:R " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class moveF extends AbstractAction {
        public  moveF() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:F");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:F " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class moveZ extends AbstractAction {
        public  moveZ() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:Z");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:Z " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class moveX extends AbstractAction {
        public  moveX() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:X");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:X " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }
    private class moveC extends AbstractAction {
        public  moveC() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:C");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:C " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    private class moveV extends AbstractAction {
        public  moveV() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created:V");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush:V " + System.currentTimeMillis()/1000 + " " + e.getActionCommand());
            }
        }
    }

    protected static void addKeyIfNotInList(Integer movementKey) {
        boolean exists = false;

        for (int i = 0; i < movementKeys.size(); i++) {
            if (movementKeys.get(i) == movementKey) {
                exists = true;
            }
        }
        if (exists == false) {
            movementKeys.add(movementKey);
        }
    }
}