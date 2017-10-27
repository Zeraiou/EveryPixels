package com.fap.APM.Core.Input;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.WorldObjects.Units.Player;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private static Keyboard INSTANCE = null;
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static final String MOVE_UP = "move up";
    private static final String MOVE_DOWN = "move down";
    private static final String MOVE_LEFT = "move left";
    private static final String MOVE_RIGHT = "move right";
    private static final String FIRE = "fire";

    private Keyboard() { }

    public static Keyboard shared() {
        if (INSTANCE == null) {
            INSTANCE = new Keyboard();
        }
        return INSTANCE;
    }

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

    private class moveUp extends AbstractAction {
        public moveUp() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created: W");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush: W");
            }
            ControlRoom.PLAYER.walk(1);
        }
    }

    private class moveDown extends AbstractAction {
        public  moveDown() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created: S");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush: S");
            }
            ControlRoom.PLAYER.walk(2);
        }
    }

    private class moveLeft extends AbstractAction {
        public  moveLeft() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created: A");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush: A");
            }
            ControlRoom.PLAYER.walk(3);
        }
    }

    private class moveRight extends AbstractAction {
        public  moveRight() {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyMap Created: D");
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
                System.out.println("KeyPush: D");
            }
            ControlRoom.PLAYER.walk(4);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
            System.out.println("KeyReleased:(" + e.getKeyChar() + "," + e.getKeyCode() + "," + e.getExtendedKeyCode() + ") " + e.getID() + " " + e.getModifiers() + " " + e.getKeyLocation());
        }

        if (ControlRoom.PLAYER.move == true) {
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                if (ControlRoom.PLAYER.direction == Player.Direction.NORTH_WEST) {
                    ControlRoom.PLAYER.direction = Player.Direction.WEST;
                } else if (ControlRoom.PLAYER.direction == Player.Direction.NORTH_EAST) {
                    ControlRoom.PLAYER.direction = Player.Direction.EAST;
                } else if (ControlRoom.PLAYER.direction == Player.Direction.SOUTH || ControlRoom.PLAYER.direction == Player.Direction.SOUTH_WEST || ControlRoom.PLAYER.direction == Player.Direction.SOUTH_EAST) {
                } else {
                    ControlRoom.PLAYER.move = false;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (ControlRoom.PLAYER.direction == Player.Direction.SOUTH_WEST) {
                    ControlRoom.PLAYER.direction = Player.Direction.WEST;
                } else if (ControlRoom.PLAYER.direction == Player.Direction.SOUTH_EAST) {
                    ControlRoom.PLAYER.direction = Player.Direction.EAST;
                } else if (ControlRoom.PLAYER.direction == Player.Direction.NORTH || ControlRoom.PLAYER.direction == Player.Direction.NORTH_WEST || ControlRoom.PLAYER.direction == Player.Direction.NORTH_EAST) {
                } else {
                    ControlRoom.PLAYER.move = false;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (ControlRoom.PLAYER.direction == Player.Direction.NORTH_WEST) {
                    ControlRoom.PLAYER.direction = Player.Direction.NORTH;
                } else if (ControlRoom.PLAYER.direction == Player.Direction.SOUTH_WEST) {
                    ControlRoom.PLAYER.direction = Player.Direction.SOUTH;
                } else if (ControlRoom.PLAYER.direction == Player.Direction.EAST || ControlRoom.PLAYER.direction == Player.Direction.NORTH_EAST || ControlRoom.PLAYER.direction == Player.Direction.SOUTH_EAST) {
                } else {
                    ControlRoom.PLAYER.move = false;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (ControlRoom.PLAYER.direction == Player.Direction.NORTH_EAST) {
                    ControlRoom.PLAYER.direction = Player.Direction.NORTH;
                } else if (ControlRoom.PLAYER.direction == Player.Direction.SOUTH_EAST) {
                    ControlRoom.PLAYER.direction = Player.Direction.SOUTH;
                } else if (ControlRoom.PLAYER.direction == Player.Direction.WEST || ControlRoom.PLAYER.direction == Player.Direction.NORTH_WEST || ControlRoom.PLAYER.direction == Player.Direction.SOUTH_WEST) {
                } else {
                    ControlRoom.PLAYER.move = false;
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}