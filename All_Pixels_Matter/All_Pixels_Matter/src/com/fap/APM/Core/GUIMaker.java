package com.fap.APM.Core;

import com.fap.APM.GUI.PanelGUI;
import com.fap.APM.Helpers.ControlRoom;

import java.awt.Font;

import com.fap.APM.GUI.LabelGUI;
import com.fap.APM.GUI.ManagerGUI;
import com.fap.APM.Utilities.Vector2i;

public class GUIMaker {
	
    private static GUIMaker INSTANCE = null;
    public ManagerGUI managerGUI;
    public String cycleDayNight = "Day"; 

    private LabelGUI labelName, labelDayCount, labelTimeCount, labelCycleDayNight;
    private PanelGUI panelOverall, panelDayCount, panelTimeCount, panelCycleDayNight;
    

	public GUIMaker() {
		
		managerGUI = new ManagerGUI();
		panelOverall = (PanelGUI) new PanelGUI(new Vector2i(0, 0), new Vector2i(260, 135)).setColor(0xffcacaca);
		managerGUI.addPanel(panelOverall);
		
		
		labelName = new LabelGUI(new Vector2i(10, 30), ControlRoom.GAME_NAME);
		labelName.setColor(0xff684321);
		labelName.setFont(new Font("Helvetica", Font.BOLD, 30));
		labelName.dropShadow = true;
		panelOverall.addComponent(labelName);
		
		panelDayCount = (PanelGUI) new PanelGUI(new Vector2i(panelOverall.positionComponent.x + 15, labelName .positionComponent.y + 10), new Vector2i(135, 25)).setColor(0xff4d5111);
		panelOverall.addComponent(panelDayCount);
		
		
		labelDayCount = new LabelGUI(new Vector2i(panelDayCount.positionComponent.x + 5, panelDayCount.positionComponent.y + 20), new String("Day : " + InGameClock.shared().dayCount + "."));
		labelDayCount.setColor(0xff684321);
		labelDayCount.dropShadow = true;
		panelDayCount.addComponent(labelDayCount);
		
		panelTimeCount = (PanelGUI) new PanelGUI(new Vector2i(panelDayCount.positionComponent.x, panelDayCount.positionComponent.y + 30), new Vector2i(135, 25)).setColor(0xff4d1ff1);
		panelOverall.addComponent(panelTimeCount);
		
		
		labelTimeCount = new LabelGUI(new Vector2i(panelTimeCount.positionComponent.x + 5, panelTimeCount.positionComponent.y + 20), new String("Time : " + "00" + " : " + "00" + "."));
		labelTimeCount.setColor(0xff684321);
		labelTimeCount.dropShadow = true;
		panelTimeCount.addComponent(labelTimeCount);

		panelCycleDayNight = (PanelGUI) new PanelGUI(new Vector2i(panelTimeCount.positionComponent.x, panelTimeCount.positionComponent.y + 30), new Vector2i(135, 25)).setColor(0xff4d9ff1);
		panelOverall.addComponent(panelCycleDayNight);
		
		
		labelCycleDayNight = new LabelGUI(new Vector2i(panelCycleDayNight.positionComponent.x + 5, panelCycleDayNight.positionComponent.y + 20), new String("Cycle : " + cycleDayNight + "."));
		labelCycleDayNight.setColor(0xff684321);
		labelCycleDayNight.dropShadow = true;
		panelCycleDayNight.addComponent(labelCycleDayNight);
		
		
	}
    
	public static GUIMaker shared() {
		if (INSTANCE == null) {
			INSTANCE = new GUIMaker();
	    }
		return INSTANCE;
	}


	public static void startGUIMaker() {
		INSTANCE = new GUIMaker();
	}


	
	
	public void tickGUI() {
		
		if (InGameClock.shared().day) {
			cycleDayNight = "Day";
		} else {
			cycleDayNight = "Night";
		}
		
		labelCycleDayNight.text = cycleDayNight;
		
		
		labelTimeCount.text = new String("Time : " + InGameClock.shared().hourCount + " : " + (int) InGameClock.shared().minuteCount + ".");
	}
	
	
}
