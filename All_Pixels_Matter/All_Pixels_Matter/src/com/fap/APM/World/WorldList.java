package com.fap.APM.World;

import com.fap.APM.ControlRoom;
import com.fap.APM.Graphics.Sprite;
import com.fap.APM.Graphics.SpriteSheet;
import com.fap.APM.Objects.Item;
import com.fap.APM.Objects.Resource;
import com.fap.APM.Objects.Tile;
import com.fap.APM.Objects.Wall;
import com.fap.APM.Units.Entity;
import com.fap.APM.Particles.Particle;
import com.fap.APM.Units.Player;
import com.fap.APM.Units.Zombie;

import java.util.ArrayList;
import java.util.List;

public class WorldList {

    public static List<Player> players = new ArrayList<Player>();
    public static List<Entity> entities = new ArrayList<Entity>();
    public static List<Zombie> monsters = new ArrayList<Zombie>();
    public static List<Particle> particles = new ArrayList<Particle>();
    public static List<Wall> walls = new ArrayList<Wall>();
    public static List<Resource> resources = new ArrayList<Resource>();
    public static List<Item> items = new ArrayList<Item>();
    public static List<Tile> tiles = new ArrayList<Tile>();

    public static SpriteSheet player_Base34 = new SpriteSheet(ControlRoom.PLAYER_SPRITE_PATH, 144, 192);
    public static Sprite player_Base_Down34 = new Sprite(36, 48, 0, 0, WorldList.player_Base34);
    public static Sprite player_Base_Right34 = new Sprite(36, 48, 1, 0, WorldList.player_Base34);
    public static Sprite player_Base_Up34 = new Sprite(36, 48, 2, 0, WorldList.player_Base34);
    public static Sprite player_Base_Left34 = new Sprite(36, 48, 3, 0, WorldList.player_Base34);

    public static SpriteSheet zombie_Base22 = new SpriteSheet(ControlRoom.ZOMBIE_SPRITE_PATH, 96, 72);
    public static Sprite zombie_Base_Down22 = new Sprite(24, 24, 0, 0, WorldList.zombie_Base22);
    public static Sprite zombie_Base_Right22 = new Sprite(24, 24, 1, 0, WorldList.zombie_Base22);
    public static Sprite zombie_Base_Up22 = new Sprite(24, 24, 2, 0, WorldList.zombie_Base22);
    public static Sprite zombie_Base_Left22 = new Sprite(24, 24, 3, 0, WorldList.zombie_Base22);

    public static Sprite particle1p = new Sprite(1, 1, 0xff7f00ff);
    public static Sprite particle2p = new Sprite(2, 2, 0xff7f00ff);
    public static Sprite particle3p = new Sprite(3, 3, 0xff7f00ff);

    public static Sprite particle4p = new Sprite(4, 4, 0xff7f00ff);
    public static Sprite particle5p = new Sprite(5, 5, 0xff7f00ff);
    public static Sprite particle6p = new Sprite(6, 6, 0xff7f00ff);

    public static Sprite particle7p = new Sprite(7, 7, 0xff7f00ff);
    public static Sprite particle8p = new Sprite(8, 8, 0xff7f00ff);
    public static Sprite particle9p = new Sprite(9, 9, 0xff7f00ff);

}
