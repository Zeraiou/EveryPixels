package com.fap.APM.Units;

import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Graphics.SpriteSheet.Sprite;

public class Zombie extends Creature {

	
	
	private int time = 0;
	
	public Zombie(int xStratingPoint, int yStratingPoint) {
		this.xEntity = xStratingPoint;
		this.yEntity = yStratingPoint;
		spriteEntity = Sprite.zombie_Base_Down22;
		this.movementSpeed = 1.0;
	
	}
	
	
	public void tickEntity() {
		double xDestination = 0;
		double yDestination = 0;
		
		time++;
		
		if (time % (RANDOM.nextInt(1) + 30) == 0) {
			System.out.println("ici");
			int directionChoice = (RANDOM.nextInt(3));
			
			if (directionChoice == 0) {
				System.out.println("ici2");
				spriteEntity = Sprite.zombie_Base_Down22;
				direction = Direction.DOWN;
				yDestination += movementSpeed * 12; 
				System.out.println(yDestination);

				
			}
			
			if (directionChoice == 1) {
				spriteEntity = Sprite.zombie_Base_Right22;
				xDestination += movementSpeed * 12; 
				
			}
			
			if (directionChoice == 2) {
				spriteEntity = Sprite.zombie_Base_Up22;
				direction = Direction.UP;
				yDestination -= movementSpeed * 12; 

				
			}
			
			if (directionChoice == 3) {
				spriteEntity = Sprite.zombie_Base_Left22;
				yDestination -= movementSpeed * 12; 
				
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
		int xPrecision = 0;
		int yPrecision = 0;
		
		//System.out.println("x : " + xEntity + " y : " + yEntity);
		
		screen.renderCreature((int)(xEntity - xPrecision), (int)(yEntity - yPrecision), spriteEntity);
	}

}
