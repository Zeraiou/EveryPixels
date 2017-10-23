package com.fap.APM;

public class ControlRoom {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_CENTER_X = SCREEN_WIDTH / 2;
    public static final int SCREEN_CENTER_Y = SCREEN_HEIGHT / 2;

    public static final int STARTING_X = 60 * 12;
    public static final int STARTING_Y = 60 * 12;

    public static final int WIDTH_TILE = 12;
    public static final int HEIGHT_TILE = 12;

    public static final String GAME_TITLE = "All Pixels Matter!";
    public static final String TILE_SPRITE_PATH = "/Textures/SpriteSheets/Tiles/TileBase12.png";
    public static final String PLAYER_SPRITE_PATH = "/Textures/SpriteSheets/Units/Player/Player_Base-3X4.png";
    public static final String ZOMBIE_SPRITE_PATH = "/Textures/SpriteSheets/Units/Monster/Zombie_Base-2X2.png";
    public static final String MAP_FIELD_PATH = "/Map/Map512-Field.png"; // Map64.png, Map1024.png, Map8192.png

    public static final double NANOSECONDE = 1000000000.0 / 60.0;
}