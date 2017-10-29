package com.fap.APM.WorldObjects.Units;
import com.fap.APM.Helpers.Movement;
import com.fap.APM.ControlRoom;
import com.fap.APM.Graphics.AnimatedSprite;
import com.fap.APM.WorldObjects.WorldList;

public class Player {

    private AnimatedSprite animationDown = new AnimatedSprite(WorldList.player_Base34_Down, 36, 48, 3);
    private AnimatedSprite animationRight = new AnimatedSprite(WorldList.player_Base34_Right, 36, 48, 3);
    private AnimatedSprite animationUp = new AnimatedSprite(WorldList.player_Base34_Up, 36, 48, 3);
    private AnimatedSprite animationLeft = new AnimatedSprite(WorldList.player_Base34_Left, 36, 48, 3);
    public AnimatedSprite sprite;
    private double healthPoints, maxHealthPoints, fireRate, pointExperience;
    private boolean isAlive = true;
    public boolean shiftDown = false;
    public double posX, posY;
    public Movement movement;

	public Player() {
        sprite = animationDown;
        posX = ControlRoom.STARTING_X;
        posY = ControlRoom.STARTING_Y;
        healthPoints = ControlRoom.HEALTH_POINTS;
        maxHealthPoints = ControlRoom.MAX_HEALTH_POINTS;
        movement = new Movement(ControlRoom.MOVEMENT_SPEED);
        pointExperience = ControlRoom.EXP_POINTS;
        fireRate = ControlRoom.FIRE_RATE;
    }

	public void nextTick() {
        posX += movement.getXMovement();
        posY += movement.getYMovement();
        animationDirection();
        sprite.tickAnimation();
    }

    public void animationDirection() {
        if (movement.getCardinalDirection() == 1) {
            sprite = animationUp;
        } else if (movement.getCardinalDirection() == 3) {
            sprite = animationDown;
        } else if (movement.getCardinalDirection() == 2 || movement.getCardinalDirection() == 5 || movement.getCardinalDirection() == 6) {
            sprite = animationRight;
        } else {
            sprite = animationLeft;
        }
    }
}