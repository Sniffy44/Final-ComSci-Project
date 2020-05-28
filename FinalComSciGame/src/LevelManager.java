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

	public void levelOneT1(ArrayList<Enemies> squaros) {
		levelStartTime = (int) System.currentTimeMillis();

		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 3, 100, 100, false, 1, 10, 10, null, 1));
		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 3, 100, 100, false, 1, 30, 10, null, 1));
		

		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 6, 100, 100, false, 1, 80, 10, null, 2));
		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 6, 100, 100, false, 1, 90, 10, null, 2));
		
		
	}
	
	public void levelTwoT1(ArrayList<Enemies> squaros) {
		levelStartTime = (int) System.currentTimeMillis();

		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 3, 100, 100, false, 2, 10, 10, null, 1));
		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 3, 100, 100, false, 2, 30, 10, null, 1));

		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 6, 100, 100, false, 2, 80, 10, null, 2));
		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 6, 100, 100, false, 2, 90, 10, null, 2));
		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 6, 100, 100, false, 2, 100, 10, null, 2));
		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 6, 100, 100, false, 2, 85, 10, null, 2));
		squaros.add(new Enemies(-900, 374, 0, 0, 50, 50, 6, 100, 100, false, 2, 95, 10, null, 2));
		
		
	}

}
