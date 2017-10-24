package com.fap.APM.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {

	public int width, height, totalPx;
	public int[] pixelsSpriteSheet;
	private String path;
	
	private Sprite[] sprites;

	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.width = width;
		this.height = height;
		this.totalPx = this.width * this.height;
		this.pixelsSpriteSheet = new int[totalPx];

		loadSpriteSheet();
	}
	
	public SpriteSheet(SpriteSheet spriteSheet, int x, int y, int widthAmountSprite, int heightAmountSprite, int widthSprite, int heightSprite) {
			
		int xx = x * widthSprite;
		int yy = y * heightSprite;
		int w = this.width =  widthAmountSprite * widthSprite;
		int h = this.height = heightAmountSprite * heightSprite;
		
		
		pixelsSpriteSheet = new int[w * h];
		
		for (int y0 = 0; y0 < h; y0++) {
			int yPosition = yy + y0;
			for (int x0 = 0; x0 < w; x0++) {
				int xPosition = xx + x0;
				
				pixelsSpriteSheet[x0 + y0 * w] = spriteSheet.pixelsSpriteSheet[xPosition + yPosition * spriteSheet.width];
								
			}
		}
		int frame = 0;
		sprites = new Sprite[widthAmountSprite * heightAmountSprite];
		for (int yAbsolu = 0; yAbsolu < heightAmountSprite; yAbsolu++) {
			for (int xAbsolu = 0; xAbsolu < widthAmountSprite; xAbsolu++) {
				int[] pixelsSprite = new int[widthSprite * heightSprite];
				for (int y1 = 0; y1 < heightSprite; y1++) {
					for (int x1 = 0; x1 < widthSprite; x1++) {
			 
						pixelsSprite[x1 + y1 * widthSprite] = pixelsSpriteSheet[(x1 + xAbsolu * widthSprite) + (y1 + yAbsolu * heightSprite) * width];
											
					}
				}	 
				Sprite sprite = new Sprite(pixelsSprite, widthSprite, heightSprite);	
				sprites[frame++] = sprite;
			}
		}

		
	}
	
	private void loadSpriteSheet() {
		try {
			//System.out.println("Chargement" + path);
			BufferedImage imageSpriteSheet = ImageIO.read(SpriteSheet.class.getResource(path));
			System.out.println("Reussi" + path);
			imageSpriteSheet.getRGB(0, 0, imageSpriteSheet.getWidth(), imageSpriteSheet.getHeight(), pixelsSpriteSheet, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
				System.err.println("Rater" + path);
		}
	}
	
	public Sprite[] getSprites() {
		return sprites;
	}
}