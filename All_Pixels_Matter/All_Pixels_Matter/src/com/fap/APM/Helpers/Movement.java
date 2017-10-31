package com.fap.APM.Helpers;

public class Movement {
    private double magnitude;
    private int cardinalDirection;
    private int x, y;

    public Movement(double magnitude) {
        this.magnitude = magnitude;
        this.cardinalDirection = 3;
        this.x = 0;
        this.y = 0;
    }

    public double getXMovement() {
        return x * magnitude;
    }

    public double getYMovement() {
        return y * magnitude;
    }

    public int getXDirectionalVec() {
        return x;
    }

    public int getYDirectionalVec() {
        return y;
    }

    public int getCardinalDirection() {
        return cardinalDirection;
    }

    public void changeMovementSpeed(double magnitude) {
        this.magnitude = magnitude;
    }

    public void setDirection(int x, int y) {
        this.x = x;
        this.y = y;
        updateCardinalDirection();
    }

    public void setXDirection(int x) {
        this.x = x;
        updateCardinalDirection();
    }

    public void setYDirection(int y) {
        this.y = y;
        updateCardinalDirection();
    }

    public void stop() {
        this.x = 0;
        this.y = 0;
    }

    private void updateCardinalDirection() {
        if (x == 0) {
            if (y > 0) {
                cardinalDirection = 3;
            } else if (y < 0) {
                cardinalDirection = 1;
            }
        } else if (x > 0) {
            if (y < 0) {
                cardinalDirection = 5;
            } else if (y > 0) {
                cardinalDirection = 6;
            } else {
                cardinalDirection = 2;
            }
        } else {
            if (y < 0) {
                cardinalDirection = 8;
            } else if (y > 0) {
                cardinalDirection = 7;
            } else {
                cardinalDirection = 4;
            }
        }
    }
}