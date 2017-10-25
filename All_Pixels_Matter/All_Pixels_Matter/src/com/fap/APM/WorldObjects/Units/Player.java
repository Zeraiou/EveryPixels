package com.fap.APM.WorldObjects.Units;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Core.DrawManager;
import com.fap.APM.Graphics.AnimatedSprite;
import com.fap.APM.Core.Input.Keyboard;
import com.fap.APM.Helper;
import com.fap.APM.WorldObjects.WorldList;

public class Player {

    private AnimatedSprite animationDown = new AnimatedSprite(WorldList.player_Base34_Down, 36, 48, 3);
    private AnimatedSprite animationRight = new AnimatedSprite(WorldList.player_Base34_Right, 36, 48, 3);
    private AnimatedSprite animationUp = new AnimatedSprite(WorldList.player_Base34_Up, 36, 48, 3);
    private AnimatedSprite animationLeft = new AnimatedSprite(WorldList.player_Base34_Left, 36, 48, 3);
    public AnimatedSprite sprite;

    public boolean isMoving = false;
    private boolean isAlive = true;
    private int pointExperience;
    private double healthPoints, maxHealthPoints, fireRate;
    private double movementSpeed;
    public double posX, posY;

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
	
	public void nextTick() {
		if (fireRate > 0) {
		    fireRate--;
        }
		
		if (isMoving){
			sprite.tickAnimation();
		} else {
			sprite.setFrame(0);
		}

		double xDestination = 0, yDestination = 0;

        if (Keyboard.shared().left) {
            xDestination -= movementSpeed;
            sprite = animationLeft;
        }

        if (Keyboard.shared().rigth) {
            xDestination += movementSpeed;
            sprite = animationRight;
        }

        if (Keyboard.shared().up) {
            yDestination -= movementSpeed;
            sprite = animationUp;
        }

        if (Keyboard.shared().down) {
            yDestination += movementSpeed;
            sprite = animationDown;
        }

		if (xDestination !=0 || yDestination !=0) {
			move(xDestination, yDestination);
			isMoving = true;
		} else {
			isMoving = false;
		}
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
        for (int c = 0; c < 4; c++) {
            double xTemp = ((posX + xAbsolu) - (c % 2)) / ControlRoom.TILE_WIDTH;
            double yTemp= ((posY + yAbsolu) - (c / 2)) / ControlRoom.TILE_HEIGHT;
            int xTempInt = (int) Math.ceil(xTemp);
            int yTempInt = (int) Math.ceil(yTemp);

            if (c % 2 == 0) xTempInt = (int) Math.floor(xTemp);
            if (c / 2 == 0) yTempInt = (int) Math.floor(yTemp);
            if (DrawManager.shared().getMapFieldTiles(xTempInt, yTempInt).solid()) {
                solid = true;
            }
        }
        return solid;
    }
}