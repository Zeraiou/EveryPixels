package com.fap.APM.Graphics.Sprites;
import com.fap.APM.Core.WorldList;
import java.util.Random;

public class Particle {

    protected final Random RANDOM = new Random();
    protected double xDestination, yDestination, zDestination;
    public double posX, posY, posZ;
    public boolean isRemoved = false;
	public Sprite spriteParticle;
	public int timeToLive;
	public int time = 0;

	public Particle(int x, int y, int timeToLive) {
		this.posX = x;
		this.posY = y;
		this.timeToLive = timeToLive + RANDOM.nextInt(20) - 10;
		spriteParticle = WorldList.particle2p;

		this.xDestination = RANDOM.nextGaussian();
		this.yDestination = RANDOM.nextGaussian();
		this.posZ= RANDOM.nextFloat() + 2.0 ;
	}

	public void nextTick() {
		time++;
		if(time > 10000) time = 0;
		if (time > timeToLive) {
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