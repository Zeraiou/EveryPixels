package com.fap.APM.WorldObjects.Units;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Graphics.AnimatedSprite;
import com.fap.APM.Helper;
import com.fap.APM.WorldObjects.WorldList;

public class Player {

    public enum Direction {
        NORTH, SOUTH, WEST, EAST, NORTH_WEST, NORTH_EAST, SOUTH_WEST, SOUTH_EAST;
    }
    private AnimatedSprite animationDown = new AnimatedSprite(WorldList.player_Base34_Down, 36, 48, 3);
    private AnimatedSprite animationRight = new AnimatedSprite(WorldList.player_Base34_Right, 36, 48, 3);
    private AnimatedSprite animationUp = new AnimatedSprite(WorldList.player_Base34_Up, 36, 48, 3);
    private AnimatedSprite animationLeft = new AnimatedSprite(WorldList.player_Base34_Left, 36, 48, 3);
    public AnimatedSprite sprite;
    private double healthPoints, maxHealthPoints, fireRate, pointExperience;
    private boolean isAlive = true;
    public Direction direction = Direction.SOUTH;
    public double posX, posY, movementSpeed;
    public boolean move = false;
    public boolean shiftDown = false;

	public Player() {
        sprite = animationDown;
        posX = ControlRoom.STARTING_X;
        posY = ControlRoom.STARTING_Y;
        healthPoints = ControlRoom.HEALTH_POINTS;
        maxHealthPoints = ControlRoom.MAX_HEALTH_POINTS;
        movementSpeed = ControlRoom.MOVEMENT_SPEED;
        pointExperience = ControlRoom.EXP_POINTS;
        fireRate = ControlRoom.FIRE_RATE;
    }

    public void walk(int orientation) {

        switch (orientation) {
            case 1: // North
                System.out.println("Called Walk Direction: NORTH");
                if ((direction == Direction.WEST || direction == Direction.NORTH_WEST) && move == true) {
                    direction = Direction.NORTH_WEST;
                } else if ((direction == Direction.EAST || direction == Direction.NORTH_EAST) && move == true) {
                    direction = Direction.NORTH_EAST;
                } else if ((direction == Direction.SOUTH || direction == Direction.SOUTH_WEST || direction == Direction.SOUTH_EAST) && move == true) {
                } else {
                    direction = Direction.NORTH;
                }
                break;
            case 2: // South
                System.out.println("Called Walk Direction: SOUTH");
                if ((direction == Direction.WEST || direction == Direction.SOUTH_WEST) && move == true) {
                    direction = Direction.SOUTH_WEST;
                } else if ((direction == Direction.EAST || direction == Direction.SOUTH_EAST) && move == true) {
                    direction = Direction.SOUTH_EAST;
                } else if ((direction == Direction.NORTH || direction == Direction.NORTH_WEST || direction == Direction.NORTH_EAST) && move == true) {
                } else {
                    direction = Direction.SOUTH;
                }
                break;
            case 3: // West
                System.out.println("Called Walk Direction: WEST");
                if ((direction == Direction.NORTH || direction == Direction.NORTH_WEST) && move == true) {
                    direction = Direction.NORTH_WEST;
                } else if ((direction == Direction.SOUTH || direction == Direction.SOUTH_WEST) && move == true) {
                    direction = Direction.SOUTH_WEST;
                } else if ((direction == Direction.EAST || direction == Direction.NORTH_WEST || direction == Direction.NORTH_EAST) && move == true) {
                } else {
                    direction = Direction.WEST;
                }
                break;
            case 4: // East
                System.out.println("Called Walk Direction: EAST");
                if ((direction == Direction.NORTH || direction == Direction.NORTH_EAST) && move == true) {
                    direction = Direction.NORTH_EAST;
                } else if ((direction == Direction.SOUTH || direction == Direction.SOUTH_EAST) && move == true) {
                    direction = Direction.SOUTH_EAST;
                } else if ((direction == Direction.WEST || direction == Direction.NORTH_WEST || direction == Direction.SOUTH_WEST) && move == true) {
                } else {
                    direction = Direction.EAST;
                }
                break;
        }
        move = true;
        System.out.println("After Walk Direction: " + direction);
    }

	public void nextTick() {
	    if (move == true) {

            System.out.println("Next Tick Direction: " + direction);
	        switch (direction) {
                case NORTH_WEST:
                    move(-movementSpeed,-movementSpeed);
                    sprite = animationLeft;
                    break;
                case NORTH_EAST:
                    move(movementSpeed,-movementSpeed);
                    sprite = animationRight;
                    break;
                case NORTH:
                    move(0,-movementSpeed);
                    sprite = animationUp;
                    break;
                case SOUTH_WEST:
                    move(-movementSpeed,movementSpeed);
                    sprite = animationLeft;
                    break;
                case SOUTH_EAST:
                    move(movementSpeed,movementSpeed);
                    sprite = animationRight;
                    break;
                case SOUTH:
                    move(0,movementSpeed);
                    sprite = animationDown;
                    break;
                case WEST:
                    move(-movementSpeed,0);
                    sprite = animationLeft;
                    break;
                case EAST:
                    move(movementSpeed,0);
                    sprite = animationRight;
                    break;
            }
            sprite.tickAnimation();
        }
	}

    protected void move(double moveX, double moveY) {
	    posX += moveX;
	    posY += moveY;
    }
}