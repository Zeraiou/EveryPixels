package com.fap.APM.WorldObjects.Units;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Core.DrawManager;
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
    private Direction direction = Direction.SOUTH;
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
        move = true;

        switch (orientation) {
            case 1:
                this.direction = Direction.NORTH;
                break;
            case 2:
                this.direction = Direction.SOUTH;
                break;
            case 3:
                this.direction = Direction.WEST;
                break;
            case 4:
                this.direction = Direction.EAST;
                break;
        }
    }

	public void nextTick() {
	    if (move == true) {
            switch (direction) {
                case NORTH:
                    move(0,-movementSpeed);
                    sprite = animationUp;
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
            sprite = animationUp;
        }


//		if (isMoving){
//			sprite.tickAnimation();
//		} else {
//			sprite.setFrame(0);
//		}
//
//		double xDestination = 0, yDestination = 0;
//
//        if (Keyboard.shared().left) {
//            xDestination -= movementSpeed;
//            sprite = animationLeft;
//        }
//
//        if (Keyboard.shared().rigth) {
//            xDestination += movementSpeed;
//            sprite = animationRight;
//        }
//
//        if (Keyboard.shared().up) {
//            yDestination -= movementSpeed;
//            sprite = animationUp;
//        }
//
//        if (Keyboard.shared().down) {
//            yDestination += movementSpeed;
//            sprite = animationDown;
//        }
//
//		if (xDestination !=0 || yDestination !=0) {
//			move(xDestination, yDestination);
//			isMoving = true;
//		} else {
//			isMoving = false;
//		}
	}

    protected void move(double xDestination, double yDestination) {
        while (xDestination != 0) {
            if (Math.abs(xDestination) > 1) {
                if (!collisionCreatureTile(Helper.absolute(xDestination), yDestination)) {
                    this.posX += Helper.absolute(xDestination);
                }
                xDestination -= Helper.absolute(xDestination);
            }	else {
                if (!collisionCreatureTile(Helper.absolute(xDestination), yDestination)) {
                    this.posX += xDestination;
                }
                xDestination = 0;
            }
        }

        while (yDestination != 0) {
            if (Math.abs(yDestination) > 1) {
                if (!collisionCreatureTile(xDestination, Helper.absolute(yDestination))) {
                    this.posY += Helper.absolute(yDestination);
                }
                yDestination -= Helper.absolute(yDestination);
            }	else {
                if (!collisionCreatureTile(xDestination, Helper.absolute(yDestination))) {
                    this.posY += yDestination;
                }
                yDestination = 0;
            }
        }
    }

    private boolean collisionCreatureTile(double xAbsolu, double yAbsolu) {
        boolean solid = false;
//        for (int c = 0; c < 4; c++) {
//            double xTemp = ((posX + xAbsolu) - (c % 2)) / ControlRoom.TILE_WIDTH;
//            double yTemp= ((posY + yAbsolu) - (c / 2)) / ControlRoom.TILE_HEIGHT;
//            int xTempInt = (int) Math.ceil(xTemp);
//            int yTempInt = (int) Math.ceil(yTemp);
//
//            if (c % 2 == 0) xTempInt = (int) Math.floor(xTemp);
//            if (c / 2 == 0) yTempInt = (int) Math.floor(yTemp);
//            if (DrawManager.shared().getMapFieldTiles(xTempInt, yTempInt).solid()) {
//                solid = true;
//            }
//        }
        return solid;
    }
}