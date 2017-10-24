package com.fap.APM.Graphics.Phy;
import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Core.Input.Keyboard;
import com.fap.APM.WorldObjects.WorldList;
import com.fap.APM.Core.WorldMaker;
import javax.swing.*;

public class GameClock {

    private static GameClock INSTANCE = null;
    long lastTime = System.nanoTime();
    long clock1Sec = System.currentTimeMillis();
    double delta = 0;
    int fps = 0;
    int tps = 0;

    private GameClock() {}     // Private Init.

    public static GameClock shared() {
        if (INSTANCE == null) {
            INSTANCE = new GameClock();
        }
        return INSTANCE;
    }

    public void clockTick(JFrame frame, Keyboard keyboard) {
        long currentTime = System.nanoTime();
        delta += (currentTime - lastTime) / ControlRoom.NANOSECONDE;
        lastTime = currentTime;

        if (delta >= 1) {
            keyboard.updateKeyboard();
            globalTick();
            WorldMaker.shared().removeEntity();  // Todo: removeList.
            tps++;
            delta--;
        }

        fps++;

        if (System.currentTimeMillis() - clock1Sec > 1000) {
            clock1Sec += 1000;
            frame.setTitle(ControlRoom.GAME_TITLE + "    |     " + "Fps : "
                    + fps + " , Tps : " + tps
                    + "        |       " + " Pixels -- X : "
                    + (int) WorldList.players.get(0).posX + ", Y: "
                    + (int) WorldList.players.get(0).posY + "        |       "
                    + "Tuiles -- X : "
                    + (int) (WorldList.players.get(0).posX / 12) + ", Y: "
                    + (int) (WorldList.players.get(0).posY / 12)
                    + "        |       " + " Souris -- X : ");
            //		+ (int) Souris.SaisirX() + " , Y : "
            //		+ (int) Souris.SaisirY());
            fps = 0;
            tps = 0;
        }
    }

    private void globalTick() {
        for (int i = 0; i < WorldList.players.size(); i++) {
            WorldList.players.get(i).nextTick();
        }

        for (int i = 0; i < WorldList.monsters.size(); i++) {
            WorldList.monsters.get(i).nextTick();
        }

        for (int i = 0; i < WorldList.particles.size(); i++) {
            WorldList.particles.get(i).nextTick();
        }
    }
}