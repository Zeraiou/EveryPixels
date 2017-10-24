package com.fap.APM.Graphics;

public class AnimatedSprite extends Sprite {
		
		
		private int frame = 0;
		private Sprite sprite;
		private int animationRate = 11;
		private int amountOfAnimation = -1;
		private int time = 0;
		
		public AnimatedSprite(SpriteSheet spriteSheet, int widthSprite, int heightSprite, int amountOfAnimation) {
			super(spriteSheet, widthSprite, heightSprite);
			this.amountOfAnimation = amountOfAnimation;
			sprite = spriteSheet.getSprites()[0];
			if (amountOfAnimation > spriteSheet.getSprites().length) System.err.println("Erreur!");
		}
		
		public void tickAnimation() {
			time++;
			if (time % animationRate == 0) {
				if (frame >= amountOfAnimation - 1) frame = 0;
				else frame++;
				sprite = spriteSheet.getSprites()[frame];
			}
			// System.out.println(sprite + ", ImageCadre : " + ImageCadre);
				
		}
			
		
		public Sprite getSprite() {
			return sprite;
		}
		
		
		public void setAnimationRate(int animationRate) {
			this.animationRate = animationRate;
		}

		public void setFrame(int index) {
			
			if (index > spriteSheet.getSprites().length - 1) {
				return;
			}
			sprite = spriteSheet.getSprites()[index];
		
		}
		
		
		
		
	}
