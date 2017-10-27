package com.fap.APM.Graphics.Phy;

import com.fap.APM.Core.ControlRoom;
import com.fap.APM.Core.WorldMaker;
import com.fap.APM.Graphics.Sprite;
import com.fap.APM.WorldObjects.WorldList;
import com.fap.APM.WorldObjects.Basics.Resource;

public class AI {
    private static AI INSTANCE = null;
    private int time = 0;

    
    private AI() { }

    public static AI shared() {
        if (INSTANCE == null) {
            INSTANCE = new AI();
            
        }
        return INSTANCE;
    }
    
    public void tickAI() {
    	GenerateMonster();
	}
    
    public void GenerateMonster() {
		time++;
		if (time == 3600) {
            time = 0;
        } else if (time == 120) {
            WorldMaker.shared().createEspirito(ControlRoom.STARTING_X - 200, ControlRoom.STARTING_Y - 200, 4, 2, 1, 1);
        } else if (time == 60) {
           WorldMaker.shared().createZombie(ControlRoom.STARTING_X + 20, ControlRoom.STARTING_Y + 20, 4, 1, 1, 1);
        } else if (time == 360) {
           WorldMaker.shared().createLarvion(ControlRoom.STARTING_X + 40, ControlRoom.STARTING_Y + 40, 4, 3, 1, 1);

        }  else if (time == 240) {
            WorldMaker.shared().createBichette(ControlRoom.STARTING_X + 75, ControlRoom.STARTING_Y + 75, 4, 4, 1, 1);
        }

		
	}
    
    
    public void GenerateResource(int amountOfRandomGeneration) {
    	for (int i = 0; i < amountOfRandomGeneration; i++) {
    		int typeTemp = ControlRoom.RANDOM.nextInt(6) + 1;
    		int amountTemp = ControlRoom.RANDOM.nextInt(50);
    		System.out.println("Type : " + typeTemp + " , Quantite : " + amountTemp);
    		createRandomResource(typeTemp, amountTemp);
    	}
	
    	System.out.println("Ressource apres le random creation : " + WorldList.resources.size());

    }
    
    
    public void createRandomResource(int typeResource, int amountToCreate) {
    	Sprite sprite = null;
    	boolean create = false;
    	
    	for (int i = 0; i < amountToCreate; i++) {
    	
    		if (typeResource == 1) {
    			sprite = WorldList.sprite_Coniferous_Big;
    		} else if (typeResource == 2) {
    			sprite = WorldList.sprite_Coniferous_Small;
    		} else if (typeResource == 3) {
    			sprite = WorldList.sprite_Hardwood_Big;
    		} else if (typeResource == 4) {
    			sprite = WorldList.sprite_Hardwood_Small;
    		} else if (typeResource == 5) {
    			sprite = WorldList.sprite_Bush_Big;
    		} else if (typeResource == 6) {
    			sprite = WorldList.sprite_Bush_Small;
    		}
    	
    		if (sprite != null) {
    			int posXTemp = (ControlRoom.RANDOM.nextInt(WorldMaker.shared().width) * ControlRoom.TILE_WIDTH);
    			int posYTemp = (ControlRoom.RANDOM.nextInt(WorldMaker.shared().height) * ControlRoom.TILE_HEIGHT);
    			
    			for (int r = 0; r < WorldList.resources.size(); r ++) {
    				if (posXTemp == WorldList.resources.get(r).posX) {
    					if (posYTemp == WorldList.resources.get(r).posY) {
    						create = false;
    						System.out.println("deja un occupant");
    						break;
    					}
    				}
    				create = true;
    			}
    			if (create) {
    				for (int r = 0; r < WorldList.walls.size(); r ++) {
    					if (posXTemp == WorldList.walls.get(r).posX) {
    						if (posYTemp == WorldList.walls.get(r).posY) {
    							create = false;
    							System.out.println("deja un occupant");
    							break;
    						}
    					}
    					create = true;
    				}
    			}
    			
    			if (create) {
    				Resource resource = new Resource(sprite, posXTemp, posYTemp, sprite.width, sprite.height);
    				WorldList.resources.add(resource);
    				System.out.println("Ressource posX : " + posXTemp / ControlRoom.TILE_WIDTH + " , Ressource posY : " + posYTemp / ControlRoom.TILE_HEIGHT);
    				System.out.println("Ressources incrementer dune creation : " + WorldList.resources.size());
    				create = false;
    			}
    		}
    	}
    }

	
}
