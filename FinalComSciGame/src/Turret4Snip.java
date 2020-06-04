import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Turret4Snip extends Turret {

	static int baseUpgradeLvl = 1;
	boolean lockedOn = false;
	int timeSLS;

	static double baseFireSpeed = 100;
	static int baseFirerate = 180; // INVERSE ([how many frames between shots])

	static int baseWidth = 70;
	static int baseHeight = 70;
	static int basePrice = 100;
	static int baseRange = 1900;
	static int baseDamage = 100;
	static int baseNetWorth = 100;
	static int baseNumCollisions = 1;
	static boolean baseButton1aPressed = false;
	static boolean baseButton2aPressed = false;
	static boolean baseButton1bPressed = false;
	static boolean baseButton2bPressed = false;
	static boolean baseButtonSpecialPressed = false;

	static int baseUpg1aPrice = 42;
	static int baseUpg2aPrice = 42;
	static int baseUpg1bPrice = 70;
	static int baseUpg2bPrice = 70;
	static int baseUpgMasterPrice = 145;

	static boolean baseIsSold = false;
	
	int stationaryTargetEnemyx;
	int stationaryTargetEnemyy;
	

	// static BufferedImage texture;

	static BufferedImage lvl1upgrade = Misc.loadImage("/Turret4Snip_lvl1_main.png");
	static BufferedImage lvl1upgradeTop = Misc.loadImage("/Turret4Snip_lvl1_top.png");
	static BufferedImage lvl1upgradeBase = Misc.loadImage("/Turret4Snip_lvl1_base.png");

	static BufferedImage lvl2upgrade = Misc.loadImage("/Turret4Snip_lvl2_main.png");
	static BufferedImage lvl2upgradeTop = Misc.loadImage("/Turret4Snip_lvl2_top.png");
//	static BufferedImage lvl2upgradeBase = Misc.loadImage("/Turret3Rapid_lvl2_base.png");
//
	static BufferedImage lvl3upgrade = Misc.loadImage("/Turret4Snip_lvl3_main.png");
	static BufferedImage lvl3upgradeTop = Misc.loadImage("/Turret4Snip_lvl3_top.png");
//	static BufferedImage lvl3upgradeBase = Misc.loadImage("/Turret3Rapid_lvl3_base.png");
//	
	static BufferedImage lvl4upgrade = Misc.loadImage("/Turret4Snip_lvlMax_main.png");
	static BufferedImage lvl4upgradeTop = Misc.loadImage("/Turret4Snip_lvlMax_top.png");
	static BufferedImage lvl4upgradeBase = Misc.loadImage("/Turret4Snip_lvlMax_base.png");
	

	public Turret4Snip(int x, int y, double rotation, int identity) {
		super(x, y, baseWidth, baseHeight, basePrice, rotation, baseRange, baseDamage, baseFirerate, baseFireSpeed,
				baseUpgradeLvl, baseNetWorth, baseButton1aPressed, baseButton2aPressed, baseButton1bPressed,
				baseButton2bPressed, baseButtonSpecialPressed, baseUpg1aPrice, baseUpg2aPrice, baseUpg1bPrice,
				baseUpg2bPrice, baseUpgMasterPrice, baseIsSold, baseNumCollisions, lvl1upgrade, lvl1upgradeTop,
				lvl1upgradeBase, identity);

	}

	@Override
	public void update(ArrayList<Enemies> squaros, ArrayList<Projectile> projectiles, ArrayList<Line> lines) {
		lockedOn = false;
		ArrayList<Enemies> enemiesInRange = new ArrayList<Enemies>();

		for (Enemies s : squaros) {
			if (new Point(x, y).distanceTo(new Point(s.x, s.y)) < range) {
				enemiesInRange.add(s);

			}
		}
		if (enemiesInRange.size() != 0) {
			Enemies targetEnemy = enemiesInRange.get(0);
			for (Enemies s : enemiesInRange) {
				if (s.distanceTravelled > targetEnemy.distanceTravelled) {
					targetEnemy = s;
				}
			}
			
			lockedOn = true;
			if (lockedOn && timeSLS >= firerate) {
				
				projectiles.add(new Projectile(targetEnemy.x, targetEnemy.y, 3, 3, 0, 0, damage, numCollisions, 3, null, 5));				
				stationaryTargetEnemyx = (int) targetEnemy.x;
				stationaryTargetEnemyy = (int) targetEnemy.y;
				lines.add(new Line(x, y, stationaryTargetEnemyx, stationaryTargetEnemyy, 20 + upgradeLvl*20, 0 + upgradeLvl));
				timeSLS = 0;			
			}
			double angleTo = new Point(x, y).angleTo(new Point(targetEnemy.x, targetEnemy.y));
			rotation = angleTo - Math.PI / 2;
			lockedOn = true;
			
		}
		
		
		timeSLS++;

		if (upgradeLvl == 1) {
			texture = lvl1upgrade;
			textureTop = lvl1upgradeTop;
			textureBase = lvl1upgradeBase;
		}
		if (upgradeLvl == 2) {
			texture = lvl2upgrade;
			textureTop = lvl2upgradeTop;
//			textureBase = lvl2upgradeBase;
		}
		if (upgradeLvl == 3) {
			texture = lvl3upgrade;
			textureTop = lvl3upgradeTop;
//			textureBase = lvl3upgradeBase;
		}
		if (upgradeLvl == 4) {
			texture = lvl4upgrade;
			textureTop = lvl4upgradeTop;
			textureBase = lvl4upgradeBase;
		}

	}

}
