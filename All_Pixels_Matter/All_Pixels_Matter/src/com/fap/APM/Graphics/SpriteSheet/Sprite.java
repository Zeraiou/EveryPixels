package com.fap.APM.Graphics.SpriteSheet;

public class Sprite {
	
	private int x, y;
	public final int WIDTH_SPRITE, HEIGHT_SPRITE;
	public int[] pixelsSprite;
	
	protected SpriteSheet spriteSheet;
	
	public static Sprite grass16 = new Sprite(16, 16, 0, 0, SpriteSheet.tiles_Base16);
	public static Sprite grass32 = new Sprite(32, 32, 0, 0, SpriteSheet.tiles_Base32);
	public static Sprite grass64 = new Sprite(64, 64, 0, 0, SpriteSheet.tiles_Base64);
	
	
	public Sprite(int widthSprite, int heightSprite, int x, int y, SpriteSheet spriteSheet) {
		this.WIDTH_SPRITE = widthSprite;
		this.HEIGHT_SPRITE = heightSprite;
		pixelsSprite = new int[WIDTH_SPRITE * HEIGHT_SPRITE];
		this.x = x * widthSprite;
		this.y = y * heightSprite;
		this.spriteSheet = spriteSheet;
		loadSprite();		
	}


	public int getWidthSprite() {
		return WIDTH_SPRITE;
	}
	
	public int getHeightSprite() {
		return HEIGHT_SPRITE;
	}
	
	private void loadSprite() {
		for (int y = 0; y < HEIGHT_SPRITE; y++) {
			for (int x = 0; x < WIDTH_SPRITE; x++) {
				pixelsSprite[x + y * WIDTH_SPRITE] = spriteSheet.pixelsSpriteSheet[(x + this.x) + ((y + this.y) * spriteSheet.WIDTH_SPRITESHEET)];
		
			}
	
		}
	}	
	
}
