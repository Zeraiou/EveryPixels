package com.fap.APM.Units;

import com.fap.APM.World.Map;

public abstract class GeneratorEntity extends Entity{
	
	
	public enum TypeEntity {
		CREATURE, ZOMBIE, PARTICULE;
	}
	
	protected TypeEntity typeEntity;
	
	public GeneratorEntity(int xPosition, int yPosition, TypeEntity typeEntity, int amountOfEntity, Map map) {
		initialiseMap(map);
		this.xEntity = xPosition;
		this.yEntity = yPosition;
		this.typeEntity = typeEntity;
		
	}
}
