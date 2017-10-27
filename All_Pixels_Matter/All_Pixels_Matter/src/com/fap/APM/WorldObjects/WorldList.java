package com.fap.APM.WorldObjects;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Graphics.Sprite;
import com.fap.APM.Graphics.SpriteSheet;
import com.fap.APM.WorldObjects.Items.Item;
import com.fap.APM.WorldObjects.Basics.Resource;
import com.fap.APM.WorldObjects.Basics.Tile;
import com.fap.APM.WorldObjects.Basics.Wall;
import com.fap.APM.Graphics.Particle;
import com.fap.APM.WorldObjects.Units.Monster;
import java.util.ArrayList;
import java.util.List;

public class WorldList {

    public static List<Monster> monsters = new ArrayList<Monster>();
    public static List<Particle> particles = new ArrayList<Particle>();

    public static List<Tile> tiles = new ArrayList<Tile>();
    public static List<Wall> walls = new ArrayList<Wall>();
    public static List<Resource> resources = new ArrayList<Resource>();
    public static List<Item> items = new ArrayList<Item>();

    public static SpriteSheet player_Base34 = new SpriteSheet(ControlRoom.PLAYER_SPRITE_PATH, 144, 192);
    public static SpriteSheet player_Idle_Down = new SpriteSheet(player_Base34, 0, 0, 1, 1, 36, 48);
    public static SpriteSheet player_Idle_Right = new SpriteSheet(player_Base34, 1, 0, 1, 1, 36, 48);
    public static SpriteSheet player_Idle_Up = new SpriteSheet(player_Base34, 2, 0, 1, 1, 36, 48);
    public static SpriteSheet player_Idle_Left = new SpriteSheet(player_Base34, 3, 0, 1, 1, 36, 48);
  
    public static SpriteSheet player_Base34_Down = new SpriteSheet(player_Base34, 0, 1, 1, 3, 36, 48);
    public static SpriteSheet player_Base34_Right = new SpriteSheet(player_Base34, 1, 1, 1, 3, 36, 48);
    public static SpriteSheet player_Base34_Up = new SpriteSheet(player_Base34, 2, 1, 1, 3, 36, 48);
    public static SpriteSheet player_Base34_Left = new SpriteSheet(player_Base34, 3, 1, 1, 3, 36, 48);
    public static Sprite sprite_Player_Base34 = new Sprite(36, 48, 0, 0, player_Base34);

    public static SpriteSheet zombie_Base22 = new SpriteSheet(ControlRoom.ZOMBIE_SPRITE_PATH, 96, 72);
    public static SpriteSheet zombie_Base22_Down = new SpriteSheet(zombie_Base22, 0, 0, 1, 3, 24, 24);
    public static SpriteSheet zombie_Base22_Right = new SpriteSheet(zombie_Base22, 1, 0, 1, 3, 24, 24);
    public static SpriteSheet zombie_Base22_Up = new SpriteSheet(zombie_Base22, 2, 0, 1, 3, 24, 24);
    public static SpriteSheet zombie_Base22_Left = new SpriteSheet(zombie_Base22, 3, 0, 1, 3, 24, 24);
    public static Sprite sprite_zombie_Base22 = new Sprite(24, 24, 0, 0, zombie_Base22);

    public static SpriteSheet espirito_66 = new SpriteSheet(ControlRoom.ESPIRITO_SPRITE_PATH, 288, 216);
    public static SpriteSheet espirito_66_Down = new SpriteSheet(espirito_66, 0, 0, 1, 3, 72, 72);
    public static SpriteSheet espirito_66_Right = new SpriteSheet(espirito_66, 1, 0, 1, 3, 72, 72);
    public static SpriteSheet espirito_66_Up = new SpriteSheet(espirito_66, 2, 0, 1, 3, 72, 72);
    public static SpriteSheet espirito_66_Left = new SpriteSheet(espirito_66, 3, 0, 1, 3, 72, 72);
    public static Sprite sprite_espirito_66 = new Sprite(72, 72, 0, 0, espirito_66);

    public static SpriteSheet larvion_46 = new SpriteSheet(ControlRoom.LARVION_SPRITE_PATH, 192, 216);
    public static SpriteSheet larvion_46_Down = new SpriteSheet(larvion_46, 0, 0, 1, 3, 48, 72);
    public static SpriteSheet larvion_46_Right = new SpriteSheet(larvion_46, 1, 0, 1, 3, 48, 72);
    public static SpriteSheet larvion_46_Up = new SpriteSheet(larvion_46, 2, 0, 1, 3, 48, 72);
    public static SpriteSheet larvion_46_Left = new SpriteSheet(larvion_46, 3, 0, 1, 3, 48, 72);
    public static Sprite sprite_larvion_46 = new Sprite(48, 72, 0, 0, larvion_46);

    public static SpriteSheet bichette_34 = new SpriteSheet(ControlRoom.BICHETTE_SPRITE_PATH, 144, 144);
    public static SpriteSheet bichette_34_Down = new SpriteSheet(bichette_34, 0, 0, 1, 3, 36, 48);
    public static SpriteSheet bichette_34_Right = new SpriteSheet(bichette_34, 1, 0, 1, 3, 36, 48);
    public static SpriteSheet bichette_34_Up = new SpriteSheet(bichette_34, 2, 0, 1, 3, 36, 48);
    public static SpriteSheet bichette_34_Left = new SpriteSheet(bichette_34, 3, 0, 1, 3, 36, 48);
    public static Sprite sprite_bichette_34 = new Sprite(36, 48, 0, 0, bichette_34);

    
    public static Sprite particle1p = new Sprite(1, 1, 0xff7f00ff);
    public static Sprite particle2p = new Sprite(2, 2, 0xff7f00ff);
    public static Sprite particle3p = new Sprite(3, 3, 0xff7f00ff);

    public static Sprite particle4p = new Sprite(4, 4, 0xff7f00ff);
    public static Sprite particle5p = new Sprite(5, 5, 0xff7f00ff);
    public static Sprite particle6p = new Sprite(6, 6, 0xff7f00ff);

    public static Sprite particle7p = new Sprite(7, 7, 0xff7f00ff);
    public static Sprite particle8p = new Sprite(8, 8, 0xff7f00ff);
    public static Sprite particle9p = new Sprite(9, 9, 0xff7f00ff);

    public static Sprite tile_Void12_Out = new Sprite(12, 12, 0x5D3F97);
    public static Sprite tile_Void12_In = new Sprite(12, 12, 0x694BE1);
    public static Sprite sprite_Void12_transparent = new Sprite(12, 12, 0x00000000);
    
    public static SpriteSheet tiles_Base12 = new SpriteSheet(ControlRoom.TILE_SPRITE_PATH, 48, 36);
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

    
    public static SpriteSheet Wall_Wood = new SpriteSheet(ControlRoom.WALL_WOOD_SPRITE_PATH, 120, 168);
    public static Sprite sprite_Wall_Wood_1 = new Sprite(12, 48, 9, 0, Wall_Wood);
    public static Sprite sprite_Wall_Wood_2 = new Sprite(24, 48, 2, 0, Wall_Wood);
    public static Sprite sprite_Wall_Wood_3 = new Sprite(36, 48, 2, 0, Wall_Wood);
    public static Sprite sprite_Wall_Wood_4 = new Sprite(48, 48, 0, 0, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_1X1 = new Sprite(12, 12, 9, 8, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_1X2 = new Sprite(12, 24, 9, 6, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_1X3 = new Sprite(12, 36, 9, 3, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_1X4 = new Sprite(12, 48, 9, 1, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_2X1 = new Sprite(24, 12, 2, 8, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_2X2 = new Sprite(24, 24, 2, 6, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_2X3 = new Sprite(24, 36, 2, 3, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_2X4 = new Sprite(24, 48, 2, 1, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_3X1 = new Sprite(36, 12, 2, 8, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_3X2 = new Sprite(36, 24, 2, 6, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_3X3 = new Sprite(36, 36, 2, 3, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_3X4 = new Sprite(36, 48, 2, 1, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_4X1 = new Sprite(48, 12, 0, 8, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_4X2 = new Sprite(48, 24, 0, 6, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_4X3 = new Sprite(48, 36, 0, 3, Wall_Wood);
    public static Sprite sprite_Wall_Wood_Top_4X4 = new Sprite(48, 48, 0, 1, Wall_Wood);
   
    public static final int COLOR_TRANSPARENT = 0xffff00ff;
    public static final int COLOR_WALL_WOOD_1 = 0xff4293E8;
    public static final int COLOR_WALL_WOOD_2 = 0xffE53327;
    public static final int COLOR_WALL_WOOD_3 = 0xff42933F;
    public static final int COLOR_WALL_WOOD_4 = 0xffC6933F;
    public static final int COLOR_WALL_WOOD_TOP_1X2 = 0xff6BFFF2;
    public static final int COLOR_WALL_WOOD_TOP_2X1 = 0xff42E586;
    public static final int COLOR_WALL_WOOD_TOP_2X2 = 0xffE0DD35;
    public static final int COLOR_WALL_WOOD_TOP_2X3 = 0xffE27CC2;
    public static final int COLOR_WALL_WOOD_TOP_2X4 = 0xff38387F;
    public static final int COLOR_WALL_WOOD_TOP_3X2 = 0xffE02670;
    public static final int COLOR_WALL_WOOD_TOP_4X2 = 0xff7F5E28;
    // public static final int COLOR_WALL_WOOD_TOP_1X1 = 0xff27E109;
    // public static final int COLOR_WALL_WOOD_TOP_1X3 = 0xff27E109;
    // public static final int COLOR_WALL_WOOD_TOP_1X4 = 0xff27E109;
    // public static final int COLOR_WALL_WOOD_TOP_3X1 = 0xff27E109;
   /* public static final int COLOR_WALL_WOOD_TOP_3X3 = 0xff27E109;
    public static final int COLOR_WALL_WOOD_TOP_3X4 = 0xff27E109;
    public static final int COLOR_WALL_WOOD_TOP_4X1 = 0xff27E109;
    public static final int COLOR_WALL_WOOD_TOP_4X3 = 0xff27E109;
    public static final int COLOR_WALL_WOOD_TOP_4X4 = 0xff27E109;
   */
    
    public static SpriteSheet Door_Wood = new SpriteSheet(ControlRoom.DOOR_WOOD_SPRITE_PATH, 96, 96);
    public static Sprite sprite_Door_Wood_Close = new Sprite(48, 48, 0, 1, Door_Wood);
    public static Sprite sprite_Door_Wood_Open = new Sprite(12, 48, 4, 1, Door_Wood);
    public static Sprite sprite_Door_Wood_Top_Close = new Sprite(48, 12, 0, 3, Door_Wood);
    public static Sprite sprite_Wall_Wood_Top_Open = new Sprite(12, 48, 4, 0, Door_Wood);
    
    public static final int COLOR_DOOR_WOOD_TOP_CLOSE = 0xffEAF8FF;
    public static final int COLOR_DOOR_WOOD_CLOSE = 0xffD3F4FF;
    public static final int COLOR_DOOR_WOOD_TOP_OPEN = 0xffB375FF;
    public static final int COLOR_DOOR_WOOD_OPEN = 0xffC4A5FF;
    
    
    
    
    
    
    
    
    public static SpriteSheet Coniferous = new SpriteSheet(ControlRoom.CONIFEROUS_SPRITE_PATH, 144, 96);
    public static Sprite sprite_Coniferous_Big = new Sprite(72, 96, 0, 0, Coniferous);
    public static Sprite sprite_Coniferous_Small = new Sprite(72, 72, 1, 0, Coniferous);
    
    public static SpriteSheet Hardwood = new SpriteSheet(ControlRoom.HARDWOOD_SPRITE_PATH, 120, 120);
    public static Sprite sprite_Hardwood_Big = new Sprite(60, 96, 1, 0, Hardwood);
    public static Sprite sprite_Hardwood_Small = new Sprite(60, 72, 0, 0, Hardwood);
    public static Sprite sprite_Bush_Big = new Sprite(36, 24, 0, 3, Hardwood);
    public static Sprite sprite_Bush_Small = new Sprite(24, 24, 0, 4, Hardwood);
    
    public static SpriteSheet Rock = new SpriteSheet(ControlRoom.ROCK_SPRITE_PATH, 36, 72);
    public static Sprite sprite_Rock_1X1 = new Sprite(12, 12, 0, 2, Rock);
    public static Sprite sprite_Rock_2X2 = new Sprite(24, 24, 0, 0, Rock);
    public static Sprite sprite_Rock_3X3 = new Sprite(36, 36, 0, 1, Rock);
    
    public static final int COLOR_CONIFEROUS_BIG = 0xffC619FF;
    public static final int COLOR_CONIFEROUS_SMALL = 0xff870FFF;
    public static final int COLOR_HARDWOOD_BIG = 0xffE500FF;
    public static final int COLOR_HARDWOOD_SMALL = 0xffFF00A5;
    public static final int COLOR_BUSH_BIG = 0xffFF0037;
    public static final int COLOR_BUSH_SMALL = 0xffFF6100;
    
    public static final int COLOR_ROCK_1X1 = 0xff5B5B5B;
    public static final int COLOR_ROCK_2X2 = 0xff676772;
    public static final int COLOR_ROCK_3X3 = 0xff7A7A87;
    
    
    
}

