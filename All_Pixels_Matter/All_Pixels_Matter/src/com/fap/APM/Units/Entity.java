package com.fap.APM.Units;
import java.util.Random;
import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Graphics.Sprite;

public class Entity {
	
	protected double xEntity, yEntity;
	protected Sprite spriteEntity;
	protected final Random RANDOM = new Random();
	private boolean isRemoved = false;

	public Entity() {

    }

	public Entity(int xPosition, int yPosition, Sprite sprite) {
		this.xEntity = xPosition;
		this.yEntity = yPosition;
		this.spriteEntity = sprite;
	}
	
	public void tickEntity(){

	}
	
	public void renderEntity(ScreenDisplay screen) {
	//	if (spriteEntity != null) screen.RenduSprite((int) xEntity, (int) yEntity, spriteEntity, true);
	}
	
	public void removeEntity() {
		isRemoved = true;
	}
	
	public Sprite getSpriteEntity() {
		return spriteEntity;
	}
	
	public double getXEntity() {
		return xEntity;
	}
	
	public double getYEntity() {
		return yEntity;
	}

	public boolean getIsRemoved() {
		return isRemoved;
	}
}