package com.fap.APM.Core;

import com.fap.APM.Core.ControlRoom;

public class InGameClock {
	
    private static InGameClock INSTANCE = null;
    
    
    private double minuteInGameElasped = 1440 / (ControlRoom.MINUTE_PER_DAY * 60);
    

    public int secondCount, hourCount, dayCount;   
    public double minuteCount;
    public boolean day, night;
    
    private int loopCount = 0;
    
	
	private InGameClock() { }

	public static InGameClock shared() {
		if (INSTANCE == null) {
			INSTANCE = new InGameClock();
	    }
		return INSTANCE;
	}
	
	
	public void tickInGameClock() {
		loopCount++;
		
		if (loopCount % 60 == 0) {
			secondCount += 60;
			System.out.println(loopCount + " : " + "day " + dayCount + " - " + hourCount + ":" + minuteCount + ":" + secondCount);
			System.out.println(loopCount + " : " + "day " + day + " , night " + night);
			 

		}
		
		if (secondCount == 60) {
			secondCount = 0;
			minuteCount += minuteInGameElasped;
		}
		
		if (minuteCount >= 60) {
			
			minuteCount -= 60;
			hourCount++;
		}
		
		
		
		if (hourCount == 24) {
			hourCount = 0;
			dayCount++;
		}
		
		if (hourCount <= 7 && minuteCount <= 59) {
			day = false;
			night = true;
		} else if (hourCount >= 8 && minuteCount >= 0) {
			if (hourCount <= 19 && minuteCount <= 59) {
				day = true;
				night = false;
				
			} else if (hourCount >= 20 && minuteCount >= 0) {
				day = false;
				night = true;
			}
		
		}
		
	}
}
