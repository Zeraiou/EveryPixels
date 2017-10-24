package com.fap.APM.Graphics;

public class Sprite {
	
	public int x, y, totalPx;
	public int width, height;
	public int[] pixelsSprite;
	protected SpriteSheet spriteSheet;
	
	public Sprite(SpriteSheet spriteSheet, int widthSprite, int heightSprite) {
		this.width = widthSprite;
		this.height = heightSprite;
		this.spriteSheet = spriteSheet;
		this.totalPx = this.width * this.height;
		this.pixelsSprite = new int[totalPx];
		
	}
	
	public Sprite(int width, int height, int x, int y, SpriteSheet spriteSheet) {
		this.width = width;
		this.height = height;
		this.totalPx = this.width * this.height;
		this.pixelsSprite = new int[totalPx];
		this.x = x * this.width;
		this.y = y * this.height;
		this.spriteSheet = spriteSheet;
		
		loadSprite();		
	}

	public Sprite(int[] pixelsSprite, int widthSprite, int heightSprite) {
		this.width = widthSprite;
		this.height = heightSprite;
		this.pixelsSprite = new int[pixelsSprite.length];
		for (int i = 0; i < pixelsSprite.length; i++) {
			this.pixelsSprite[i] = pixelsSprite[i];
		}
		
	}
	
	
	
	public Sprite(int width, int height, int color) {
		this.width = width;
		this.height = height;
        this.totalPx = this.width * this.height;
		pixelsSprite = new int[totalPx];

        for(int i = 0; i < this.totalPx; i++) {
            pixelsSprite[i] = color;
        }
	}

	private void loadSprite() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixelsSprite[x + y * width] = spriteSheet.pixelsSpriteSheet[(x + this.x) + ((y + this.y) * spriteSheet.width)];
			}
		}
	}
}