package com.fap.APM.Graphics;

import java.util.Random;

import com.fap.APM.Graphics.SpriteSheet.Sprite;
import com.fap.APM.Units.Creature;
import com.fap.APM.World.Tiles.Tile;

public class ScreenDisplay {

	 public int widthScreen;
	 public int heightScreen;
	 public int[] pixelsScreen; 
	 
	 public static final int WIDTH_TILE = 12;
	 public static final int HEIGHT_TILE = 12;
	
	 
	 public int xOffset;
	 public int yOffset;
	 
	 
	 private final int COLOR_NULL1 = 0xffFF00FF;
	 private final int COLOR_NULL2 = 0xff7f007f;
		
	 
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

	 public int getWidthTile() {
		 return WIDTH_TILE;
	 }
	 
	 public int getHeightTile() {
		 return HEIGHT_TILE;
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
				if (xAbsolu < - 12 || xAbsolu >= widthScreen || yAbsolu < 0 || yAbsolu >= heightScreen) break;
				if (xAbsolu < 0) xAbsolu = 0;
				
				pixelsScreen[xAbsolu + yAbsolu * widthScreen] = tile.sprite.pixelsSprite[x + y * tile.sprite.WIDTH_SPRITE];
			}
		}
	}
	
	public void renderCreature(int xPosition, int yPosition, Sprite sprite) {
		xPosition -= xOffset;
		yPosition -= yOffset;
			
		for (int y = 0; y < sprite.getHeightSprite(); y++) {
			int yDestination = y + yPosition;
			
			for (int x = 0; x < sprite.getWidthSprite(); x++) {
				int xDestination = x + xPosition;
				if (xDestination < - sprite.getWidthSprite() || xDestination >= widthScreen || yDestination < 0 || yDestination >= heightScreen) break;
				if (xDestination < 0) xDestination = 0;
				
				int color = sprite.pixelsSprite[x + y * sprite.getWidthSprite()];  
				
				if (color  != COLOR_NULL1) {
						pixelsScreen[xDestination + yDestination * widthScreen] = color;
				}
					
			}
				
		}
	}
	
	public void renderSprite(int xPosition, int yPosition, Sprite sprite, boolean fixed) {
		if (fixed) {
			xPosition -= xOffset;
			yPosition -= yOffset;
		}
		//	System.out.println("ici");
		for (int y = 0; y < sprite.getHeightSprite(); y++) {
			int yAbsolu = y + yPosition;
			for (int x = 0; x < sprite.getWidthSprite(); x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < 0 || xAbsolu >=  widthScreen || yAbsolu < 0 || yAbsolu >= widthScreen) continue;
				int color =  sprite.pixelsSprite[x + y * sprite.getWidthSprite()];
				if (color  != COLOR_NULL1 && color  != COLOR_NULL2) {
				pixelsScreen[xAbsolu + yAbsolu * widthScreen] = color;
				}
			}
		}
	}
}
