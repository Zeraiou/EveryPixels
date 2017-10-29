package com.fap.APM.WorldObjects.Units;
import com.fap.APM.ControlRoom;
import com.fap.APM.Core.DrawManager;
import com.fap.APM.Helpers.Helper;
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
    private int monsterType, level, status, orientation;

	public Monster(int posX, int posY, int orientation, int type, int level, int status) {
		this.posX = posX;
		this.posY = posY;
		this.monsterType = type;
		this.level = level;
		this.status = status;
		this.orientation = orientation;
		this.movementSpeed = 1.0;
		this.ticksAlive = 0;

		if (monsterType == 1) {
            animDown = MonsterAnimations.animationDown_Zombie;
            animUp = MonsterAnimations.animationUp_Zombie;
            animLeft = MonsterAnimations.animationLeft_Zombie;
            animRight = MonsterAnimations.animationRight_Zombie;
        } else if (monsterType == 2) {
            animDown = MonsterAnimations.animationDown_Espirito;
            animUp = MonsterAnimations.animationUp_Espirito;
            animLeft = MonsterAnimations.animationLeft_Espirito;
            animRight = MonsterAnimations.animationRight_Espirito;
        }  else if (monsterType == 3) {
            animDown = MonsterAnimations.animationDown_Larvion;
            animUp = MonsterAnimations.animationUp_Larvion;
            animLeft = MonsterAnimations.animationLeft_Larvion;
            animRight = MonsterAnimations.animationRight_Larvion;
        
        }  else if (monsterType == 4) {
        	animDown = MonsterAnimations.animationDown_Bichette;
        	animUp = MonsterAnimations.animationUp_Bichette;
        	animLeft = MonsterAnimations.animationLeft_Bichette;
        	animRight = MonsterAnimations.animationRight_Bichette;
        }
		
		if (orientation == 1) {
			sprite = animUp;
		} else if (orientation == 2) {
			sprite = animDown;
		} else if (orientation == 3) {
			sprite = animRight;
		} else if (orientation == 4) {
			sprite = animLeft;
		}
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
				yDestination += movementSpeed * 12;
			}

			if (directionChoice == 1) {
				sprite = animRight;
				xDestination += movementSpeed * 12;
			}

			if (directionChoice == 2) {
				sprite = animUp;
				yDestination -= movementSpeed * 12;
			}

			if (directionChoice == 3) {
				sprite = animLeft;
				xDestination -= movementSpeed * 12;
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