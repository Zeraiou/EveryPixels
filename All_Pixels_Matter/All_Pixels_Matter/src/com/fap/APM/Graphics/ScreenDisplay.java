package com.fap.APM.Graphics;

import java.util.Random;

import com.fap.APM.World.Tiles.Tile;

public class ScreenDisplay {

	 public int widthScreen;
	 public int heightScreen;
	 public int[] pixelsScreen; 
	 
	 public int widthTile = 12;
	 public int heightTile = 12;
	
	 
	 public int xOffset;
	 public int yOffset;
	 
	 
	 //public int widthLevel = 64;
	// public int heightLevel = 64;
	// public int amountOfTilesInLevels = widthLevel * heightLevel;
    // public int maskWidthTile = widthLevel - 1;
    // public int maskHeightTile = heightLevel - 1;
	 
     /*
	 public int[] tiles = new int[widthLevel * heightLevel];
	 private Random randomRoll = new Random();
	*/
	 
	 public ScreenDisplay(int widthScreen, int heightScreen) {
	        this.widthScreen = widthScreen;
	        this.heightScreen = heightScreen;

	        pixelsScreen = new int[widthScreen * heightScreen];
	        
	        /*
	        for (int i = 0; i < amountOfTilesInLevels; i++) {
	        	tiles[i] = randomRoll.nextInt(0xffffff);
	        }*/
	     
	 }
	 
	 public void setOffset(int xOffset, int yOffset) {
	        this.xOffset = xOffset;
	        this.yOffset = yOffset;
	    }

	 
	 public void clearScreen() {
	        for (int i = 0; i < pixelsScreen.length; i++) {
	            pixelsScreen[i] = 0;
	        }
	    }
	 
	 
	 public void renderScreen(int xOffset, int yOffset) {
		
		/* 
		 for (int y = 0; y < heightScreen; y++) {
			 int yPosition = y + yOffset;
			 if (yPosition < 0 || yPosition >= heightScreen) continue;
			 for (int x = 0; x < widthScreen; x++) {
				int xPosition = x + xOffset;
				if (xPosition < 0 || xPosition >= widthScreen) continue;
				 
				 // int tileIndex = ((xPosition / 16) & maskWidthTile) + (((yPosition / 16) & maskHeightTile) * widthLevel);
				
				pixelsScreen[xPosition + (yPosition * widthScreen)] = Sprite.tile_Grass8.pixelsSprite[(x & 7) + (y & 7) * Sprite.tile_Grass8.getWidthSprite() ];
				//  pixelsScreen[xPosition + (yPosition * widthScreen)] = Sprite.grass10.pixelsSprite[(x & 9) + (y & 9) * Sprite.grass10.getWidthSprite() ];
				//	pixelsScreen[xPosition + (yPosition * widthScreen)] = Sprite.grass12.pixelsSprite[(x & 11) + (y & 11) * Sprite.grass12.getWidthSprite() ];
				//	pixelsScreen[xPosition + ((yPosition) * widthScreen)] = Sprite.grass16.pixelsSprite[(x & 15) + (y & 15) * Sprite.grass16.getWidthSprite() ];
				//  pixelsScreen[xPosition + (yPosition * widthScreen)] = Sprite.grass32.pixelsSprite[(x & 31) + (y & 31) * Sprite.grass32.getWidthSprite() ];
				//  pixelsScreen[xPosition + ((yPosition) * widthScreen)] = Sprite.grass64.pixelsSprite[(x & 63) + (y & 63) * Sprite.grass64.getWidthSprite() ];
				//  pixelsScreen[xPosition + (yPosition * widthScreen)] = tiles[tileIndex];
					
			 }
		 }*/
	 }

	public void renderTile(int xPosition, int yPosition, Tile tile) {
		xPosition -= xOffset;
		yPosition -= yOffset;
		   //System.out.println("xPosition : " + xPosition);
		   //System.out.println("yPosition : " + yPosition);
		    	
		for (int y = 0; y < tile.sprite.HEIGHT_SPRITE; y++) {
			int yAbsolu = y + yPosition;
			
			for (int x = 0; x < tile.sprite.WIDTH_SPRITE; x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < - 8 || xAbsolu >= widthScreen || yAbsolu < 0 || yAbsolu >= heightScreen) break;
				if (xAbsolu < 0) xAbsolu = 0;
				
				pixelsScreen[xAbsolu + yAbsolu * widthScreen] = tile.sprite.pixelsSprite[x + y * tile.sprite.WIDTH_SPRITE];
			}
		}
	}
}
