package com.fap.APM.WorldObjects.Units;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Core.DrawManager;
import com.fap.APM.Helper;
import com.fap.APM.WorldObjects.WorldList;
import com.fap.APM.Graphics.AnimatedSprite;
import java.util.Random;

public class Monster {

    private AnimatedSprite animDown;
    private AnimatedSprite animUp;
    private AnimatedSprite animLeft;
    private AnimatedSprite animRight;

    protected final Random RANDOM = new Random();
	public AnimatedSprite sprite;
    public double posX, posY, ticksAlive, movementSpeed;
    public boolean isRemoved = false;
    public boolean isMoving = false;
    private int monsterType;

	public Monster(int posX, int posY, int type) {
		this.posX = posX;
		this.posY = posY;
		this.movementSpeed = 1.0;
		this.ticksAlive = 0;
		this.monsterType = type;

		if (monsterType == 1) {
            animDown = MonsterAnimations.animationDown;
            animUp = MonsterAnimations.animationUp;
            animLeft = MonsterAnimations.animationLeft;
            animRight = MonsterAnimations.animationRight;
        } else if (monsterType == 2) {
            animDown = MonsterAnimations.animationDownTwo;
            animUp = MonsterAnimations.animationUpTwo;
            animLeft = MonsterAnimations.animationLeftTwo;
            animRight = MonsterAnimations.animationRightTwo;
        }
        sprite = animDown;
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
				sprite = animDown;
				yDestination += movementSpeed ;
			}

			if (directionChoice == 1) {
				sprite = animRight;
				xDestination += movementSpeed ;
			}

			if (directionChoice == 2) {
				sprite = animUp;
				yDestination -= movementSpeed ;
			}

			if (directionChoice == 3) {
				sprite = animLeft;
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