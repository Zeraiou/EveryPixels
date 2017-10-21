package com.fap.APM.Units;

import com.fap.APM.Units.GeneratorEntity.TypeEntity;
import com.fap.APM.World.Map;

public class GeneratorParticle extends GeneratorEntity{
	
	private int lifeTime;
	
	public GeneratorParticle(int xPosition, int yPosition, int amountOfEntity, int lifeTime, Map map) {
		super(xPosition, yPosition, TypeEntity.ZOMBIE, amountOfEntity, map);
		this.lifeTime = lifeTime;
		for (int i = 0; i < amountOfEntity; i++) {
			map.addEntity(new Particle(xPosition, yPosition, lifeTime));
		
		}
		
	}
}

