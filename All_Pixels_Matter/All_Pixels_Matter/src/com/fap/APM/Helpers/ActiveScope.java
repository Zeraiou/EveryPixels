package com.fap.APM.Helpers;

public class ActiveScope {

    int centerX, centerY;
    int pixelToTileOffsetX, pixelToTileOffsetY;
    int width, height;
    int topX, topY;
    int topTileX, topTileY;

    public void ActiveScope(int posX, int posY, int width, int height) {
        this.centerX = posX;
        this.centerY = posY;
        this.width = width;
        this.height = height;
        findCurrentTileAndOffset();
        findCurrentScope();
        fillListsFromScope();
    }

    private void findCurrentTileAndOffset() {

    }

    private void findCurrentScope() {

    }

    private void fillListsFromScope() {

    }
}
