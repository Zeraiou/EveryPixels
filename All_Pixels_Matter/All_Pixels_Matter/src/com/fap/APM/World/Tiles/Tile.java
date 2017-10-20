package com.fap.APM.World.Tiles;

import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Graphics.SpriteSheet.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile tile_Void_Out = new Tile(Sprite.tile_Void12_Out);
	public static Tile tile_Void_In = new Tile(Sprite.tile_Void12_In);
	
	public static Tile tile_Grass = new Tile(Sprite.tile_Grass12);
	public static Tile tile_Rock = new Tile(Sprite.tile_Rock8);
	public static Tile tile_Water = new Tile(Sprite.tile_Water8);
	public static Tile tile_Sand = new Tile(Sprite.tile_Sand8);
	public static Tile tile_Floor_Wood = new Tile(Sprite.tile_Floor_Wood8);
	public static Tile tile_Wall_Wood = new Tile(Sprite.tile_Wall_Wood8);
	public static Tile tile_Wall_Rock = new Tile(Sprite.tile_Wall_Rock8);
	public static Tile tile_Floor_Rock = new Tile(Sprite.tile_Floor_Rock8);
	public static Tile tile_Ice = new Tile(Sprite.tile_Ice8);
	public static Tile tile_Snow = new Tile(Sprite.tile_Snow8);
	public static Tile tile_Lava = new Tile(Sprite.tile_Lava8);
	public static Tile tile_Dirt = new Tile(Sprite.tile_Dirt8);
	
	
	public static final int  COLOR_GRASS = 0xff27E109;
	public static final int  COLOR_ROCK = 0xffB8B8B8;
	public static final int  COLOR_WATER = 0xff146ADB;
	public static final int  COLOR_SAND = 0xffE7D440;
	public static final int  COLOR_FLOOR_WOOD = 0xffEAAF48;
	public static final int  COLOR_WALL_WOOD = 0xff694E21;
	public static final int  COLOR_WALL_ROCK = 0xff807A6F;
	public static final int  COLOR_FLOOR_ROCK = 0xffA59883;
	public static final int  COLOR_ICE = 0xff929FCE;
	public static final int  COLOR_SNOW = 0xffE9EDFC;
	public static final int  COLOR_LAVA = 0xffDE361B;
	public static final int  COLOR_DIRT = 0xff694B11;
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	public void renderTile(int x, int y, ScreenDisplay screen) {
		screen.renderTile(x * screen.widthTile, y * screen.heightTile, this);
		
	}
	

	public boolean solid() {
		return false;
		
	}
	
	
	
}
