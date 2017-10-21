package com.fap.APM.Units;

import com.fap.APM.World.Map;

public class GeneratorZombie extends GeneratorEntity{
	
	public GeneratorZombie(int xPosition, int yPosition, int amountOfEntity, Map map) {
		super(xPosition, yPosition, TypeEntity.ZOMBIE, amountOfEntity, map);
		for (int i = 0; i < amountOfEntity; i++) {
			map.addEntity(new Zombie(xPosition, yPosition));
		
		}
		
	}
}