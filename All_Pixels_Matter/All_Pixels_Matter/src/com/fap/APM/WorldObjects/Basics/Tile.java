package com.fap.APM.WorldObjects.Basics;
import com.fap.APM.Graphics.Sprite;

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