package com.fap.APM.GUI;

import com.fap.APM.Core.WorldList;

import java.awt.Graphics;


public class ManagerGUI {

	private static ManagerGUI INSTANCE = null;
	
	public ManagerGUI() { }
	
	
	public void addPanel(PanelGUI panel) {
		WorldList.panelsGUI.add(panel);
	}
	
	public void tickManagerGUI() {
		for (int i = 0; i < WorldList.panelsGUI.size(); i++) {
			 WorldList.panelsGUI.get(i).tickGUI();
		}
		
		for (int i = 0; i < WorldList.componentsGUI.size(); i++) {
			 WorldList.componentsGUI.get(i).tickGUI();
		}
	}
	
	public void renderManagerGUI(Graphics graphics) {
		for (int i = 0; i < WorldList.panelsGUI.size(); i++) {
			 WorldList.panelsGUI.get(i).renderGUI(graphics);
		}
		
		for (int i = 0; i < WorldList.componentsGUI.size(); i++) {
			 WorldList.componentsGUI.get(i).renderGUI(graphics);
		}
		
	}
}
