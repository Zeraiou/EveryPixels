package com.fap.APM.World;
import com.fap.APM.ControlRoom;
import com.fap.APM.Graphics.Sprite;
import com.fap.APM.Graphics.SpriteSheet;
import com.fap.APM.Objects.Tile;

public class TileMaker {

    public static SpriteSheet tiles_Base12 = new SpriteSheet(ControlRoom.TILE_SPRITE_PATH, 48, 36);
    public static Sprite tile_Void12_Out = new Sprite(12, 12, 0x5D3F97);
    public static Sprite tile_Void12_In = new Sprite(12, 12, 0x694BE1);
    public static Sprite tile_Grass12 = new Sprite(12, 12, 0, 0, TileMaker.tiles_Base12);
    public static Sprite tile_Rock12 = new Sprite(12, 12, 1, 0, TileMaker.tiles_Base12);
    public static Sprite tile_Water12 = new Sprite(12, 12, 2, 0, TileMaker.tiles_Base12);
    public static Sprite tile_Sand12 = new Sprite(12, 12, 3, 0, TileMaker.tiles_Base12);
    public static Sprite tile_Floor_Wood12 = new Sprite(12, 12, 0, 1, TileMaker.tiles_Base12);
    public static Sprite tile_Wall_Wood12 = new Sprite(12, 12, 1, 1, TileMaker.tiles_Base12);
    public static Sprite tile_Wall_Rock12 = new Sprite(12, 12, 2, 1, TileMaker.tiles_Base12);
    public static Sprite tile_Floor_Rock12 = new Sprite(12, 12, 3, 1, TileMaker.tiles_Base12);
    public static Sprite tile_Ice12 = new Sprite(12, 12, 0, 2, TileMaker.tiles_Base12);
    public static Sprite tile_Snow12 = new Sprite(12, 12, 1, 2, TileMaker.tiles_Base12);
    public static Sprite tile_Lava12 = new Sprite(12, 12, 2, 2, TileMaker.tiles_Base12);
    public static Sprite tile_Dirt12 = new Sprite(12, 12, 3, 2, TileMaker.tiles_Base12);

    public static Tile tile_Void_Out = new Tile(TileMaker.tile_Void12_Out);
    public static Tile tile_Void_In = new Tile(TileMaker.tile_Void12_In);
    public static Tile tile_Grass = new Tile(TileMaker.tile_Grass12);
    public static Tile tile_Rock = new Tile(TileMaker.tile_Rock12);
    public static Tile tile_Water = new Tile(TileMaker.tile_Water12);
    public static Tile tile_Sand = new Tile(TileMaker.tile_Sand12);
    public static Tile tile_Floor_Wood = new Tile(TileMaker.tile_Floor_Wood12);
    public static Tile tile_Wall_Wood = new Tile(TileMaker.tile_Wall_Wood12);
    public static Tile tile_Wall_Rock = new Tile(TileMaker.tile_Wall_Rock12);
    public static Tile tile_Floor_Rock = new Tile(TileMaker.tile_Floor_Rock12);
    public static Tile tile_Ice = new Tile(TileMaker.tile_Ice12);
    public static Tile tile_Snow = new Tile(TileMaker.tile_Snow12);
    public static Tile tile_Lava = new Tile(TileMaker.tile_Lava12);
    public static Tile tile_Dirt = new Tile(TileMaker.tile_Dirt12);

    public static final int COLOR_GRASS = 0xff27E109;
    public static final int COLOR_ROCK = 0xffB8B8B8;
    public static final int COLOR_WATER = 0xff146ADB;
    public static final int COLOR_SAND = 0xffE7D440;
    public static final int COLOR_FLOOR_WOOD = 0xffEAAF48;
    public static final int COLOR_WALL_WOOD = 0xff694E21;
    public static final int COLOR_WALL_ROCK = 0xff807A6F;
    public static final int COLOR_FLOOR_ROCK = 0xffA59883;
    public static final int COLOR_ICE = 0xff929FCE;
    public static final int COLOR_SNOW = 0xffE9EDFC;
    public static final int COLOR_LAVA = 0xffDE361B;
    public static final int COLOR_DIRT = 0xff694B11;
}