package com.fap.APM.Objects;
import com.fap.APM.ControlRoom;
import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Graphics.Sprite;

public class Tile {

	//Todo: Group enum: tile, walls, etc
	public int x, y;
    public int phyState;
	public Sprite sprite;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void renderTile(int x, int y, ScreenDisplay screen) {
		screen.renderTile(x * ControlRoom.WIDTH_TILE, y * ControlRoom.HEIGHT_TILE, this);
	}

	public boolean solid() {
		return false;
	}
}