package com.fap.APM.Core;
import com.fap.APM.WorldObjects.Units.*;
import com.fap.APM.Graphics.Sprite;
import com.fap.APM.WorldObjects.WorldList;
import com.fap.APM.WorldObjects.Basics.Resource;
import com.fap.APM.WorldObjects.Basics.Wall;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WorldMaker {

    public int width, height, totalTiles;
    public int[] mapFieldTiles, mapStructures, mapResources;
    private static WorldMaker INSTANCE = null;
    private int time = 0;

    private WorldMaker() { }

    public static WorldMaker shared() {
        if (INSTANCE == null) {
            INSTANCE = new WorldMaker();
            INSTANCE.extractMapField();
            INSTANCE.extractMapStructure();
            INSTANCE.extractMapResource();
            
        }
        return INSTANCE;
    }

    private void extractMapField() {
        try {
            BufferedImage imageFromFile = ImageIO.read(WorldMaker.class.getResource(ControlRoom.MAP_FIELD_PATH));
            width = imageFromFile.getWidth();
            height = imageFromFile.getHeight();
            totalTiles = this.width * this.height;
            mapFieldTiles = new int[this.totalTiles];
            imageFromFile.getRGB(0, 0, width, height, mapFieldTiles, 0, width);

            if (ControlRoom.PIXEL_TILE_LOAD_OUT) {
                System.out.println("Width: " + width + " - Height: " + height + " - TotalTiles: " + totalTiles + " - Array Size: " + mapFieldTiles.length);
            }
        } catch (IOException e) {
            if (ControlRoom.PIXEL_TILE_LOAD_OUT) {
                System.out.println("ERROR -- extractMapField() Failed! \n");
            }
        }
    }

    private void extractMapStructure() {
        try {
            BufferedImage imageFromFile = ImageIO.read(WorldMaker.class.getResource(ControlRoom.MAP_STRUCTURE_PATH));
            mapStructures = new int[this.totalTiles];
            imageFromFile.getRGB(0, 0, width, height, mapStructures, 0, width);

            if (ControlRoom.PIXEL_TILE_LOAD_OUT) {
                System.out.println("Width: " + width + " - Height: " + height + " - TotalTiles: " + totalTiles + " - Array Size: " + mapFieldTiles.length);
            }
        } catch (IOException e) {
            if (ControlRoom.PIXEL_TILE_LOAD_OUT) {
                System.out.println("ERROR -- extractMapField() Failed! \n");
            }
        }
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x <width; x++) {

                Sprite sprite = getStructuresSprite(x, y);
                if (sprite != WorldList.sprite_Void12_transparent) {
                WorldMaker.shared().createWall(sprite, x * ControlRoom.TILE_WIDTH, y * ControlRoom.TILE_HEIGHT , sprite.width, sprite.height);
                }
            }
        }
        
    }
    
    private void extractMapResource() {
        try {
            BufferedImage imageFromFile = ImageIO.read(WorldMaker.class.getResource(ControlRoom.MAP_RESOURCE_PATH));
            mapResources = new int[this.totalTiles];
            imageFromFile.getRGB(0, 0, width, height, mapResources, 0, width);

            if (ControlRoom.PIXEL_TILE_LOAD_OUT) {
                System.out.println("Width: " + width + " - Height: " + height + " - TotalTiles: " + totalTiles + " - Array Size: " + mapFieldTiles.length);
            }
        } catch (IOException e) {
            if (ControlRoom.PIXEL_TILE_LOAD_OUT) {
                System.out.println("ERROR -- extractMapField() Failed! \n");
            }
        }
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x <width; x++) {

                Sprite sprite = getResourcesSprite(x, y);
                if (sprite != WorldList.sprite_Void12_transparent) {
                WorldMaker.shared().createResource(sprite, x * ControlRoom.TILE_WIDTH, y * ControlRoom.TILE_HEIGHT , sprite.width, sprite.height);
                }
            }
        }
        
    }

    public void createPlayer() {
        WorldList.players.add(new Player());

        if (ControlRoom.PIXEL_TILE_LOAD_OUT) {
            if (WorldList.players.size() == 0) {
                System.out.println("ERROR -- createPlayer() Failed!");
            } else {
                System.out.println("Total Players: " + WorldList.players.size());
                for (int i = 0; i < WorldList.players.size(); i++) {
                    System.out.println("Player " + i + ": " + WorldList.players.get(i).posX + ", " + WorldList.players.get(i).posY);
                }
            }
        }
    }

    public void createZombie(int posX, int posY, int orientation, int type, int level, int status) {
        Monster monster = new Monster(posX, posY, orientation, type, level, status);
        WorldList.monsters.add(monster);
    }

    public void createEspirito(int posX, int posY, int orientation, int type, int level, int status) {
        Monster monster = new Monster(posX, posY, orientation, type, level, status);
        WorldList.monsters.add(monster);
    }
    
    public void createLarvion(int posX, int posY, int orientation, int type, int level, int status) {
        Monster monster = new Monster(posX, posY, orientation, type, level, status);
        WorldList.monsters.add(monster);
    }
    
    public void createBichette(int posX, int posY, int orientation, int type, int level, int status) {
        Monster monster = new Monster(posX, posY, orientation, type, level, status);
        WorldList.monsters.add(monster);
    }
    
    public void createWall(Sprite sprite, int posX, int posY, int width, int height) {
		Wall wall = new Wall(sprite, posX, posY, width, height);
		WorldList.walls.add(wall);
	}
    
    public void createResource(Sprite sprite, int posX, int posY, int width, int height) {
		Resource resource = new Resource(sprite, posX, posY, width, height);
		WorldList.resources.add(resource);
	}

    public void removeEntity() {
        for (int i = 0; i < WorldList.monsters.size(); i++) {
            if (WorldList.monsters.get(i).isRemoved) {
                WorldList.monsters.remove(i);
            }
        }

        for (int i = 0; i < WorldList.particles.size(); i++) {
            if (WorldList.particles.get(i).timeToLive <= 0) {
                WorldList.particles.remove(i);
            }
        }
    }

	public Sprite getStructuresSprite(int x, int y) {
		if (x < 0 || y < 0 || x >= WorldMaker.shared().width || y >= WorldMaker.shared().height) return WorldList.sprite_Void12_transparent;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_1) return WorldList.sprite_Wall_Wood_1;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_2) return WorldList.sprite_Wall_Wood_2;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_3) return WorldList.sprite_Wall_Wood_3;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_4) return WorldList.sprite_Wall_Wood_4;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_1X2) return WorldList.sprite_Wall_Wood_Top_1X2;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_2X1) return WorldList.sprite_Wall_Wood_Top_2X1;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_2X2) return WorldList.sprite_Wall_Wood_Top_2X2;

		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_2X3) return WorldList.sprite_Wall_Wood_Top_2X3;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_3X2) return WorldList.sprite_Wall_Wood_Top_3X2;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_4X2) return WorldList.sprite_Wall_Wood_Top_4X2;

		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_TRANSPARENT) return WorldList.sprite_Void12_transparent;
		if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_2X4) {
			return WorldList.sprite_Wall_Wood_Top_2X4; 
		} else {
			return WorldList.sprite_Void12_transparent;
		}

        /*
        if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_1X1) return WorldList.sprite_Wall_Wood_Top_1X1;
        if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_1X3) return WorldList.sprite_Wall_Wood_Top_1X3;
        if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_1X4) return WorldList.sprite_Wall_Wood_Top_1X4;
    	if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_3X1) return WorldList.sprite_Wall_Wood_Top_3X1;
    	if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_3X3) return WorldList.sprite_Wall_Wood_Top_3X3;
    	if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_3X4) return WorldList.sprite_Wall_Wood_Top_3X4;
    	if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_4X1) return WorldList.sprite_Wall_Wood_Top_4X1;
    	if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_4X2) return WorldList.sprite_Wall_Wood_Top_4X2;
    	if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_4X3) return WorldList.sprite_Wall_Wood_Top_4X3;
    	if (WorldMaker.shared().mapStructures[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD_TOP_4X4) {
    		return WorldList.sprite_Wall_Wood_Top_4X4;
	    */
	}
	
	public Sprite getResourcesSprite(int x, int y) {
		if (x < 0 || y < 0 || x >= WorldMaker.shared().width || y >= WorldMaker.shared().height) return WorldList.sprite_Void12_transparent;
		if (WorldMaker.shared().mapResources[x + y * WorldMaker.shared().width] == WorldList.COLOR_CONIFEROUS_BIG) return WorldList.sprite_Coniferous_Big;
		if (WorldMaker.shared().mapResources[x + y * WorldMaker.shared().width] == WorldList.COLOR_CONIFEROUS_SMALL) return WorldList.sprite_Coniferous_Small;
		if (WorldMaker.shared().mapResources[x + y * WorldMaker.shared().width] == WorldList.COLOR_HARDWOOD_BIG) return WorldList.sprite_Hardwood_Big;
		if (WorldMaker.shared().mapResources[x + y * WorldMaker.shared().width] == WorldList.COLOR_HARDWOOD_SMALL) return WorldList.sprite_Hardwood_Small;
		if (WorldMaker.shared().mapResources[x + y * WorldMaker.shared().width] == WorldList.COLOR_BUSH_BIG) return WorldList.sprite_Bush_Big;
		if (WorldMaker.shared().mapResources[x + y * WorldMaker.shared().width] == WorldList.COLOR_BUSH_SMALL) {
			return WorldList.sprite_Bush_Small; 
		} else {
			return WorldList.sprite_Void12_transparent;
		}
		
	}

	public void tickGenerateMonster() {
		time++;
		if (time == 3600) {
            time = 0;
        } else if (time == 120) {
            WorldMaker.shared().createEspirito(ControlRoom.STARTING_X - 200, ControlRoom.STARTING_Y - 200, 4, 2, 1, 1);
        } else if (time == 60) {
           WorldMaker.shared().createZombie(ControlRoom.STARTING_X + 20, ControlRoom.STARTING_Y + 20, 4, 1, 1, 1);
        } else if (time == 360) {
           WorldMaker.shared().createLarvion(ControlRoom.STARTING_X + 40, ControlRoom.STARTING_Y + 40, 4, 3, 1, 1);

        }  else if (time == 240) {
            WorldMaker.shared().createBichette(ControlRoom.STARTING_X + 75, ControlRoom.STARTING_Y + 75, 4, 4, 1, 1);
        }

		
	}
}