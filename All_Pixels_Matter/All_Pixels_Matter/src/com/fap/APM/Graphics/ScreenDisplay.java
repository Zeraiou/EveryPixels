package com.fap.APM.Graphics;

import java.util.Random;

import com.fap.APM.Graphics.SpriteSheet.Sprite;

public class ScreenDisplay {

	 public int widthScreen;
	 public int heightScreen;
	 public int[] pixelsScreen; 
	 
	 public int widthLevel = 12;
	 public int heightLevel = 12;
	 public int amountOfTilesInLevels = widthLevel * heightLevel;
     public int maskWidthTile = widthLevel - 1;
     public int maskHeightTile = heightLevel - 1;
	 

	 public int[] tiles = new int[widthLevel * heightLevel];
	 private Random randomRoll = new Random();

	 
	 public ScreenDisplay(int widthScreen, int heightScreen) {
	        this.widthScreen = widthScreen;
	        this.heightScreen = heightScreen;

	        pixelsScreen = new int[widthScreen * heightScreen];
	        
	        for (int i = 0; i < amountOfTilesInLevels; i++) {
	        	tiles[i] = randomRoll.nextInt(0xffffff);
	        }
	 }
	 
	 public void clearScreen() {
	        for (int i = 0; i < pixelsScreen.length; i++) {
	            pixelsScreen[i] = 0;
	        }
	    }
	 
	 
	 public void renderScreen(int xOffset, int yOffset) {
		
		 
		 for (int y = 0; y < heightScreen; y++) {
			 int yPosition = y + yOffset;
			 if (yPosition < 0 || yPosition >= heightScreen) continue;
			 for (int x = 0; x < widthScreen; x++) {
				int xPosition = x + xOffset;
				if (xPosition < 0 || xPosition >= widthScreen) continue;
				 
				 // int tileIndex = ((xx / 16) & maskWidthTile) + (((yy / 16) & maskHeightTile) * widthLevel);
				
				pixelsScreen[xPosition + (yPosition * widthScreen)] = Sprite.grass8.pixelsSprite[(x & 7) + (y & 7) * Sprite.grass8.getWidthSprite() ];
				//  pixelsScreen[xPosition + (yPosition * widthScreen)] = Sprite.grass10.pixelsSprite[(x & 9) + (y & 9) * Sprite.grass10.getWidthSprite() ];
				//	pixelsScreen[xPosition + (yPosition * widthScreen)] = Sprite.grass12.pixelsSprite[(x & 11) + (y & 11) * Sprite.grass12.getWidthSprite() ];
				//	pixelsScreen[xPosition + ((yPosition) * widthScreen)] = Sprite.grass16.pixelsSprite[(x & 15) + (y & 15) * Sprite.grass16.getWidthSprite() ];
				//  pixelsScreen[xPosition + (yPosition * widthScreen)] = Sprite.grass32.pixelsSprite[(x & 31) + (y & 31) * Sprite.grass32.getWidthSprite() ];
				//  pixelsScreen[xPosition + ((yPosition) * widthScreen)] = Sprite.grass64.pixelsSprite[(x & 63) + (y & 63) * Sprite.grass64.getWidthSprite() ];
			 }
		 }
	 }
}
