package com.fap.APM.Helpers;

import com.fap.APM.WorldObjects.Units.Monster;

public class Helper {

    public static int absolute(double value) {
        if (value < 0) return -1;
        return 1;
    }

    public static Position getMouseScreenPosition() {
        return new Position();
    }

    public static Position getWorldPixelPosition() {
        return new Position();
    }

    public static Position getWorldTilePosition() {
        return new Position();
    }

    public static Position getFullPositionFromMouse() {
        return new Position();
    }

    public static Position getFullPositionFromPlayer() {
        return new Position();
    }

    public static Position getFullPositionFromMonster(Monster monster) {
        return new Position();
    }
}
