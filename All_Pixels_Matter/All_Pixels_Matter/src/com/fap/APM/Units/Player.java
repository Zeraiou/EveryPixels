package com.fap.APM.Units;
import com.fap.APM.Graphics.AnimatedSprite;
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
	
	private AnimatedSprite animationDown = new AnimatedSprite(WorldList.player_Base34_Down, 36, 48, 3);
	private AnimatedSprite animationRight = new AnimatedSprite(WorldList.player_Base34_Right, 36, 48, 3);
	private AnimatedSprite animationUp = new AnimatedSprite(WorldList.player_Base34_Up, 36, 48, 3);
	private AnimatedSprite animationLeft = new AnimatedSprite(WorldList.player_Base34_Left, 36, 48, 3);
	
	private AnimatedSprite currentAnimatedSprite = animationDown;

	
	public Player(int xEntity, int yEntity, Keyboard key) {
		this.xEntity = xEntity;
		this.yEntity = yEntity;
		this.keyboard = key;
		this.spritePlayer = WorldList.sprite_Player_Base34;
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
		
		if (isMoving) currentAnimatedSprite.tickAnimation();
		else currentAnimatedSprite.setFrame(0);
		
		
		double xDestination = 0, yDestination = 0;
		if (keyboard.up) {
			yDestination -= movementSpeed;
			currentAnimatedSprite = animationUp;
		}
		
		if (keyboard.rigth) {
			xDestination += movementSpeed;
			currentAnimatedSprite = animationRight;
		}
		
		if (keyboard.down) {
			yDestination += movementSpeed;
			currentAnimatedSprite = animationDown;
		}
		
		if (keyboard.left) {
			xDestination -= movementSpeed;
			currentAnimatedSprite = animationLeft;
		}
		
		if (xDestination !=0 || yDestination !=0) {
			move(xDestination, yDestination);
			isMoving = true;
		} else {
			isMoving = false;
		}
	}
	
	public void renderEntity(ScreenDisplay screen) {
		int xPrecisionPlayer = 0;
		int yPrecisionPlayer = 0;
		
		
		spritePlayer = currentAnimatedSprite.getSprite();
		screen.renderCreature((int)(xEntity - xPrecisionPlayer), (int)(yEntity - yPrecisionPlayer), spritePlayer);
	}
}