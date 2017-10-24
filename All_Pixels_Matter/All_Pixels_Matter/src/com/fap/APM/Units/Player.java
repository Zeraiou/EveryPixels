package com.fap.APM.Units;
import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Graphics.Sprite;
import com.fap.APM.Input.Keyboard;
import com.fap.APM.World.WorldList;
import com.fap.APM.World.WorldMaker;

public class Player extends Creature {
	
	private Keyboard keyboard;
	public Sprite spritePlayer;
	public boolean isMoving;
	public int fireRate = 0;
	
	public Player(int xEntity, int yEntity, Keyboard key) {
		this.xEntity = xEntity;
		this.yEntity = yEntity;
		this.keyboard = key;
		this.spritePlayer = WorldList.player_Base_Down34;
		this.fireRate = 5;
		this.pointHealt = 100;
		this.pointHealtMaximum = 100.0;
		this.pointHealtPercentage = pointHealt / pointHealtMaximum;
		this.pointMagic = 100;
		this.pointMagicMaximum = 100.0;
		this.pointMagicPercentage = pointMagic / pointMagicMaximum;
		this.pointExperience = 0;
		this.pointExperienceMaximum = 100.0;
		this.pointExperiencePercentage = pointExperience / pointExperienceMaximum;
		this.movementSpeed  = 2.5;
	}
	
	public void tickEntity() {
		if (fireRate > 0) fireRate--;

		double xDestination = 0, yDestination = 0;
		if (keyboard.up) {
			yDestination -= movementSpeed;
			spritePlayer = WorldList.player_Base_Up34;
		}
		
		if (keyboard.rigth) {
			xDestination += movementSpeed;
			spritePlayer = WorldList.player_Base_Right34;
		}
		
		if (keyboard.down) {
			yDestination += movementSpeed;
			spritePlayer = WorldList.player_Base_Down34;
		}
		
		if (keyboard.left) {
			xDestination -= movementSpeed;
			spritePlayer = WorldList.player_Base_Left34;
		}
		
		if (xDestination !=0 || yDestination !=0) {
			move(xDestination, yDestination);
			isMoving = true;
		} else {
			isMoving = false;
		}
	}
	
	public void renderEntity(ScreenDisplay screen) {
		//System.out.println("x : " + xEntity + " y : " + yEntity);
		screen.renderCreature((int)(xEntity - 0), (int)(yEntity - 0), spritePlayer);
	}
}