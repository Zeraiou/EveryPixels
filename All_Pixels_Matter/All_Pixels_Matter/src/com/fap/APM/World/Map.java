package com.fap.APM.World;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.World.Tiles.Tile;

public class Map {
	protected int widthMap, heightMap;
	public int xStatingPosition = 32;
	public int yStartingPosition = 32;
	
	
	
	private int[] mapTiles;
	
	//public static Map map = new Map("/Niveau/NiveauHUB.png");


	public Map(String path) {
		extractFromFile(path);
	}


	private void extractFromFile(String path) {
		try {
        	System.out.println(path);
            BufferedImage imageFromFile = ImageIO.read(Map.class.getResource(path));
            
            int w = widthMap = imageFromFile.getWidth();
            int h = heightMap = imageFromFile.getHeight();
            int totalMapTiles = widthMap * heightMap;
            mapTiles = new int[totalMapTiles];

        	imageFromFile.getRGB(0, 0, w, h, mapTiles, 0, widthMap);
        	
        	
        	System.out.println("largeur map : " + widthMap);
        	System.out.println("hauteur map : " + heightMap);
        	System.out.println("Quantite totalMapTiles : " + totalMapTiles);
			
        	/*
        	System.out.println(mapTiles[0] + "++++++1111++++++");
			System.out.println(mapTiles[1] + "++++++2222+++++++++++++");
			System.out.println(mapTiles[2] + "++++++3333++++++++++++++");
			System.out.println(mapTiles[3] + "++++++44444++++++++++++++");
			System.out.println(mapTiles[4] + "++++++5555++++++++++++++");
			System.out.println(mapTiles[5] + "++++++6666++++++++++++++");
			System.out.println(mapTiles[6] + "++++++1111++++++");
			System.out.println(mapTiles[7] + "++++++2222+++++++++++++");
			System.out.println(mapTiles[8] + "++++++3333++++++++++++++");
			System.out.println(mapTiles[9] + "++++++44444++++++++++++++");
			System.out.println(mapTiles[10] + "++++++44444++++++++++++++");
			
			System.out.println(mapTiles[11] + "++++++5555++++++++++++++");
			System.out.println(mapTiles[12] + "++++++6666++++++++++++++");
			System.out.println(mapTiles[13] + "++++++5555++++++++++++++");
			System.out.println(mapTiles[14] + "++++++6666++++++++++++++");
			System.out.println(mapTiles[15] + "++++++5555++++++++++++++");
			System.out.println(mapTiles[16] + "++++++6666++++++++++++++");
			*/


            
		} catch (IOException e) {
        
		}
		
	}
	
	public Tile getLevelTiles(int x, int y) {
		//System.out.println(mapTiles[1] + "++++++2222+++++++++++++");
		//System.out.println(Tile.COLOR_ROCK + "++++++color+++++++++++++");
		
		if (x < 0 || y < 0 || x >= widthMap || y >= heightMap) return Tile.tile_Void_Out;
		if (x == 1 && y == 0) System.out.println("ici");
		if (x == 1 && y == 0) System.out.println(x + y * widthMap);
		if (mapTiles[x + y * widthMap] == Tile.COLOR_GRASS) return Tile.tile_Grass;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_ROCK) return Tile.tile_Rock;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_WATER) return Tile.tile_Water;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_SAND) return Tile.tile_Sand;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_FLOOR_WOOD) return Tile.tile_Floor_Wood;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_WALL_WOOD) return Tile.tile_Wall_Wood;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_WALL_ROCK) return Tile.tile_Wall_Rock;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_FLOOR_ROCK) return Tile.tile_Floor_Rock;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_ICE) return Tile.tile_Ice;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_SNOW) return Tile.tile_Snow;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_LAVA) return Tile.tile_Lava;
		if (mapTiles[x + y * widthMap] == Tile.COLOR_DIRT) {
			return Tile.tile_Dirt;
		} else {
			return Tile.tile_Void_In;
		}
	}
	
	public void tickMap() {
		// tick des differentes List
	}
	
	public void renderMap(int xOffset, int yOffset, ScreenDisplay screen) {
		screen.setOffset(xOffset, yOffset);
		
		int x0 = (xOffset - screen.widthTile) / screen.widthTile;
		int x1 = (xOffset + screen.widthScreen + screen.widthTile) / screen.widthTile;
		int y0 = (yOffset - screen.heightTile) / screen.heightTile;
		int y1 = (yOffset + screen.heightScreen + screen.heightTile) / screen.widthTile;
		
		
		// renderTile
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x <x1; x++) {
				
				getLevelTiles(x, y).renderTile(x, y, screen);
			}
		}
		
		
		// renderWall
		// renderRessources
		// renderEntities(player, monster, item)
		// renderProjectiles
		// render Particles
		// renderEffects
		
	}
	
	
	
	
	
}