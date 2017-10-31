package com.fap.APM.Graphics.Basics;
import com.fap.APM.Graphics.Sprites.Sprite;

public class Tile {

	public int x, y;
    public int phyState;
	public Sprite sprite;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public boolean solid() {
		return false;
	}
}