package com.fap.APM.WorldObjects.Units;
import com.fap.APM.Graphics.Sprite;
import java.util.Random;

public class Entity {
	
	public double xEntity, yEntity;
	public Sprite spriteEntity;
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

	public void removeEntity() {
		isRemoved = true;
	}

	public boolean getIsRemoved() {
		return isRemoved;
	}
}