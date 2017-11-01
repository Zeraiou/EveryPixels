package com.fap.APM.GUI;

import java.awt.Color;
import java.awt.Graphics;

import com.fap.APM.Utilities.Vector2i;

public class ComponentGUI {
	
	public Vector2i positionComponent, dimensionComponent;
	protected Vector2i offsetComponent;
	public Color color;
	protected PanelGUI panel;
	protected boolean visible = true;
	
	public boolean active = true;
	
	public ComponentGUI(Vector2i position) {
		this.positionComponent = position;
		offsetComponent = new Vector2i();
	}
	
	public ComponentGUI(Vector2i position, Vector2i dimensionComponent) {
		this.positionComponent = position;
		this.dimensionComponent = dimensionComponent;
		offsetComponent = new Vector2i();
	}
	
	void initialisePanel(PanelGUI panel) {
		this.panel = panel;
	}

	public void tickGUI() {
		
	}
	
	public Vector2i getPositionDestination() {
		return new Vector2i(positionComponent).addXY(offsetComponent);
	}

	public ComponentGUI setColor(int color) {
		this.color = new Color(color);
		return this;
	}
	
	void setOffset(Vector2i offset) {
		this.offsetComponent = offset;
	}

	public void renderGUI(Graphics graphics) {
		
	}
	
}