package com.fap.APM.World;
import com.fap.APM.ControlRoom;
import com.fap.APM.Input.Keyboard;
import com.fap.APM.Units.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WorldMaker {

    public int width, height, totalTiles;
    public int[] mapFieldTiles;

    private static WorldMaker INSTANCE = null;

    private WorldMaker() {}     // Private Init.

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
                System.out.println("Width: " + width + " - Height: " + height + " - TotalTiles: " + totalTiles + " - Array Size: " + mapFieldTiles.length + "\n");
            }
        } catch (IOException e) {
            if (ControlRoom.PIXEL_TILE_LOAD_OUT) {
                System.out.println("ERROR -- extractMapField() Failed! \n");
            }
        }
    }

    public void createPlayer(String name, Keyboard keyboard) {
        Player player = new Player(ControlRoom.STARTING_X, ControlRoom.STARTING_Y, keyboard);

        WorldList.players.add(player);
    }

    public void addEntity(Entity entity) {
//        entity.initialiseMap(this);
//
//        if (entity instanceof Player) {
//            WorldList.players.add((Player) entity);
//        } else if (entity instanceof Zombie) {
//            WorldList.monsters.add((Zombie) entity);
//        } else if (entity instanceof Particle) {
//            WorldList.particles.add((Particle) entity);
//        } else {
//            WorldList.entities.add(entity);
//        }
    }

    public void removeEntity() {
        for (int i = 0; i < WorldList.players.size(); i++) {
            if (WorldList.players.get(i).getIsRemoved()) {
                WorldList.players.remove(i);
            }
        }

        for (int i = 0; i < WorldList.monsters.size(); i++) {
            if (WorldList.monsters.get(i).getIsRemoved()) {
                WorldList.monsters.remove(i);
            }
        }

        for (int i = 0; i < WorldList.particles.size(); i++) {
            if (WorldList.particles.get(i).getIsRemoved()) {
                WorldList.particles.remove(i);
            }
        }

        for (int i = 0; i < WorldList.entities.size(); i++) {
            if (WorldList.entities.get(i).getIsRemoved()) {
                WorldList.entities.remove(i);
            }
        }
    }
}