package com.fap.APM.Core;
import com.fap.APM.WorldObjects.Units.Player;


public class ControlRoom {

    /// PLAYER STATS ///
    public static Player PLAYER;
    public static final double FIRE_RATE = 5.0;
    public static final double MOVEMENT_SPEED = 3.2;
    public static final double HEALTH_POINTS = 100.00;
    public static final double MAX_HEALTH_POINTS = 100.00;
    public static final int EXP_POINTS = 0;

    /// CONSOLE LOG SWITCHES ///
    public static final boolean PIXEL_TILE_LOAD_OUT = false;
    public static final boolean RENDER_SCREEN_OUT = false;
    public static final boolean MOUSE_INPUT_OUT = true;
    public static final boolean KEYBOARD_INPUT_OUT = true;

    /// SCREEN INFO ///
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_CENTER_X = SCREEN_WIDTH / 2;
    public static final int SCREEN_CENTER_Y = SCREEN_HEIGHT / 2;
    public static final int STARTING_X = 60 * 12;
    public static final int STARTING_Y = 60 * 12;
    public static final int TILE_WIDTH = 12;
    public static final int TILE_HEIGHT = 12;

    /// GAME INFO DATA ///
    public static int FPS = 0;
    public static int TPS = 0;
    public static long GAME_START_TIME = System.currentTimeMillis();

    /// SPRITE LOADING STRINGS ///
    public static final String GAME_TITLE = "All Pixels Matter!";
    public static final String TILE_SPRITE_PATH = "/Textures/SpriteSheets/Tiles/TileBase12.png";

        /// WALLS ///
    public static final String WALL_WOOD_SPRITE_PATH = "/Textures/SpriteSheets/Structure/Wall-Wood.png";
    public static final String DOOR_WOOD_SPRITE_PATH = "/Textures/SpriteSheets/Structure/Door-Wood.png";

    
        /// TREES ///
    public static final String CONIFEROUS_SPRITE_PATH = "/Textures/SpriteSheets/Resources/Coniferous.png";
    public static final String HARDWOOD_SPRITE_PATH = "/Textures/SpriteSheets/Resources/Hardwood.png";

        /// MONSTERS ///
    public static final String PLAYER_SPRITE_PATH = "/Textures/SpriteSheets/Units/Player/Player_Base-3X4.png";
    public static final String ZOMBIE_SPRITE_PATH = "/Textures/SpriteSheets/Units/Monster/Zombie_Base-2X2.png";
    public static final String LARVION_SPRITE_PATH = "/Textures/SpriteSheets/Units/Monster/Larvion-4X6.png";
    public static final String BICHETTE_SPRITE_PATH = "/Textures/SpriteSheets/Units/Monster/Bichette-3X4.png";
    public static final String ESPIRITO_SPRITE_PATH = "/Textures/SpriteSheets/Units/Monster/Espirito-6X6c.png";

    /// MAP DATA ///
    public static final String MAP_FIELD_PATH = "/Map/Map512-Field.png"; // Map64.png, Map1024.png, Map8192.png
    public static final String MAP_STRUCTURE_PATH = "/Map/Map512-Structure.png"; // Map64.png, Map1024.png, Map8192.png
    public static final String MAP_RESOURCE_PATH = "/Map/Map512-Resource.png"; // Map64.png, Map1024.png, Map8192.png

    /// TIME VARIABLES ///
    public static final double NANOSECONDE = 1000000000.0 / 60.0;
}