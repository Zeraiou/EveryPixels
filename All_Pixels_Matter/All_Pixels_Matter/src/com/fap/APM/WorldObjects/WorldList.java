package com.fap.APM.WorldObjects;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Graphics.Sprite;
import com.fap.APM.Graphics.SpriteSheet;
import com.fap.APM.WorldObjects.Items.Item;
import com.fap.APM.WorldObjects.Basics.Resource;
import com.fap.APM.WorldObjects.Basics.Tile;
import com.fap.APM.WorldObjects.Basics.Wall;
import com.fap.APM.Graphics.Particle;
import com.fap.APM.WorldObjects.Units.Player;
import com.fap.APM.WorldObjects.Units.Monster;
import java.util.ArrayList;
import java.util.List;

public class WorldList {

    public static List<Player> players = new ArrayList<Player>();
    public static List<Monster> monsters = new ArrayList<Monster>();
    public static List<Particle> particles = new ArrayList<Particle>();

    public static List<Tile> tiles = new ArrayList<Tile>();
    public static List<Wall> walls = new ArrayList<Wall>();
    public static List<Resource> resources = new ArrayList<Resource>();
    public static List<Item> items = new ArrayList<Item>();

    public static SpriteSheet player_Base34 = new SpriteSheet(ControlRoom.PLAYER_SPRITE_PATH, 144, 144);
    public static SpriteSheet player_Base34_Down = new SpriteSheet(player_Base34, 0, 0, 1, 3, 36, 48);
    public static SpriteSheet player_Base34_Right = new SpriteSheet(player_Base34, 1, 0, 1, 3, 36, 48);
    public static SpriteSheet player_Base34_Up = new SpriteSheet(player_Base34, 2, 0, 1, 3, 36, 48);
    public static SpriteSheet player_Base34_Left = new SpriteSheet(player_Base34, 3, 0, 1, 3, 36, 48);
    public static Sprite sprite_Player_Base34 = new Sprite(36, 48, 0, 0, player_Base34);

    public static SpriteSheet zombie_Base22 = new SpriteSheet(ControlRoom.ZOMBIE_SPRITE_PATH, 96, 72);
    public static SpriteSheet zombie_Base22_Down = new SpriteSheet(zombie_Base22, 0, 0, 1, 3, 24, 24);
    public static SpriteSheet zombie_Base22_Right = new SpriteSheet(zombie_Base22, 1, 0, 1, 3, 24, 24);
    public static SpriteSheet zombie_Base22_Up = new SpriteSheet(zombie_Base22, 2, 0, 1, 3, 24, 24);
    public static SpriteSheet zombie_Base22_Left = new SpriteSheet(zombie_Base22, 3, 0, 1, 3, 24, 24);
    public static Sprite sprite_zombie_Base22 = new Sprite(24, 24, 0, 0, zombie_Base22);

    public static Sprite particle1p = new Sprite(1, 1, 0xff7f00ff);
    public static Sprite particle2p = new Sprite(2, 2, 0xff7f00ff);
    public static Sprite particle3p = new Sprite(3, 3, 0xff7f00ff);

    public static Sprite particle4p = new Sprite(4, 4, 0xff7f00ff);
    public static Sprite particle5p = new Sprite(5, 5, 0xff7f00ff);
    public static Sprite particle6p = new Sprite(6, 6, 0xff7f00ff);

    public static Sprite particle7p = new Sprite(7, 7, 0xff7f00ff);
    public static Sprite particle8p = new Sprite(8, 8, 0xff7f00ff);
    public static Sprite particle9p = new Sprite(9, 9, 0xff7f00ff);

    public static SpriteSheet tiles_Base12 = new SpriteSheet(ControlRoom.TILE_SPRITE_PATH, 48, 36);
    public static Sprite tile_Void12_Out = new Sprite(12, 12, 0x5D3F97);
    public static Sprite tile_Void12_In = new Sprite(12, 12, 0x694BE1);
    public static Sprite tile_Grass12 = new Sprite(12, 12, 0, 0, tiles_Base12);
    public static Sprite tile_Rock12 = new Sprite(12, 12, 1, 0, tiles_Base12);
    public static Sprite tile_Water12 = new Sprite(12, 12, 2, 0, tiles_Base12);
    public static Sprite tile_Sand12 = new Sprite(12, 12, 3, 0, tiles_Base12);
    public static Sprite tile_Floor_Wood12 = new Sprite(12, 12, 0, 1, tiles_Base12);
    public static Sprite tile_Wall_Wood12 = new Sprite(12, 12, 1, 1, tiles_Base12);
    public static Sprite tile_Wall_Rock12 = new Sprite(12, 12, 2, 1, tiles_Base12);
    public static Sprite tile_Floor_Rock12 = new Sprite(12, 12, 3, 1, tiles_Base12);
    public static Sprite tile_Ice12 = new Sprite(12, 12, 0, 2, tiles_Base12);
    public static Sprite tile_Snow12 = new Sprite(12, 12, 1, 2, tiles_Base12);
    public static Sprite tile_Lava12 = new Sprite(12, 12, 2, 2, tiles_Base12);
    public static Sprite tile_Dirt12 = new Sprite(12, 12, 3, 2, tiles_Base12);

    public static Tile tile_Void_Out = new Tile(tile_Void12_Out);
    public static Tile tile_Void_In = new Tile(tile_Void12_In);
    public static Tile tile_Grass = new Tile(tile_Grass12);
    public static Tile tile_Rock = new Tile(tile_Rock12);
    public static Tile tile_Water = new Tile(tile_Water12);
    public static Tile tile_Sand = new Tile(tile_Sand12);
    public static Tile tile_Floor_Wood = new Tile(tile_Floor_Wood12);
    public static Tile tile_Wall_Wood = new Tile(tile_Wall_Wood12);
    public static Tile tile_Wall_Rock = new Tile(tile_Wall_Rock12);
    public static Tile tile_Floor_Rock = new Tile(tile_Floor_Rock12);
    public static Tile tile_Ice = new Tile(tile_Ice12);
    public static Tile tile_Snow = new Tile(tile_Snow12);
    public static Tile tile_Lava = new Tile(tile_Lava12);
    public static Tile tile_Dirt = new Tile(tile_Dirt12);

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
    public static final int COLOR_NULL1 = 0xffFF00FF;
    public static final int COLOR_NULL2 = 0xff7f007f;
}
