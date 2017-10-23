package com.fap.APM.World;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.fap.APM.ControlRoom;
import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Units.Entity;
import com.fap.APM.Units.GeneratorParticle;
import com.fap.APM.Units.GeneratorZombie;
import com.fap.APM.Units.Particle;
import com.fap.APM.Units.Player;
import com.fap.APM.Units.Zombie;

public class Map {


	private int width, height, totalTiles;
    private int[] mapTiles;
	
	public Map(String path) {
		extractFromFile(path);
		generationEntity();
	}

	private void extractFromFile(String path) {
		try {
            BufferedImage imageFromFile = ImageIO.read(Map.class.getResource(path));
            int w = width = imageFromFile.getWidth();
            int h = height = imageFromFile.getHeight();
            this.totalTiles = this.width * this.height;
            this.mapTiles = new int[this.totalTiles];

        	imageFromFile.getRGB(0, 0, w, h, mapTiles, 0, width);
        	
        	/*
        	System.out.println("largeur map : " + widthMap);
        	System.out.println("hauteur map : " + heightMap);
        	System.out.println("Quantite totalTiles : " + totalTiles);
			*/
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
	
	public Tile getMapTiles(int x, int y) {
		//System.out.println(mapTiles[1] + "++++++2222+++++++++++++");
		//System.out.println(TileMaker.COLOR_ROCK + "++++++color+++++++++++++");
		
		if (x < 0 || y < 0 || x >= width || y >= height) return TileMaker.tile_Void_Out;
		//if (x == 1 && y == 0) System.out.println("ici");
		//if (x == 1 && y == 0) System.out.println(x + y * width);
		if (mapTiles[x + y * width] == TileMaker.COLOR_GRASS) return TileMaker.tile_Grass;
		if (mapTiles[x + y * width] == TileMaker.COLOR_ROCK) return TileMaker.tile_Rock;
		if (mapTiles[x + y * width] == TileMaker.COLOR_WATER) return TileMaker.tile_Water;
		if (mapTiles[x + y * width] == TileMaker.COLOR_SAND) return TileMaker.tile_Sand;
		if (mapTiles[x + y * width] == TileMaker.COLOR_FLOOR_WOOD) return TileMaker.tile_Floor_Wood;
		if (mapTiles[x + y * width] == TileMaker.COLOR_WALL_WOOD) return TileMaker.tile_Wall_Wood;
		if (mapTiles[x + y * width] == TileMaker.COLOR_WALL_ROCK) return TileMaker.tile_Wall_Rock;
		if (mapTiles[x + y * width] == TileMaker.COLOR_FLOOR_ROCK) return TileMaker.tile_Floor_Rock;
		if (mapTiles[x + y * width] == TileMaker.COLOR_ICE) return TileMaker.tile_Ice;
		if (mapTiles[x + y * width] == TileMaker.COLOR_SNOW) return TileMaker.tile_Snow;
		if (mapTiles[x + y * width] == TileMaker.COLOR_LAVA) return TileMaker.tile_Lava;
		if (mapTiles[x + y * width] == TileMaker.COLOR_DIRT) {
			return TileMaker.tile_Dirt;
		}
		else {
			return TileMaker.tile_Void_In;
		}
	}
	
	public void addEntity(Entity entity) {
        entity.initialiseMap(this);

        if (entity instanceof Player) {
            WorldMaker.players.add((Player) entity);
        } else if (entity instanceof Zombie) {
			WorldMaker.monsters.add((Zombie) entity);
		} else if (entity instanceof Particle) {
			WorldMaker.particles.add((Particle) entity);
		} else {
            WorldMaker.entities.add(entity);
        }
	}
	
	public void tickMap() {
		//System.out.println("entities : " + entities.size());
		//System.out.println("players : " + players.size());
		//System.out.println("particules : " + particles.size());

		for (int i = 0; i < WorldMaker.players.size(); i++) {
			WorldMaker.players.get(i).tickEntity();
		}
		for (int i = 0; i < WorldMaker.monsters.size(); i++) {
			WorldMaker.monsters.get(i).tickEntity();
		}
		for (int i = 0; i < WorldMaker.particles.size(); i++) {
			WorldMaker.particles.get(i).tickEntity();
		}
		for (int i = 0; i < WorldMaker.entities.size(); i++) {
			WorldMaker.entities.get(i).tickEntity();
		}
		
		removeEntity();
	}


	private void removeEntity() {
		for (int i = 0; i < WorldMaker.players.size(); i++) {
			if (WorldMaker.players.get(i).getIsRemoved()) {
				WorldMaker.players.remove(i);
			}
		}

		for (int i = 0; i < WorldMaker.monsters.size(); i++) {
			if (WorldMaker.monsters.get(i).getIsRemoved()) WorldMaker.monsters.remove(i);
		}

		for (int i = 0; i < WorldMaker.particles.size(); i++) {
			if (WorldMaker.particles.get(i).getIsRemoved()) WorldMaker.particles.remove(i);
		}

		for (int i = 0; i < WorldMaker.entities.size(); i++) {
			if (WorldMaker.entities.get(i).getIsRemoved()) WorldMaker.entities.remove(i);
		}
	}

	private void generationEntity() {
		addEntity(new GeneratorZombie(65*12, 65*12, 4, this));
		addEntity(new GeneratorZombie(54*12, 67*12, 4, this));
		addEntity(new GeneratorZombie(78*12, 65*12, 4, this));
		addEntity(new GeneratorZombie(65*12, 78*12, 4, this));

		addEntity(new GeneratorParticle(70*12, 70*12, 5000, 500, this));

		
	
	}

	public void renderMap(int xOffset, int yOffset, ScreenDisplay screen) {
		screen.setOffset(xOffset, yOffset);
		
		int x0 = (xOffset - ControlRoom.WIDTH_TILE) / ControlRoom.WIDTH_TILE;
		int x1 = (xOffset + screen.screenWidth + ControlRoom.WIDTH_TILE) / ControlRoom.WIDTH_TILE;
		int y0 = (yOffset - ControlRoom.HEIGHT_TILE) / ControlRoom.HEIGHT_TILE;
		int y1 = (yOffset + screen.screenHeight + ControlRoom.HEIGHT_TILE) / ControlRoom.WIDTH_TILE;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x <x1; x++) {
				getMapTiles(x, y).renderTile(x, y, screen);
			}
		}

		drawPlayers(screen);

		drawMonsters(screen);

		drawParticles(screen);

		drawEntities(screen);

		// Todo: renderWall, renderRessources, renderEntities(player, monster, item), renderProjectiles, render Particles, renderEffect
	}

	private void drawPlayers(ScreenDisplay screen) {
		for (int i = 0; i < WorldMaker.players.size(); i++) {
			WorldMaker.players.get(i).renderEntity(screen);
		}
	}

	private void drawMonsters(ScreenDisplay screen) {
		for (int i = 0; i < WorldMaker.monsters.size(); i++) {
			WorldMaker.monsters.get(i).renderEntity(screen);
		}
	}

	private void drawParticles(ScreenDisplay screen) {
		for (int i = 0; i < WorldMaker.particles.size(); i++) {
			WorldMaker.particles.get(i).renderEntity(screen);
		}
	}

	private void drawEntities(ScreenDisplay screen) {
		for (int i = 0; i < WorldMaker.entities.size(); i++) {
			WorldMaker.entities.get(i).renderEntity(screen);
		}
	}
}