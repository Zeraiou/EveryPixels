package com.fap.APM.Graphics.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
//	public final int WIDTH_SPRITE, HEIGHT_SPRITE;
	public final int WIDTH_SPRITESHEET, HEIGHTSPRITESHEET;
	public int[] pixelsSpriteSheet;
	
	public static SpriteSheet tiles_Base12 = new SpriteSheet("/Textures/SpriteSheets/Tiles/TileBase12.png", 48, 36);
	
	
	public static SpriteSheet player_Base34 = new SpriteSheet("/Textures/SpriteSheets/Units/Player/Player_Base-3X4.png", 144, 192);
	
	
	public static SpriteSheet zombie_Base22 = new SpriteSheet("/Textures/SpriteSheets/Units/Monster/Zombie_Base-2X2.png", 96, 72);
	
	
	public SpriteSheet(String path, int widthSpriteSheet, int heightSpriteSheet) {
	this.path = path;
		this.WIDTH_SPRITESHEET = widthSpriteSheet;
		this.HEIGHTSPRITESHEET = heightSpriteSheet;
		pixelsSpriteSheet = new int[WIDTH_SPRITESHEET * HEIGHTSPRITESHEET];
		loadSpriteSheet();
	}
	
	
	private void loadSpriteSheet() {
		try {
			//System.out.println("Chargement" + path);
			BufferedImage imageSpriteSheet = ImageIO.read(SpriteSheet.class.getResource(path));
			//System.out.println("Reussi" + path);
			
			int w  = imageSpriteSheet.getWidth();
			int h = imageSpriteSheet.getHeight();
			imageSpriteSheet.getRGB(0, 0, w, h, pixelsSpriteSheet, 0, WIDTH_SPRITESHEET);
		} 	catch (IOException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
			//	System.err.println("Rater" + path);
			}
	
	}
}


