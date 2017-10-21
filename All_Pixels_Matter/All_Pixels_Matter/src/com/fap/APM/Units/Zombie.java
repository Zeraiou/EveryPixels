package com.fap.APM.Units;

import com.fap.APM.Graphics.ScreenDisplay;

public class Zombie extends Creature {

	
	
	private int time = 0;
	private double xDestination;
	private double yDestination;
	
	
	public void tickEntity() {
		
		time++;
		
		if (time % (RANDOM.nextInt(90) + 30) == 0) {
			int direction = (RANDOM.nextInt(3));
			
			if (direction == 0) {
				spriteCreature = AnimationHaut;
				direction = Direction.HAUT;
				
			}
			
			if (direction == 1) {
				SpriteAnimeeEnCours = AnimationDroite;
				direction = Direction.DROITE;
				
			}
			
			if (direction == 2) {
				SpriteAnimeeEnCours = AnimationBas;
				direction = Direction.BAS;
				
			}
			
			if (direction == 3) {
				SpriteAnimeeEnCours = AnimationGauche;
				direction = Direction.GAUCHE;
				
			}
			
			if (RANDOM.nextInt(5) == 0) {
				xDestination = 0;
				yDestination = 0;
			}
		}
		
		
		
	}

	
	
	
	
	
	
	public void renderEntity(ScreenDisplay screen) {
			
	}

}
