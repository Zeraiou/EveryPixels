package com.fap.APM.Units;

import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Graphics.SpriteSheet.Sprite;
import com.fap.APM.Input.Keyboard;

public class Player extends Creature{
	
	private Keyboard key;
	public Sprite spritePlayer;
	public boolean isMoving;
	private double movementSpeed = 1.0;
	
	public int fireRate = 0;
	
	public Player(int xEntity, int yEntity, Keyboard key) {
		this.xEntity = xEntity;
		this.yEntity = yEntity;
		this.key = key;
		spritePlayer = Sprite.Player_Base_Down;
		fireRate = 5;
		this.pointHealt = 100;
		this.pointHealtMaximum = 100.0;
		this.pointHealtPercentage = pointHealt / pointHealtMaximum;
		this.pointMagic = 100;
		this.pointMagicMaximum = 100.0;
		this.pointMagicPercentage = pointMagic / pointMagicMaximum;
		this.pointExperience = 0;
		this.pointExperienceMaximum = 100.0;
		this.pointExperiencePercentage = pointExperience / pointExperienceMaximum;
		
	}
	
	public void tickEntity() {
		if (fireRate > 0) fireRate--;
		

		double xDestination = 0, yDestination = 0;
		if (key.up) {
			yDestination -= movementSpeed; 
			spritePlayer = Sprite.Player_Base_Up;
		}
		
		if (key.rigth) {
			xDestination += movementSpeed; 
			spritePlayer = Sprite.Player_Base_Right;
		}
		
		if (key.down) {
			yDestination += movementSpeed; 
			spritePlayer = Sprite.Player_Base_Down;
		}
		
		if (key.left) {
			xDestination -= movementSpeed; 	
			spritePlayer = Sprite.Player_Base_Left;
		}
		
		if (xDestination !=0 || yDestination !=0) {
			move(xDestination, yDestination);
			isMoving = true;
		} else {
			isMoving = false;
		}
		
		
	}
	
	public void renderEntity(ScreenDisplay screen) {
		
		
	}
	
}
