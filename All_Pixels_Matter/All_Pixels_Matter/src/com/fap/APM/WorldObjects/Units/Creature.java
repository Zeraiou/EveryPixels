package com.fap.APM.WorldObjects.Units;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Core.DrawManager;

public abstract class Creature extends Entity {

    protected boolean isMoving = false;
	protected int pointHealt, pointMagic, pointExperience;
	protected double pointHealtMaximum, pointMagicMaximum, pointExperienceMaximum;
	protected double pointHealtPercentage, pointMagicPercentage, pointExperiencePercentage;
	protected double movementSpeed;

	public abstract void tickEntity();

	protected void move(double xDestination, double yDestination) {
		
		while (xDestination != 0) {
			if (Math.abs(xDestination) > 1) {
				if (!collisionCreatureTile(absolute(xDestination), yDestination)) {
					this.xEntity += absolute(xDestination);
				} 
				xDestination -= absolute(xDestination);
			}	else {
				if (!collisionCreatureTile(absolute(xDestination), yDestination)) {
					this.xEntity += xDestination;
				} 
				xDestination = 0;
			}
		}

		while (yDestination != 0) {
			if (Math.abs(yDestination) > 1) {
				if (!collisionCreatureTile(xDestination, absolute(yDestination))) {
					this.yEntity += absolute(yDestination);
				} 
				yDestination -= absolute(yDestination);
			}	else {
				if (!collisionCreatureTile(xDestination, absolute(yDestination))) {
					this.yEntity += yDestination;
				} 
				yDestination = 0;
			}
		}
	}
	
	private int absolute(double value) {
		if (value < 0) return -1;
		return 1;
	}
	
	private boolean collisionCreatureTile(double xAbsolu, double yAbsolu) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			double xTemp = ((xEntity + xAbsolu) - (c % 2)) / ControlRoom.TILE_WIDTH;
			double yTemp= ((yEntity + yAbsolu) - (c / 2)) / ControlRoom.TILE_HEIGHT;
			int xTempInt = (int) Math.ceil(xTemp);
			int yTempInt = (int) Math.ceil(yTemp);
		
			if (c % 2 == 0) xTempInt = (int) Math.floor(xTemp);
			if (c / 2 == 0) yTempInt = (int) Math.floor(yTemp);
			if (DrawManager.shared().getMapFieldTiles(xTempInt, yTempInt).solid()) {
				solid = true;
			}
		} 
		return solid;
	}
	
	protected void attack(double xEntity, double yEntity, double attackDirection) {
		//DirectionAttaque *= (180/Math.PI);
		//Projectile ProjectileEnCours = new ProjectileGuerrier(xActuelle, yActuelle, DirectionAttaque);
		//niveau.AjouterEntite(ProjectileEnCours);
	}
}