package com.fap.APM.Graphics.SpriteSheet;

public class Sprite {
	
	private int x, y;
	public final int WIDTH_SPRITE, HEIGHT_SPRITE;
	public int[] pixelsSprite;
	
	protected SpriteSheet spriteSheet;
	

	public static Sprite tile_Void8_Out = new Sprite(8, 8, 0x5D3F97);
	public static Sprite tile_Void8_In = new Sprite(8, 8, 0x694BE1);
	
	public static Sprite tile_Grass8 = new Sprite(8, 8, 0, 0, SpriteSheet.tiles_Base8);
	public static Sprite tile_Rock8 = new Sprite(8, 8, 1, 0, SpriteSheet.tiles_Base8);
	public static Sprite tile_Water8 = new Sprite(8, 8, 2, 0, SpriteSheet.tiles_Base8);
	public static Sprite tile_Sand8 = new Sprite(8, 8, 3, 0, SpriteSheet.tiles_Base8);
	public static Sprite tile_Floor_Wood8 = new Sprite(8, 8, 0, 1, SpriteSheet.tiles_Base8);
	public static Sprite tile_Wall_Wood8 = new Sprite(8, 8, 1, 1, SpriteSheet.tiles_Base8);
	public static Sprite tile_Wall_Rock8 = new Sprite(8, 8, 2, 1, SpriteSheet.tiles_Base8);
	public static Sprite tile_Floor_Rock8 = new Sprite(8, 8, 3, 1, SpriteSheet.tiles_Base8);
	public static Sprite tile_Ice8 = new Sprite(8, 8, 0, 2, SpriteSheet.tiles_Base8);
	public static Sprite tile_Snow8 = new Sprite(8, 8, 1, 2, SpriteSheet.tiles_Base8);
	public static Sprite tile_Lava8 = new Sprite(8, 8, 2, 2, SpriteSheet.tiles_Base8);
	public static Sprite tile_Dirt8 = new Sprite(8, 8, 3, 2, SpriteSheet.tiles_Base8);
	
	
	/*
	public static Sprite grass10 = new Sprite(10, 10, 0, 0, SpriteSheet.tiles_Base10);
	public static Sprite grass12 = new Sprite(12, 12, 0, 0, SpriteSheet.tiles_Base12);
	public static Sprite grass16 = new Sprite(16, 16, 0, 0, SpriteSheet.tiles_Base16);
	public static Sprite grass32 = new Sprite(32, 32, 0, 0, SpriteSheet.tiles_Base32);
	public static Sprite grass64 = new Sprite(64, 64, 0, 0, SpriteSheet.tiles_Base64);
	*/
	
	public Sprite(int widthSprite, int heightSprite, int x, int y, SpriteSheet spriteSheet) {
		this.WIDTH_SPRITE = widthSprite;
		this.HEIGHT_SPRITE = heightSprite;
		pixelsSprite = new int[WIDTH_SPRITE * HEIGHT_SPRITE];
		this.x = x * WIDTH_SPRITE;
		this.y = y * HEIGHT_SPRITE;
		this.spriteSheet = spriteSheet;
		loadSprite();		
	}
	
	public Sprite(int widthSprite, int heightSprite, int Color) {
	
		this.WIDTH_SPRITE = widthSprite;
		this.HEIGHT_SPRITE = heightSprite;
		pixelsSprite = new int[widthSprite * heightSprite];
		SetColor(Color);
	}

	private void SetColor(int color) {
		for(int i = 0; i < WIDTH_SPRITE * HEIGHT_SPRITE; i++) {
			pixelsSprite[i] = color;
		}
		
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
