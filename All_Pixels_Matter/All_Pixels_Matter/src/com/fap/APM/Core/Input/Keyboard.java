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
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            inputManager.addKeyIfNotInList(1);
        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            inputManager.addKeyIfNotInList(2);
        } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            inputManager.addKeyIfNotInList(3);
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            inputManager.addKeyIfNotInList(4);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (ControlRoom.KEYBOARD_INPUT_OUT == true) {
            System.out.println("KeyReleased:(" + e.getKeyChar() + "," + e.getKeyCode() + "," + e.getExtendedKeyCode() + ") " + e.getID() + " " + e.getModifiers() + " " + e.getKeyLocation());
        }

        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            removeMovementKey(1);
            if (ControlRoom.PLAYER.movement.getYDirectionalVec() == -1) {
                ControlRoom.PLAYER.movement.stop();
                setNewDirectionsIfKeysPressed();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            removeMovementKey(2);
            if (ControlRoom.PLAYER.movement.getYDirectionalVec() == 1) {
                ControlRoom.PLAYER.movement.stop();
                setNewDirectionsIfKeysPressed();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            removeMovementKey(3);
            if (ControlRoom.PLAYER.movement.getXDirectionalVec() == -1) {
                ControlRoom.PLAYER.movement.stop();
                setNewDirectionsIfKeysPressed();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            removeMovementKey(4);
            if (ControlRoom.PLAYER.movement.getXDirectionalVec() == 1) {
                ControlRoom.PLAYER.movement.stop();
                setNewDirectionsIfKeysPressed();
            }
        }
    }

    private void removeMovementKey(Integer movementKey) {
        for (int i = 0; i < InputManager.movementKeys.size(); i++) {
            if (InputManager.movementKeys.get(i) == movementKey) {
                InputManager.movementKeys.remove(i);
            }
        }
    }

    private void setNewDirectionsIfKeysPressed() {
        if (InputManager.movementKeys.size() != 0) {
            if (InputManager.movementKeys.size() == 1) {
                setDirectionForKey(0, InputManager.movementKeys.get(0));
            } else {
                int firstKeyIndex = InputManager.movementKeys.size() - 1;
                int secondKeyIndex = InputManager.movementKeys.size() - 2;
                int firstKeyValue = InputManager.movementKeys.get(firstKeyIndex);
                int secondKeyValue = InputManager.movementKeys.get(secondKeyIndex);

                if ((firstKeyValue <= 2 && secondKeyValue > 2) || (firstKeyValue > 2 && secondKeyValue <= 2)) {
                    setDirectionForKey(firstKeyIndex, firstKeyValue);
                    setDirectionForKey(secondKeyIndex, secondKeyValue);
                }
            }
        }
    }

    private void setDirectionForKey(int index, Integer direction) {
        if (direction == 1) {
            ControlRoom.PLAYER.movement.setYDirection(-1);
        } else if (direction == 2) {
            ControlRoom.PLAYER.movement.setYDirection(1);
        } else if (direction == 3) {
            ControlRoom.PLAYER.movement.setXDirection(-1);
        } else {
            ControlRoom.PLAYER.movement.setXDirection(1);
        }
    }
}