package com.fap.APM.Graphics.SpriteSheet;

public class Sprite {
	
	private int x, y;
	public final int WIDTH_SPRITE, HEIGHT_SPRITE;
	public int[] pixelsSprite;
	
	protected SpriteSheet spriteSheet;
	

	public static Sprite tile_Void12_Out = new Sprite(12, 12, 0x5D3F97);
	public static Sprite tile_Void12_In = new Sprite(12, 12, 0x694BE1);
	
	public static Sprite tile_Grass12 = new Sprite(12, 12, 0, 0, SpriteSheet.tiles_Base12);
	public static Sprite tile_Rock12 = new Sprite(12, 12, 1, 0, SpriteSheet.tiles_Base12);
	public static Sprite tile_Water12 = new Sprite(12, 12, 2, 0, SpriteSheet.tiles_Base12);
	public static Sprite tile_Sand12 = new Sprite(12, 12, 3, 0, SpriteSheet.tiles_Base12);
	public static Sprite tile_Floor_Wood12 = new Sprite(12, 12, 0, 1, SpriteSheet.tiles_Base12);
	public static Sprite tile_Wall_Wood12 = new Sprite(12, 12, 1, 1, SpriteSheet.tiles_Base12);
	public static Sprite tile_Wall_Rock12 = new Sprite(12, 12, 2, 1, SpriteSheet.tiles_Base12);
	public static Sprite tile_Floor_Rock12 = new Sprite(12, 12, 3, 1, SpriteSheet.tiles_Base12);
	public static Sprite tile_Ice12 = new Sprite(12, 12, 0, 2, SpriteSheet.tiles_Base12);
	public static Sprite tile_Snow12 = new Sprite(12, 12, 1, 2, SpriteSheet.tiles_Base12);
	public static Sprite tile_Lava12 = new Sprite(12, 12, 2, 2, SpriteSheet.tiles_Base12);
	public static Sprite tile_Dirt12 = new Sprite(12, 12, 3, 2, SpriteSheet.tiles_Base12);
	
	
	public static Sprite player_Base_Down34 = new Sprite(36, 48, 0, 0, SpriteSheet.player_Base34);
	public static Sprite player_Base_Right34 = new Sprite(36, 48, 1, 0, SpriteSheet.player_Base34);
	public static Sprite player_Base_Up34 = new Sprite(36, 48, 2, 0, SpriteSheet.player_Base34);
	public static Sprite player_Base_Left34 = new Sprite(36, 48, 3, 0, SpriteSheet.player_Base34);
	
	
	public static Sprite zombie_Base_Down22 = new Sprite(24, 24, 0, 0, SpriteSheet.zombie_Base22);
	public static Sprite zombie_Base_Right22 = new Sprite(24, 24, 1, 0, SpriteSheet.zombie_Base22);
	public static Sprite zombie_Base_Up22 = new Sprite(24, 24, 2, 0, SpriteSheet.zombie_Base22);
	public static Sprite zombie_Base_Left22 = new Sprite(24, 24, 3, 0, SpriteSheet.zombie_Base22);
	
	public static Sprite particle1p = new Sprite(1, 1, 0xff7f00ff);
	public static Sprite particle2p = new Sprite(2, 2, 0xff7f00ff);
	public static Sprite particle3p = new Sprite(3, 3, 0xff7f00ff);
	public static Sprite particle4p = new Sprite(4, 4, 0xff7f00ff);
	public static Sprite particle5p = new Sprite(5, 5, 0xff7f00ff);
	public static Sprite particle6p = new Sprite(6, 6, 0xff7f00ff);
	public static Sprite particle7p = new Sprite(7, 7, 0xff7f00ff);
	public static Sprite particle8p = new Sprite(8, 8, 0xff7f00ff);
	public static Sprite particle9p = new Sprite(9, 9, 0xff7f00ff);

	
	
	
	
		
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
