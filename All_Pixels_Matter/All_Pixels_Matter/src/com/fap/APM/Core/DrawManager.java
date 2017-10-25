package com.fap.APM.Core;
import com.fap.APM.Graphics.Sprite;
import com.fap.APM.WorldObjects.Basics.Tile;
import com.fap.APM.WorldObjects.WorldList;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class DrawManager {

    private BufferedImage imageInFrame = new BufferedImage(ControlRoom.SCREEN_WIDTH, ControlRoom.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();

    private static DrawManager INSTANCE = null;
    public int screenWidth, screenHeight, totalPixels, screenCenterX, screenCenterY;
    public int tileWidth, tileHeight, totalTiles;
    private int offsetX, offsetY;
    public int[] pixelsScreen;

    private DrawManager() {
        screenWidth = ControlRoom.SCREEN_WIDTH;
        screenHeight = ControlRoom.SCREEN_HEIGHT;
        totalPixels = screenWidth * screenHeight;
        pixelsScreen = new int[totalPixels];

        tileWidth = ControlRoom.TILE_WIDTH;
        tileHeight = ControlRoom.TILE_HEIGHT;
        totalTiles = tileWidth * tileHeight;

        screenCenterX = ControlRoom.SCREEN_CENTER_X;
        screenCenterY = ControlRoom.SCREEN_CENTER_Y;
    }  // Private Constructor

    public static DrawManager shared() {
        if (INSTANCE == null) {
            INSTANCE = new DrawManager();
        }
        return INSTANCE;
    }

    public void renderScreen() {

        pixelsScreen = new int[totalPixels];
        this.offsetX = (int)(WorldList.players.get(0).posX - screenCenterX);
        this.offsetY = (int)(WorldList.players.get(0).posY - screenCenterY);

        if (ControlRoom.RENDER_SCREEN_OUT) {
            System.out.println("Total Screen Pixels:" + totalPixels + " - OffSetX: " + offsetX + ", OffsetY: " + offsetX);
        }

        drawTiles();
        drawPlayers();
        drawMonsters();
        drawParticles();
    }

    private  void drawTiles() {
        int x0 = (offsetX - tileWidth) / tileWidth;
        int x1 = (offsetX + screenWidth + tileWidth) / tileWidth;
        int y0 = (offsetY - tileHeight) / tileHeight;
        int y1 = (offsetY + screenHeight + tileHeight) / tileHeight;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x <x1; x++) {

                Tile tile = getMapFieldTiles(x, y);
                int posX = (x * tileWidth) - offsetX;
                int posY = (y * tileHeight) - offsetY;

                for (int i = 0; i < tileHeight; i++) {
                    int yAbsolu = i + posY;

                    for (int j = 0; j < tileWidth; j++) {
                        int xAbsolu = j + posX;

                        if (xAbsolu < - tileWidth || xAbsolu >= screenWidth || yAbsolu < 0 || yAbsolu >= screenHeight) {
                            break;
                        } else if (xAbsolu < 0) {
                            xAbsolu = 0;
                        }

                        pixelsScreen[xAbsolu + yAbsolu * screenWidth] = tile.sprite.pixelsSprite[j + i * tileWidth];
                    }
                }
            }
        }
    }

    private void drawPlayers() {
        for (int i = 0; i < WorldList.players.size(); i++) {

            int posX = (int)WorldList.players.get(i).posX - offsetX;
            int posY = (int)WorldList.players.get(i).posY - offsetY;
            Sprite sprite = WorldList.players.get(i).sprite.getSprite();

            for (int y = 0; y < sprite.height; y++) {
                int yDestination = y + posY;

                for (int x = 0; x < sprite.width; x++) {
                    int xDestination = x + posX;
                    if (xDestination < - sprite.width || xDestination >= screenWidth || yDestination < 0 || yDestination >= screenHeight){
                        break;
                    } else if (xDestination < 0){
                        xDestination = 0;
                    }

                    if (sprite.pixelsSprite[x + y * sprite.width] != WorldList.COLOR_NULL1) {
                        pixelsScreen[xDestination + yDestination * screenWidth] = sprite.pixelsSprite[x + y * sprite.width];
                    }
                }
            }

        }
    }

    private void drawMonsters() {
        for (int i = 0; i < WorldList.monsters.size(); i++) {
            int posX = (int)WorldList.monsters.get(i).posX - offsetX;
            int posY = (int)WorldList.monsters.get(i).posY - offsetY;
            Sprite sprite = WorldList.monsters.get(i).sprite.getSprite();

            for (int y = 0; y < sprite.height; y++) {
                int yDestination = y + posY;

                for (int x = 0; x < sprite.width; x++) {
                    int xDestination = x + posX;
                    if (xDestination < - sprite.width || xDestination >= screenWidth || yDestination < 0 || yDestination >= screenHeight){
                        break;
                    } else if (xDestination < 0){
                        xDestination = 0;
                    }

                    if (sprite.pixelsSprite[x + y * sprite.width] != WorldList.COLOR_NULL1) {
                        pixelsScreen[xDestination + yDestination * screenWidth] = sprite.pixelsSprite[x + y * sprite.width];
                    }
                }
            }
        }
    }

    private void drawParticles() {
        for (int i = 0; i < WorldList.particles.size(); i++) {
            //WorldList.particles.get(i).renderEntity(screen);
            int xPrecisionParticle = 0, yPrecisionParticle = 0;
            int xPrecisionParticleCollision = 0, yPrecisionParticleCollision = 0;

            //screen.renderSprite(((int) xEntityDouble) - xPrecisionParticle - xPrecisionParticleCollision, ((int)yEntityDouble) - yPrecisionParticle - yPrecisionParticleCollision - (int) zEntityDouble, spriteParticle, true);

//            public void renderSprite(int xPosition, int yPosition, Sprite sprite, boolean fixed) {
//                if (fixed) {
//                    xPosition -= xOffset;
//                    yPosition -= yOffset;
//                }
//                //	System.out.println("ici");
//                for (int y = 0; y < sprite.height; y++) {
//                    int yAbsolu = y + yPosition;
//                    for (int x = 0; x < sprite.width; x++) {
//                        int xAbsolu = x + xPosition;
//                        if (xAbsolu < 0 || xAbsolu >=  screenWidth || yAbsolu < 0 || yAbsolu >= screenHeight) {
//                            continue;
//                        }
//
//                        int color =  sprite.pixelsSprite[x + y * sprite.width];
//
//                        if (color  != COLOR_NULL1 && color != COLOR_NULL2) {
//                            pixelsScreen[xAbsolu + yAbsolu * screenWidth] = color;
//                        }
//                    }
//                }
//            }
        }
    }

    public Tile getMapFieldTiles(int x, int y) {
        if (x < 0 || y < 0 || x >= WorldMaker.shared().width || y >= WorldMaker.shared().height) return WorldList.tile_Void_Out;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_GRASS) return WorldList.tile_Grass;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_ROCK) return WorldList.tile_Rock;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_WATER) return WorldList.tile_Water;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_SAND) return WorldList.tile_Sand;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_FLOOR_WOOD) return WorldList.tile_Floor_Wood;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_WOOD) return WorldList.tile_Wall_Wood;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_WALL_ROCK) return WorldList.tile_Wall_Rock;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_FLOOR_ROCK) return WorldList.tile_Floor_Rock;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_ICE) return WorldList.tile_Ice;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_SNOW) return WorldList.tile_Snow;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_LAVA) return WorldList.tile_Lava;
        if (WorldMaker.shared().mapFieldTiles[x + y * WorldMaker.shared().width] == WorldList.COLOR_DIRT) {
            return WorldList.tile_Dirt;
        } else {
            return WorldList.tile_Void_In;
        }
    }
}