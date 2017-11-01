package com.fap.APM.Graphics.Basics;
import com.fap.APM.Graphics.Sprites.Sprite;

public class Resource {
	
	public int posX, posY;
	public int width, height;
    public int phyType;
	public Sprite sprite;

	public Resource(Sprite sprite, int posX, int posY, int width, int height, int phyType) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.phyType = phyType;
		this.sprite = sprite;
	}

	public Resource(Sprite sprite, int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.phyType = 10;
		this.sprite = sprite;
	}

	public Sprite getSprite() {
		return sprite;
	}
}