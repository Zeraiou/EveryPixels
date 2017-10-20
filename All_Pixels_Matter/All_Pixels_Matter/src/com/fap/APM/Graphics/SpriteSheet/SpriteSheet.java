package com.fap.APM.Graphics.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
//	public final int WIDTH_SPRITE, HEIGHT_SPRITE;
	public final int WIDTH_SPRITESHEET, HEIGHTSPRITESHEET;
	public int[] pixelsSpriteSheet;
	
	public static SpriteSheet tiles_Base8 = new SpriteSheet("/Textures/SpriteSheets/Tiles/TileBase8.png", 32, 24);
	public static SpriteSheet tiles_Base12 = new SpriteSheet("/Textures/SpriteSheets/Tiles/TileBase12.png", 48, 36);
	//public static SpriteSheet tiles_Base10 = new SpriteSheet("/Textures/SpriteSheets/Tiles/TileBase10.png", 40, 30);
	//public static SpriteSheet tiles_Base16 = new SpriteSheet("/Textures/SpriteSheets/Tiles/TileBase16.png", 64, 48);
	//public static SpriteSheet tiles_Base32 = new SpriteSheet("/Textures/SpriteSheets/Tiles/TileBase32.png", 128, 96);
	//public static SpriteSheet tiles_Base64 = new SpriteSheet("/Textures/SpriteSheets/Tiles/TileBase64.png", 256, 192);

	
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


