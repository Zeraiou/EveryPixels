package com.fap.APM.GUI;

import java.awt.Color;
import java.awt.Graphics;


import com.fap.APM.Core.WorldList;
import com.fap.APM.Utilities.Vector2i;

public class PanelGUI extends ComponentGUI {
	
	public PanelGUI(Vector2i positionPanel, Vector2i dimensionPanel) {
		super(positionPanel, dimensionPanel);
		color = new Color(0xffcacaca);
		
	}

	public void tickGUI() {
		
	}
	
	public void addComponent(ComponentGUI component) {
		component.initialisePanel(this);
		WorldList.componentsGUI.add(component);
	}

	public void renderGUI(Graphics graphics) {
		graphics.setColor(color);
		graphics.fillRect(positionComponent.x, positionComponent.y, dimensionComponent.x, dimensionComponent.y);
	}

}
