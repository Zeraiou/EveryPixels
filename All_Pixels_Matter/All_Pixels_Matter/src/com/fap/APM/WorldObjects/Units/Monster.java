package com.fap.APM.WorldObjects.Units;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Core.DrawManager;
import com.fap.APM.Helper;
import com.fap.APM.WorldObjects.WorldList;
import com.fap.APM.Graphics.AnimatedSprite;
import java.util.Random;

public class Monster {

    protected final Random RANDOM = new Random();
	private AnimatedSprite animationDown = new AnimatedSprite(WorldList.zombie_Base22_Down, 36, 48, 3);
	private AnimatedSprite animationRight = new AnimatedSprite(WorldList.zombie_Base22_Right, 36, 48, 3);
	private AnimatedSprite animationUp = new AnimatedSprite(WorldList.zombie_Base22_Up, 36, 48, 3);
	private AnimatedSprite animationLeft = new AnimatedSprite(WorldList.zombie_Base22_Left, 36, 48, 3);
	public AnimatedSprite sprite = animationDown;
    public double posX, posY, ticksAlive, movementSpeed;
    public boolean isRemoved = false;
    public boolean isMoving = false;

	public Monster(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.movementSpeed = 1.0;
		this.ticksAlive = 0;
	}

	public void nextTick() {
		double xDestination = 0;
		double yDestination = 0;
		
		ticksAlive++;
		
		if (ticksAlive % (RANDOM.nextInt(1) + 30) == 0) {
			int directionChoice = (RANDOM.nextInt(4));
			
			if (isMoving) {
				sprite.tickAnimation();
			} else {
			    sprite.setFrame(0);
            }

			if (directionChoice == 0) {
				sprite = animationDown;
				yDestination += movementSpeed ; 
			}
			
			if (directionChoice == 1) {
				sprite = animationRight;
				xDestination += movementSpeed ;
			}
			
			if (directionChoice == 2) {
				sprite = animationUp;
				yDestination -= movementSpeed ;
			}
			
			if (directionChoice == 3) {
				sprite = animationLeft;
				xDestination -= movementSpeed ;
			}
			
			if (RANDOM.nextInt(5) == 0) {
				xDestination = 0;
				yDestination = 0;
			}
			
			if (xDestination !=0 || yDestination !=0) {
				move(xDestination, yDestination);
				isMoving = true;
			} else {
				isMoving = false;
			}
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