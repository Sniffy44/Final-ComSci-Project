import java.util.ArrayList;

public class LevelManager {

	int stuff;

	int levelStartTime;
	int levelTime;

	public LevelManager() {
		super();
		
	}

	public void update(ArrayList<Enemies> squaros, int level) {
		for (int i = 0; i < squaros.size(); i++) {
			if (squaros.get(i).levell == level && squaros.get(i).time == levelTime
					&& squaros.get(i).hasSpawned == false) { // makes the enemy "spawn" (teleport to track)
				
				squaros.get(i).x = - 100;
				squaros.get(i).y = 490;
				squaros.get(i).hasSpawned = true;
			}
		}

		levelTime = ((int) System.currentTimeMillis() - levelStartTime) / 100; // in tenths (10 = 1 sec)
		
		
	}
	
	// double x, double y, double vx, double vy, int width, int height, double speed, int health,
	// int fullHealth, boolean hasSpawned, int levell, int time, int prize, BufferedImage texture, double identity

	// 1 is norm, 2 is speedy, 3 is healer, 4 is birther, 5 is tank
	public void levelOneT1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 1, 10, 10+level/2, null, 1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 1, 20, 10+level/2, null, 1.1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 1, 30, 10+level/2, null, 1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 1, 40, 10+level/2, null, 1.1));
		

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 1, 80, 10+level/2, null, 2));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 1, 90, 10+level/2, null, 2));
		
		
	}
	//double speed, int health,
	// int fullHealth, boolean hasSpawned, int levell, int time, int prize, BufferedImage texture, double identity
	
	public void levelTwoT1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 2, 8, 10+level/2, null, 1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 2, 16, 10+level/2, null, 1.1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 2, 24, 10+level/2, null, 1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 2, 32, 10+level/2, null, 1.1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 2, 40, 10+level/2, null, 1.1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 2, 48, 10+level/2, null, 1.1));
		

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 2, 80, 10+level/2, null, 2));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 2, 90, 10+level/2, null, 2));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 2, 100, 10+level/2, null, 2));
		
		
		
	}
	public void levelThreeT1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 3, 1, 10+level/2, null, 2));
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 3, 10 + i*8, 10+level/2, null, 1));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 3, 90 + i*10, 10+level/2, null, 3));
		}
		for(int i = 0; i < 2; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 3, 110  + i*20, 10+level/2, null, 5));
		}
				
	}
	
	public void level4T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 8; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 4, 10 + i*8, 10+level/2, null, 3));
		}
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 4, 120 + i*18, 10+level/4, null, 4));
		}
	}
	
	public void level5T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 5, 10, 10+level/2, null, 1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 5, 15, 10+level/2, null, 1.1));

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 5, 25, 10+level/2, null, 2));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 5, 30, 10+level/4, null, 2));
		
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 5, 50, 10+level/4, null, 3));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 5, 60, 10+level/2, null, 3));
		
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 5, 80, 10+level/4, null, 4));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 5, 90, 10+level/2, null, 4));
		
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 5, 110, 10+level/4, null, 5));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 5, 120, 10+level/4, null, 5));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 5, 130, 10+level/4, null, 5));
	}
	
	public void level6T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 6, 10 + i*6, 10+level/4, null, 2));
		}
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 6, 50 + i*10, 10+level/4, null, 5));
		}
		for(int i = 0; i < 2; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 6, 110 + i*15, 10+level/4, null, 4));
		}
		
	}
	
	public void level7T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 7, 10 + i*9, 10+level/4, null, 1));
		}
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 7, 50 + i*10, 10+level/4, null, 4));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 7, 110 + i*9, 10+level/4, null, 1));
		}
		
		
	}
	
	public void level8T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 8, 10 + i*15, 10+level/4, null, 1));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 8, 10 + i*10, 10+level/4, null, 2));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 8, 10 + i*20, 10+level/4, null, 3));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 8, 10 + i*30, 10+level/4, null, 4));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 8, 10 + i*40, 10+level/4, null, 5));
		}
	}
	
	public void level9T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 9, 10 + i*10, 10+level/4, null, 2));
		}
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 9, 50 + i*12, 10+level/4, null, 3));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 9, 100 + i*10, 10+level/4, null, 2));
		}
		
		
	}
	
	public void level10T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 10, 10 + i*8, 10+level/4, null, 2));
		}
		for(int i = 0; i < 8; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 10, 40 + i*20, 10+level/4, null, 4));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 10, 220 + i*8, 10+level/4, null, 2));
		}
		
	}
	
	public void level11T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 11, 10 + i*15, 10+level/4, null, 1));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 11, 10 + i*10, 10+level/4, null, 2));
		}
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 11, 10 + i*20, 10+level/4, null, 3));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 11, 10 + i*30, 10+level/4, null, 4));
		}
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 11, 10 + i*40, 10+level/4, null, 5));
		}
		
	}
	
	public void level12T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 12, 10 + i*6, 10+level/4, null, 2));
		}
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 12, 50 + i*10, 10+level/4, null, 5));
		}
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 12, 110 + i*15, 10+level/4, null, 4));
		}
		
	}
	
	public void level13T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 13, 10 + i*8, 10+level/4, null, 2));
		}
		for(int i = 0; i < 8; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 13, 40 + i*20, 10+level/4, null, 4));
		}
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 13, 220 + i*8, 10+level/4, null, 2));
		}
		
	}
	
	public void level14T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 15; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 14, 10 + i*17, 10+level/4, null, 5));
		}
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 13, 50 + i*10, 10+level/4, null, 2));
		}
	}
	
	public void level15T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 15, 10 + i*8, 10+level/4, null, 2));
		}
		for(int i = 0; i < 12; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 15, 40 + i*20, 10+level/4, null, 4));
		}
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 15, 250 + i*8, 10+level/4, null, 2));
		}
		
	}
	
	public void level16T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 16, 10 + i*15, 10+level/4, null, 1));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 16, 10 + i*10, 10+level/4, null, 2));
		}
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 16, 10 + i*20, 10+level/4, null, 3));
		}
		for(int i = 0; i < 3; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 16, 10 + i*30, 10+level/4, null, 4));
		}
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 16, 10 + i*40, 10+level/4, null, 5));
		}
		
	}
	
	public void level17T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 17, 10 + i*8, 10+level/4, null, 2));
		}
		for(int i = 0; i < 8; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 17, 40 + i*20, 10+level/4, null, 4));
		}
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 17, 220 + i*8, 10+level/4, null, 2));
		}
	}
	
	public void level18T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 15; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 18, 10 + i*17, 10+level/4, null, 5));
		}
		for(int i = 0; i < 10; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 18, 40 + i*20, 10+level/4, null, 4));
		}
		
	}
	
	public void level19T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 19, 10 + i*6, 10+level/4, null, 2));
		}
		for(int i = 0; i < 5; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 19, 50 + i*10, 10+level/4, null, 5));
		}
		for(int i = 0; i < 4; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 19, 110 + i*15, 10+level/4, null, 4));
		}
		
	}
	
	public void level20T1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();
		for(int i = 0; i < 10; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 20, 10 + i*15, 10+level/4, null, 1));
		}
		for(int i = 0; i < 10; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*2*8, 80 + level*2*8, false, 20, 10 + i*10, 10+level/4, null, 2));
		}
		for(int i = 0; i < 10; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*2*10, 100 + level*2*10, false, 20, 10 + i*20, 10+level/4, null, 3));
		}
		for(int i = 0; i < 10; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*2*12, 120 + level*2*12, false, 20, 10 + i*30, 10+level/4, null, 4));
		}
		for(int i = 0; i < 10; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*2*30, 300 + level*2*30, false, 20, 10 + i*40, 10+level/4, null, 5));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
