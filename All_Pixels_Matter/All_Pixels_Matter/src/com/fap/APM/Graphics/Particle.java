package com.fap.APM.Graphics;
import com.fap.APM.WorldObjects.WorldList;
import java.util.Random;

public class Particle {

    protected final Random RANDOM = new Random();
    protected double xDestination, yDestination, zDestination;
    public double posX, posY, posZ;
    public boolean isRemoved = false;

	public Sprite spriteParticle;
	public int ttl, ticksAlive;
	public int time = 0;

	public Particle(int x, int y, int lifeTime) {
		this.posX = x;
		this.posY = y;
		this.ttl = lifeTime + RANDOM.nextInt(20) - 10;
		spriteParticle = WorldList.particle2p;

		this.xDestination = RANDOM.nextGaussian();
		this.yDestination = RANDOM.nextGaussian();
		this.posZ= RANDOM.nextFloat() + 2.0 ;
	}

	public void nextTick() {
		time++;
		if(time > 10000) time = 0;
		if (time > ttl) {
		    isRemoved = true;
        }
		
		zDestination -= 0.1;
		if (posZ< 0) {
			posZ = 0;
			zDestination *= -0.6; 
			xDestination *= 0.4;
			yDestination *= 0.4;
		}

        posX += xDestination;
        posY += yDestination;
        posZ += zDestination;
	}
}