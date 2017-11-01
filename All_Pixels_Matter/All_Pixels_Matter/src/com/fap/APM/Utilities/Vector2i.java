package com.fap.APM.Utilities;

public class Vector2i {

	public int x, y;
	
	public Vector2i() {
		setXY(0,0);
	}
	
	public Vector2i(int x, int y) {
		setXY(x,y);
	}
	
	public Vector2i(Vector2i vector2i) {
		setXY(vector2i.x, vector2i.y);
	}
	
	public Vector2i addXY(int value) {
		this.x += value;
		this.y += value;
		return this;
	}
	
	public Vector2i addXY(Vector2i vector2i) {
		this.x += vector2i.x;
		this.y += vector2i.y;
		return this;
	}
	
	public int addX(int value) {
		this.x += value;
		return this.x;
	}
	
	public int addY(int value) {
		this.y += value;
		return this.y;
	}
	
	public Vector2i substractXY(Vector2i vector2i) {
		this.x -= vector2i.x;
		this.y -= vector2i.y;
		return this;
	}

	public int substractX(int value) {
		this.x -= value;
		return this.x;
	}
	
	public int substractY(int value) {
		this.y -= value;
		return this.y;
	}
		
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Vector2i setXY(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public int setX(int x) {
		this.x = x;
		return this.x;
		
	}

	public int setY(int y) {
		this.y = y;
		return this.y;
	}
	
	public static double getDistanceBetween2Vector2i(Vector2i vector2i_1, Vector2i vector2i_2) {
		double xDistance = vector2i_1.getX() - vector2i_2.getX();
		double yDistance = vector2i_1.getY() - vector2i_2.getY();
		return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
	}
	
	public boolean equals(Object object) {
		if (!(object instanceof Vector2i)) return false;
		Vector2i vec = (Vector2i) object;
		if (vec.getX() == this.getX() && vec.getY() == this.getY()) return true;
		return false;
	}
}
