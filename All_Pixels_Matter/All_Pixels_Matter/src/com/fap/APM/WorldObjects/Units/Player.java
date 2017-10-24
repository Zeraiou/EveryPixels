package com.fap.APM.WorldObjects.Units;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Core.DrawManager;
import com.fap.APM.Graphics.AnimatedSprite;
import com.fap.APM.Core.Input.Keyboard;
import com.fap.APM.WorldObjects.WorldList;

public class Player {

    private AnimatedSprite animationDown = new AnimatedSprite(WorldList.player_Base34_Down, 36, 48, 3);
    private AnimatedSprite animationRight = new AnimatedSprite(WorldList.player_Base34_Right, 36, 48, 3);
    private AnimatedSprite animationUp = new AnimatedSprite(WorldList.player_Base34_Up, 36, 48, 3);
    private AnimatedSprite animationLeft = new AnimatedSprite(WorldList.player_Base34_Left, 36, 48, 3);
    public AnimatedSprite sprite;

    public boolean isMoving = false;
    private boolean isAlive = true;
    private Keyboard keyboard;
    private int healthPoints, pointMagic, pointExperience;
    private double pointHealtMaximum, pointMagicMaximum, pointExperienceMaximum, fireRate;
    private double pointHealtPercentage, pointMagicPercentage, pointExperiencePercentage;
    private double movementSpeed;
    public double posX, posY;

	public Player(int posX, int posY, Keyboard key) {
		this.posX = posX;
		this.posY = posY;
		this.keyboard = key;
		this.fireRate = 5.0;
        this.movementSpeed  = 2.5;
		this.healthPoints = 100;
		this.pointHealtMaximum = 100.0;
		this.pointHealtPercentage = healthPoints / pointHealtMaximum;
		this.pointMagic = 100;
		this.pointMagicMaximum = 100.0;
		this.pointMagicPercentage = pointMagic / pointMagicMaximum;
		this.pointExperience = 0;
		this.pointExperienceMaximum = 100.0;
		this.pointExperiencePercentage = pointExperience / pointExperienceMaximum;

		sprite = animationDown;
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

        if (keyboard.left) {
            xDestination -= movementSpeed;
            sprite = animationLeft;
        } else if (keyboard.rigth) {
            xDestination += movementSpeed;
            sprite = animationRight;
        } else if (keyboard.up) {
            yDestination -= movementSpeed;
            sprite = animationUp;
        } else if (keyboard.down) {
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
                if (!collisionCreatureTile(absolute(xDestination), yDestination)) {
                    this.posX += absolute(xDestination);
                }
                xDestination -= absolute(xDestination);
            }	else {
                if (!collisionCreatureTile(absolute(xDestination), yDestination)) {
                    this.posX += xDestination;
                }
                xDestination = 0;
            }
        }

        while (yDestination != 0) {
            if (Math.abs(yDestination) > 1) {
                if (!collisionCreatureTile(xDestination, absolute(yDestination))) {
                    this.posY += absolute(yDestination);
                }
                yDestination -= absolute(yDestination);
            }	else {
                if (!collisionCreatureTile(xDestination, absolute(yDestination))) {
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

    private int absolute(double value) {
        if (value < 0) return -1;
        return 1;
    }
}