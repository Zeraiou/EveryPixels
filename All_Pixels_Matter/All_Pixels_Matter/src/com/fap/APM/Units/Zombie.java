package com.fap.APM.Units;
import com.fap.APM.Graphics.AnimatedSprite;
import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.World.WorldList;
import com.fap.APM.World.WorldMaker;

public class Zombie extends Creature {
	
	private int time = 0;
	
	private AnimatedSprite animationDown = new AnimatedSprite(WorldList.zombie_Base22_Down, 36, 48, 3);
	private AnimatedSprite animationRight = new AnimatedSprite(WorldList.zombie_Base22_Right, 36, 48, 3);
	private AnimatedSprite animationUp = new AnimatedSprite(WorldList.zombie_Base22_Up, 36, 48, 3);
	private AnimatedSprite animationLeft = new AnimatedSprite(WorldList.zombie_Base22_Left, 36, 48, 3);
	
	private AnimatedSprite currentAnimatedSprite = animationDown;

	
	
	public Zombie(int xStratingPoint, int yStratingPoint) {
		this.xEntity = xStratingPoint;
		this.yEntity = yStratingPoint;
		this.spriteEntity = WorldList.sprite_zombie_Base22;
		this.movementSpeed = 1.0;
	}

	public void tickEntity() {
		double xDestination = 0;
		double yDestination = 0;
		
		time++;
		
		if (time % (RANDOM.nextInt(1) + 30) == 0) {
			int directionChoice = (RANDOM.nextInt(4));
			
			if (isMoving) currentAnimatedSprite.tickAnimation();
			else currentAnimatedSprite.setFrame(0);
			
			
			if (directionChoice == 0) {
				currentAnimatedSprite = animationDown;
				yDestination += movementSpeed ; 
			}
			
			if (directionChoice == 1) {
				currentAnimatedSprite = animationRight;
				xDestination += movementSpeed ;
			}
			
			if (directionChoice == 2) {
				currentAnimatedSprite = animationUp;
				yDestination -= movementSpeed ;
			}
			
			if (directionChoice == 3) {
				currentAnimatedSprite = animationLeft;
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

	public void renderEntity(ScreenDisplay screen) {
	
		//System.out.println("x : " + xEntity + " y : " + yEntity);
		spriteEntity = currentAnimatedSprite.getSprite();
		screen.renderCreature((int)(xEntity - 0), (int)(yEntity - 0), spriteEntity);
	}
}
