package com.fap.APM.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.fap.APM.Utilities.Vector2i;

public class LabelGUI extends ComponentGUI{
	public String text;
	private Font fontGUI;
	public boolean dropShadow;
	
	public LabelGUI(Vector2i positionLabel, String text) {
		super(positionLabel);
		fontGUI = new Font("Helvetica", 0, 20);
		setText(text);
		color = new Color(0xffFF00FF);
	}
	
	
	public LabelGUI setFont(Font font) {
		this.fontGUI = font;
		return this;
	}

	public void tickGUI() {
		
	}
	
	public String setText(String text) {
		this.text = text;
		return this.text;
	}
		
	public void renderGUI(Graphics graphics) {
		
		if (dropShadow) {
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font(fontGUI.getName(), fontGUI.getStyle(), fontGUI.getSize()));
		graphics.drawString(text, positionComponent.x + offsetComponent.x + 1, positionComponent.y + offsetComponent.y + 1);
		}
		
		graphics.setColor(Color.BLACK);
		graphics.setFont(fontGUI);
		graphics.drawString(text, positionComponent.x + offsetComponent.x, positionComponent.y + offsetComponent.y);
		}
	

}