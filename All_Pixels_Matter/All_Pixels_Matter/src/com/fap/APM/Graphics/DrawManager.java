package com.fap.APM.Graphics;
import com.fap.APM.ControlRoom;
import com.fap.APM.Objects.Tile;
import com.fap.APM.World.TileMaker;
import com.fap.APM.World.WorldList;
import com.fap.APM.World.WorldMaker;;
import static com.fap.APM.ControlRoom.SCREEN_WIDTH;

public class DrawManager {

    private static DrawManager INSTANCE = null;
    private ScreenDisplay screen;

    private DrawManager() {}     // Private Init.

    public static DrawManager shared() {
        if (INSTANCE == null) {
            INSTANCE = new DrawManager();
        }
        return INSTANCE;
    }

    public void renderMap(int xOffset, int yOffset, ScreenDisplay screen) {
        screen.setOffset(xOffset, yOffset);
        this.screen = screen;

        drawTiles(xOffset, yOffset);
        drawPlayers();
        drawMonsters();
        drawParticles();
        drawEntities();

        // Todo: renderWall, renderRessources, renderEntities(player, monster, item), renderProjectiles, render Particles, renderEffect
    }

    private  void drawTiles(int offsetX, int offsetY) {
        int x0 = (offsetX - ControlRoom.WIDTH_TILE) / ControlRoom.WIDTH_TILE;
        int x1 = (offsetX + ControlRoom.SCREEN_WIDTH + ControlRoom.WIDTH_TILE) / ControlRoom.WIDTH_TILE;
        int y0 = (offsetY - ControlRoom.HEIGHT_TILE) / ControlRoom.HEIGHT_TILE;
        int y1 = (offsetY + ControlRoom.SCREEN_HEIGHT + ControlRoom.HEIGHT_TILE) / ControlRoom.HEIGHT_TILE;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x <x1; x++) {
                getMapFieldTiles(x, y).renderTile(x, y, screen);
            }
        }
    }

    private void drawPlayers() {
        for (int i = 0; i < WorldList.players.size(); i++) {
            WorldList.players.get(i).renderEntity(screen);
        }
    }

    private void drawMonsters() {
        for (int i = 0; i < WorldList.monsters.size(); i++) {
            WorldList.monsters.get(i).renderEntity(screen);
        }
    }

    private void drawParticles() {
        for (int i = 0; i < WorldList.particles.size(); i++) {
            WorldList.particles.get(i).renderEntity(screen);
        }
    }

    private void drawEntities() {
        for (int i = 0; i < WorldList.entities.size(); i++) {
            WorldList.entities.get(i).renderEntity(screen);
        }
    }

    public Tile getMapFieldTiles(int x, int y) {
        if (x < 0 || y < 0 || x >= WorldMaker.shared().width || y >= WorldMaker.shared().height) return TileMaker.tile_Void_Out;
        //if (x == 1 && y == 0) System.out.println("ici");
        //if (x == 1 && y == 0) System.out.println(x + y * WorldMaker.shared().width);
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_GRASS) return TileMaker.tile_Grass;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_ROCK) return TileMaker.tile_Rock;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_WATER) return TileMaker.tile_Water;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_SAND) return TileMaker.tile_Sand;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_FLOOR_WOOD) return TileMaker.tile_Floor_Wood;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_WALL_WOOD) return TileMaker.tile_Wall_Wood;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_WALL_ROCK) return TileMaker.tile_Wall_Rock;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_FLOOR_ROCK) return TileMaker.tile_Floor_Rock;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_ICE) return TileMaker.tile_Ice;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_SNOW) return TileMaker.tile_Snow;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_LAVA) return TileMaker.tile_Lava;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == TileMaker.COLOR_DIRT) {
            return TileMaker.tile_Dirt;
        } else {
            return TileMaker.tile_Void_In;
        }
    }
}
