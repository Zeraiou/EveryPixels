package com.fap.APM.Units;

import com.fap.APM.Graphics.ScreenDisplay;
import com.fap.APM.Graphics.SpriteSheet.Sprite;

public class Particle extends Entity{
	
	private Sprite spriteParticle;
	private int lifeTime;
	private int time = 0;
	
	protected double xDestination, yDestination, zDestination; 
	protected double xEntityDouble, yEntityDouble, zEntityDouble;
	
	
	
	public Particle(int xEntity, int yEntity, int lifeTime) {
		this.xEntity = xEntity;
		this.yEntity = yEntity;
		this.xEntityDouble = xEntity;
		this.yEntityDouble = yEntity;
		this.lifeTime = lifeTime + RANDOM.nextInt(20) - 10;
		
		
		
		spriteParticle = Sprite.particle2p;
		/*
		spriteParticle = Sprite.particle1p;
		spriteParticle = Sprite.particle3p;
		spriteParticle = Sprite.particle4p;
		spriteParticle = Sprite.particle5p;
		spriteParticle = Sprite.particle6p;
		spriteParticle = Sprite.particle7p;
		spriteParticle = Sprite.particle8p;
		spriteParticle = Sprite.particle9p;
		*/
		
		
		this.xDestination = RANDOM.nextGaussian();
		
		this.yDestination = RANDOM.nextGaussian();
		this.zEntityDouble= RANDOM.nextFloat() + 2.0 ;
		
	}

	public void tickEntity() {
		time++;
		if(time > 10000) time = 0;
		if (time > lifeTime) removeEntity();
		
		zDestination -= 0.1;
		if (zEntityDouble < 0) {
			zEntityDouble = 0;
			zDestination *= -0.6; 
			xDestination *= 0.4;
			yDestination *= 0.4;
		
		}
		moveParticle((xEntityDouble + xDestination), (yEntityDouble + yDestination) + (zEntityDouble + zDestination));
		
		
	}

	private void moveParticle(double currentX, double currentY) {
		this.xEntityDouble += xDestination;
		this.yEntityDouble += yDestination;
		this.zEntityDouble += zDestination;
	
		
	}

	public void renderEntity(ScreenDisplay screen) {
		int xPrecisionParticle = 0, yPrecisionParticle = 0;
		int xPrecisionParticleCollision = 0, yPrecisionParticleCollision = 0;
		
		screen.renderSprite(((int) xEntityDouble) - xPrecisionParticle - xPrecisionParticleCollision, ((int)yEntityDouble) - yPrecisionParticle - yPrecisionParticleCollision - (int) zEntityDouble, spriteParticle, true); 
	}
	
	
}
