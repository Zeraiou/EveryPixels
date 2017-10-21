package com.fap.APM.Units;

import java.util.Random;

import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Graphics.SpriteSheet.Sprite;
import com.fap.APM.World.Map;

public class Entity {
	
	protected double xEntity, yEntity;
	private boolean isRemoved = false;
	protected Map map;
	protected Sprite spriteEntity;
	
	protected final Random RANDOM = new Random(); 
	
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
	
	public void initialiseMap(Map map) {
		this.map = map;
			
	}
	
}