package com.fap.APM.Core;
import com.fap.APM.WorldObjects.Units.*;
import com.fap.APM.WorldObjects.WorldList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WorldMaker {

    public int width, height, totalTiles;
    public int[] mapFieldTiles;
    private static WorldMaker INSTANCE = null;

    private WorldMaker() { }

    public static WorldMaker shared() {
        if (INSTANCE == null) {
            INSTANCE = new WorldMaker();
            INSTANCE.extractMapField();
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
    /*
    private void extractMapStructure() {
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
    */
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

    public void createZombie() {
        Monster monster = new Monster(ControlRoom.STARTING_X + 20, ControlRoom.STARTING_Y + 20);

        WorldList.monsters.add(monster);
    }
    
    public void createEspirito() {
        Espirito espirito = new Espirito(ControlRoom.STARTING_X + 50, ControlRoom.STARTING_Y + 50);

        WorldList.espiritos.add(espirito);
    }

    public void removeEntity() {
        for (int i = 0; i < WorldList.monsters.size(); i++) {
            if (WorldList.monsters.get(i).isRemoved) {
                WorldList.monsters.remove(i);
            }
        }
        
        for (int i = 0; i < WorldList.espiritos.size(); i++) {
            if (WorldList.espiritos.get(i).isRemoved) {
                WorldList.espiritos.remove(i);
            }
        }

        for (int i = 0; i < WorldList.particles.size(); i++) {
            if (WorldList.particles.get(i).timeToLive <= 0) {
                WorldList.particles.remove(i);
            }
        }
    }
}