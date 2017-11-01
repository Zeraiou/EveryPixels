package com.fap.APM.Graphics.Units;
import com.fap.APM.Helpers.Movement;
import com.fap.APM.Helpers.ControlRoom;
import com.fap.APM.Graphics.Sprites.AnimatedSprite;
import com.fap.APM.Core.WorldList;

public class Player {

    private AnimatedSprite animationIdle_Down = new AnimatedSprite(WorldList.player_Idle_Down, 36, 48, 1);
    private AnimatedSprite animationIdle_Right = new AnimatedSprite(WorldList.player_Idle_Right, 36, 48, 1);
    private AnimatedSprite animationIdle_Up = new AnimatedSprite(WorldList.player_Idle_Up, 36, 48, 1);
    private AnimatedSprite animationIdle_Left = new AnimatedSprite(WorldList.player_Idle_Left, 36, 48, 1);

    private AnimatedSprite animationWalking_Down = new AnimatedSprite(WorldList.player_Walking_Down, 36, 48, 3);
    private AnimatedSprite animationWalking_Right = new AnimatedSprite(WorldList.player_Walking_Right, 36, 48, 3);
    private AnimatedSprite animationWalking_Up = new AnimatedSprite(WorldList.player_Walking_Up, 36, 48, 3);
    private AnimatedSprite animationWalking_Left = new AnimatedSprite(WorldList.player_Walking_Left, 36, 48, 3);

    public AnimatedSprite sprite;
    private double healthPoints, maxHealthPoints, fireRate, pointExperience;
    private boolean isAlive = true;
    public boolean shiftDown = false;
    public double posX, posY;
    public double height, width;
    public Movement movement;

	public Player() {
        this.sprite = animationIdle_Down;
        this.posX = ControlRoom.STARTING_X;
        this.posY = ControlRoom.STARTING_Y;
        this.height = ControlRoom.PLAYER_HEIGHT;
        this.width = ControlRoom.PLAYER_WIDTH;
        this.healthPoints = ControlRoom.HEALTH_POINTS;
        this.maxHealthPoints = ControlRoom.MAX_HEALTH_POINTS;
        this.movement = new Movement(ControlRoom.MOVEMENT_SPEED);
        this.pointExperience = ControlRoom.EXP_POINTS;
        this.fireRate = ControlRoom.FIRE_RATE;
    }

	public void nextTick() {
	    if (movement.moving() == true) {
            posX += movement.getXMovement();
            posY += movement.getYMovement();
            animationDirection(1);
            sprite.tickAnimation();
        } else {
	        animationDirection(0);
        }
    }

    public void animationDirection(int state) {
	    if (state == 0) {
            if (movement.getCardinalDirection() == 1) {
                sprite = animationIdle_Up;
            } else if (movement.getCardinalDirection() == 3) {
                sprite = animationIdle_Down;
            } else if (movement.getCardinalDirection() == 2 || movement.getCardinalDirection() == 5 || movement.getCardinalDirection() == 6) {
                sprite = animationIdle_Right;
            } else {
                sprite = animationIdle_Left;
            }
        } else if (state == 1){
            if (movement.getCardinalDirection() == 1) {
                sprite = animationWalking_Up;
            } else if (movement.getCardinalDirection() == 3) {
                sprite = animationWalking_Down;
            } else if (movement.getCardinalDirection() == 2 || movement.getCardinalDirection() == 5 || movement.getCardinalDirection() == 6) {
                sprite = animationWalking_Right;
            } else {
                sprite = animationWalking_Left;
            }
        }
    }
}