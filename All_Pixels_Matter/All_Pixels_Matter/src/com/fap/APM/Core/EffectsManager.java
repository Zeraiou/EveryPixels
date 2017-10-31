package com.fap.APM.Core;

public class EffectsManager {

    private static EffectsManager INSTANCE = null;

    private EffectsManager() {
    }

    public static EffectsManager shared() {
        if (INSTANCE == null) {
            INSTANCE = new EffectsManager();
        }
        return INSTANCE;
    }

    public static void startEffects() {
        INSTANCE = new EffectsManager();
    }

    public void effectsNextTick() {
        for (int i = 0; i < WorldList.particles.size(); i++) {
            WorldList.particles.get(i).nextTick();
        }
    }
}
