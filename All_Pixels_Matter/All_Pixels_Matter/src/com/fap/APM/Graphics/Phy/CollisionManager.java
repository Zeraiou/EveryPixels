package com.fap.APM.Graphics.Phy;

import com.fap.APM.Core.WorldList;
import com.fap.APM.Helpers.ActiveScope;

public class CollisionManager {
    
	private static CollisionManager INSTANCE = null;
    ActiveScope scope;

	public CollisionManager() {}

	public static CollisionManager shared() {
		if (INSTANCE == null) {
			INSTANCE = new CollisionManager();
		}
		return INSTANCE;
	}

    public void setActiveScope(ActiveScope currentScope) {
	    this.scope = currentScope;
    }

	public void collisionDetection() {
	    for (int i = 0; i < WorldList.resources.size(); i++) {

        }
	}
}


	/*    
	    private boolean CollisionCreatureTuile(double xAbsolu, double yAbsolu) {
			boolean Solide = false;
			for (int c = 0; c < 4; c++) {
				double xTemporaire = ((xActuelle + xAbsolu) - (c % 2) * 3) / 16;
				double yTemporaire = ((yActuelle + yAbsolu) - (c / 2) * 3) / 16;
				int xTemporaireInt = (int) Math.ceil(xTemporaire);
				int yTemporaireInt = (int) Math.ceil(yTemporaire);
			
				if (c % 2 == 0) xTemporaireInt = (int) Math.floor(xTemporaire);
				if (c / 2 == 0) yTemporaireInt = (int) Math.floor(yTemporaire);
				if (niveau.SaisirTuileHUB(xTemporaireInt, yTemporaireInt).Solide()) Solide = true;
			} 
			return Solide;
	}

	public boolean CollisionParticuleTuile(double xActuelle, double yActuelle) {
		boolean Solide = false;
		for (int c = 0; c < 4; c++) {
			double xTemporaire = (xActuelle - c % 2 * 16) / 16;
			double yTemporaire = (yActuelle - c / 2 * 16) / 16;
				
			int xTemporaireInt = (int) Math.ceil(xTemporaire);
			int yTemporaireInt = (int) Math.ceil(yTemporaire);
				
			if (c % 2 == 0) xTemporaireInt = (int) Math.floor(xTemporaire);
			if (c / 2 == 0) yTemporaireInt = (int) Math.floor(yTemporaire);
			
				if (niveau.SaisirTuileHUB(xTemporaireInt, yTemporaireInt).Solide()) Solide = true;
		}return Solide;
	}

	public boolean CollisionEntiteTuile(int xActuelle, int yActuelle, int DimensionEntite, int xDecallage, int yDecallage) {
			boolean Solide = false;
			for (int c =0; c < 4; c++) {
				int xTemporaire = (xActuelle - (c % 2) * DimensionEntite + xDecallage) / 16;
				int yTemporaire = (yActuelle - (c / 2) * DimensionEntite + yDecallage) / 16;
				if (SaisirTuileHUB(xTemporaire, yTemporaire).Solide()) Solide = true;
			}return Solide;
	}  */