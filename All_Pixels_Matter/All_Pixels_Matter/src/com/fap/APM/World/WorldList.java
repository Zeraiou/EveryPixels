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

<<<<<<< Updated upstream
    public static SpriteSheet player_Base34 = new SpriteSheet(ControlRoom.PLAYER_SPRITE_PATH, 144, 192);
=======
    public static SpriteSheet player_Base34 = new SpriteSheet(ControlRoom.PLAYER_SPRITE_PATH, 144, 144);
>>>>>>> Stashed changes
    public static SpriteSheet player_Base34_Down = new SpriteSheet(player_Base34, 0, 0, 1, 3, 36, 48);
    public static SpriteSheet player_Base34_Right = new SpriteSheet(player_Base34, 0, 0, 1, 3, 36, 48);
    public static SpriteSheet player_Base34_Up = new SpriteSheet(player_Base34, 0, 0, 1, 3, 36, 48);
    public static SpriteSheet player_Base34_Left = new SpriteSheet(player_Base34, 0, 0, 1, 3, 36, 48);
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

}
