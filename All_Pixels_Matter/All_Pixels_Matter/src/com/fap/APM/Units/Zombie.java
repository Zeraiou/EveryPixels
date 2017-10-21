package com.fap.APM.Units;
import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.World.WorldMaker;

public class Zombie extends Creature {
	
	private int time = 0;
	
	public Zombie(int xStratingPoint, int yStratingPoint) {
		this.xEntity = xStratingPoint;
		this.yEntity = yStratingPoint;
		this.spriteEntity = WorldMaker.zombie_Base_Down22;
		this.movementSpeed = 1.0;
	}

	public void tickEntity() {
		double xDestination = 0;
		double yDestination = 0;
		
		time++;
		
		if (time % (RANDOM.nextInt(1) + 30) == 0) {
//			System.out.println("ici");
			int directionChoice = (RANDOM.nextInt(3));
			
			if (directionChoice == 0) {
//				System.out.println("ici2");
				spriteEntity = WorldMaker.zombie_Base_Down22;
				yDestination += movementSpeed * 12; 
//				System.out.println(yDestination);
			}
			
			if (directionChoice == 1) {
				spriteEntity = WorldMaker.zombie_Base_Right22;
				xDestination += movementSpeed * 12;
			}
			
			if (directionChoice == 2) {
				spriteEntity = WorldMaker.zombie_Base_Up22;
				yDestination -= movementSpeed * 12;
			}
			
			if (directionChoice == 3) {
				spriteEntity = WorldMaker.zombie_Base_Left22;
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
		//System.out.println("x : " + xEntity + " y : " + yEntity);
		screen.renderCreature((int)(xEntity - 0), (int)(yEntity - 0), spriteEntity);
	}
}
