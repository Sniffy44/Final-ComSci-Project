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

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*10, 100 + level*10, false, 1, 10, 10+level/2, null, 1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*10, 100 + level*10, false, 1, 15, 10+level/2, null, 1.1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*10, 100 + level*10, false, 1, 20, 10+level/2, null, 1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*10, 100 + level*10, false, 1, 25, 10+level/2, null, 1.1));
		

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*8, 80 + level*8, false, 1, 50, 10+level/2, null, 2));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*8, 80 + level*8, false, 1, 60, 10+level/2, null, 2));
		
		
	}
	//double speed, int health,
	// int fullHealth, boolean hasSpawned, int levell, int time, int prize, BufferedImage texture, double identity
	
	public void levelTwoT1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*10, 100 + level*10, false, 2, 10, 10+level/2, null, 1));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 3 + ((double)(level)*.1), 100 + level*10, 100 + level*10, false, 2, 15, 10+level/2, null, 1.1));

		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*8, 80 + level*8, false, 2, 25, 10+level/2, null, 2));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 5 + ((double)(level)*.15), 80 + level*8, 80 + level*8, false, 2, 30, 10+level/2, null, 2));
		
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*10, 100 + level*10, false, 2, 50, 10+level/2, null, 3));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.6 + ((double)(level)*.1), 100 + level*10, 100 + level*10, false, 2, 60, 10+level/2, null, 3));
		
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*12, 120 + level*12, false, 2, 80, 10+level/2, null, 4));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*12, 120 + level*12, false, 2, 90, 10+level/2, null, 4));
		
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*30, 300 + level*30, false, 2, 110, 10+level/2, null, 5));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*30, 300 + level*30, false, 2, 120, 10+level/2, null, 5));
		squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 1.4 + ((double)(level)*.07), 300 + level*30, 300 + level*30, false, 2, 130, 10+level/2, null, 5));
		
		
		
	}
	public void levelThreeT1(ArrayList<Enemies> squaros, int level) {
		levelStartTime = (int) System.currentTimeMillis();

		for(int i = 0; i < 8; i ++){
			squaros.add(new Enemies(-9000, 374, 0, 0, 50, 50, 2.3 + ((double)(level)*.08), 120 + level*12, 120 + level*12, false, 3, 10 + i*15, 10+level/2, null, 4));
		}
		
		

		
		
		
	}

}
