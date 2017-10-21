package com.fap.APM.Units;

import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Graphics.SpriteSheet.Sprite;
import com.fap.APM.Input.Keyboard;

public class Player extends Creature{
	
	private Keyboard keyboard;
	public Sprite spritePlayer;
	public boolean isMoving;
	private double movementSpeed = 2.5;
	
	public int fireRate = 0;
	
	public Player(int xEntity, int yEntity, Keyboard key) {
		this.xEntity = xEntity;
		this.yEntity = yEntity;
		this.keyboard = key;
		
		
		//spritePlayer = Sprite.Player_Base_Down23;
		spritePlayer = Sprite.Player_Base_Down34;
		//spritePlayer = Sprite.Player_Base_Down46;
		
		
		
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
		if (keyboard.up) {
			yDestination -= movementSpeed; 
			
			//spritePlayer = Sprite.Player_Base_Up23;
			spritePlayer = Sprite.Player_Base_Up34;
			//spritePlayer = Sprite.Player_Base_Up46;
		}
		
		if (keyboard.rigth) {
			xDestination += movementSpeed; 
			
			//spritePlayer = Sprite.Player_Base_Right23;
			spritePlayer = Sprite.Player_Base_Right34;
			//spritePlayer = Sprite.Player_Base_Right46;
		}
		
		if (keyboard.down) {
			yDestination += movementSpeed; 
			
			//spritePlayer = Sprite.Player_Base_Down23;
			spritePlayer = Sprite.Player_Base_Down34;
			//spritePlayer = Sprite.Player_Base_Down46;
		}
		
		if (keyboard.left) {
			xDestination -= movementSpeed; 	
			
			//spritePlayer = Sprite.Player_Base_Left23;
			spritePlayer = Sprite.Player_Base_Left34;
			//spritePlayer = Sprite.Player_Base_Left46;
		}
		
		if (xDestination !=0 || yDestination !=0) {
			move(xDestination, yDestination);
			isMoving = true;
		} else {
			isMoving = false;
		}
		
		
	}
	
	public void renderEntity(ScreenDisplay screen) {
		int xRenderOffset = 0;
		int yRenderOffset = 0;
				
		screen.renderCreature((int)(xEntity - xRenderOffset), (int)(yEntity - yRenderOffset), spritePlayer);
		
		
	}
	
}
