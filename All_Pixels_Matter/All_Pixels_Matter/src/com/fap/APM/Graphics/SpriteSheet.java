package com.fap.APM.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {

	public int width, height, totalPx;
	public int[] pixelsSpriteSheet;
	private String path;

	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.width = width;
		this.height = height;
		this.totalPx = this.width * this.height;
		this.pixelsSpriteSheet = new int[totalPx];

		loadSpriteSheet();
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
}