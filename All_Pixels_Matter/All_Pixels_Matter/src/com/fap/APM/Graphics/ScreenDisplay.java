package com.fap.APM.Graphics;
import com.fap.APM.World.*;

public class ScreenDisplay {

	 public int screenWidth, screenHeight, totalpx;
	 public int xOffset, yOffset;;
	 public int[] pixelsScreen;
	 private final int COLOR_NULL1 = 0xffFF00FF;
	 private final int COLOR_NULL2 = 0xff7f007f;

	 // public int widthLevel = 64;
     // public int heightLevel = 64;
	 // public int amountOfTilesInLevels = widthLevel * heightLevel;
     // public int maskWidthTile = widthLevel - 1;
     // public int maskHeightTile = heightLevel - 1;
     // public int[] tiles = new int[widthLevel * heightLevel];
     // private Random randomRoll = new Random();

	 public ScreenDisplay(int screenWidth, int screenHeight) {
	        this.screenWidth = screenWidth;
	        this.screenHeight = screenHeight;
            this.totalpx = this.screenWidth * this.screenHeight;
	        this.pixelsScreen = new int[this.totalpx];

//	        for (int i = 0; i < amountOfTilesInLevels; i++) {
//	        	tiles[i] = randomRoll.nextInt(0xffffff);
//	        }
	 }
	 
	 public void setOffset(int xOffset, int yOffset) {
         this.xOffset = xOffset;
         this.yOffset = yOffset;
     }

	 public void clearScreen() {
         for (int i = 0; i < totalpx; i++) {
             pixelsScreen[i] = 0;
         }
     }

	 public void renderScreen(int xOffset, int yOffset) {
		 for (int y = 0; y < screenHeight; y++) {
			 int yPosition = y + yOffset;
			 if (yPosition < 0 || yPosition >= screenHeight) continue;
			 for (int x = 0; x < screenWidth; x++) {
				int xPosition = x + xOffset;
				if (xPosition < 0 || xPosition >= screenWidth) continue;
					pixelsScreen[xPosition + (yPosition * screenWidth)] = TileMaker.tile_Grass12.pixelsSprite[(x & 11) + (y & 11) * TileMaker.tile_Grass12.width];
			 }
		 }
	 }

	public void renderTile(int xPosition, int yPosition, Tile tile) {
		xPosition -= xOffset;
		yPosition -= yOffset;
        //System.out.println("xPosition : " + xPosition);
        //System.out.println("yPosition : " + yPosition);
		    	
		for (int y = 0; y < tile.sprite.height; y++) {
			int yAbsolu = y + yPosition;
			
			for (int x = 0; x < tile.sprite.width; x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < - 12 || xAbsolu >= screenWidth || yAbsolu < 0 || yAbsolu >= screenHeight) break;
				if (xAbsolu < 0) xAbsolu = 0;
				
				pixelsScreen[xAbsolu + yAbsolu * screenWidth] = tile.sprite.pixelsSprite[x + y * tile.sprite.width];
			}
		}
	}
	
	public void renderCreature(int xPosition, int yPosition, Sprite sprite) {
		xPosition -= xOffset;
		yPosition -= yOffset;
			
		for (int y = 0; y < sprite.height; y++) {
			int yDestination = y + yPosition;
			
			for (int x = 0; x < sprite.width; x++) {
				int xDestination = x + xPosition;
				if (xDestination < - sprite.width || xDestination >= screenWidth || yDestination < 0 || yDestination >= screenHeight) break;
				if (xDestination < 0) xDestination = 0;
				
				int color = sprite.pixelsSprite[x + y * sprite.width];
				
				if (color != COLOR_NULL1) {
						pixelsScreen[xDestination + yDestination * screenWidth] = color;
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
		for (int y = 0; y < sprite.height; y++) {
			int yAbsolu = y + yPosition;
			for (int x = 0; x < sprite.width; x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < 0 || xAbsolu >=  screenWidth || yAbsolu < 0 || yAbsolu >= screenHeight) {
					continue;
				}
				int color =  sprite.pixelsSprite[x + y * sprite.width];
				if (color  != COLOR_NULL1 && color  != COLOR_NULL2) {
				pixelsScreen[xAbsolu + yAbsolu * screenWidth] = color;
				}
			}
		}
	}
}