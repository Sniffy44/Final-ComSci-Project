import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Turret1Basic extends Turret {

	static int baseUpgradeLvl = 1;
	boolean lockedOn = false;
	int timeSLS;

	static double baseFireSpeed = 10;
	static int baseFirerate = 40; // INVERSE (lower number is faster)

	static int baseWidth = 70;
	static int baseHeight = 70;
	static int basePrice = 50;
	static int baseRange = 150;
	static int baseDamage = 40;
	static int baseNetWorth = 50;
	static int baseNumCollisions = 1;
	static boolean baseButton1aPressed = false;
	static boolean baseButton2aPressed = false;
	static boolean baseButton1bPressed = false;
	static boolean baseButton2bPressed = false;
	static boolean baseButtonSpecialPressed = false;

	static int baseUpg1aPrice = 30;
	static int baseUpg2aPrice = 30;
	static int baseUpg1bPrice = 55;
	static int baseUpg2bPrice = 55;
	static int baseUpgMasterPrice = 95;

	static boolean baseIsSold = false;

	// static BufferedImage texture;

	static BufferedImage lvl1upgrade = Misc.loadImage("/Turret1Basic.png");
	static BufferedImage lvl2upgrade = Misc.loadImage("/Turret1Basic_lvl2.png");
	static BufferedImage lvl3upgrade = Misc.loadImage("/Turret1Basic_lvl3.png");
	static BufferedImage lvl4upgrade = Misc.loadImage("/Turret1Basic_lvlMax.png");

	public Turret1Basic(int x, int y, double rotation, int identity) {
		super(x, y, baseWidth, baseHeight, basePrice, rotation, baseRange, baseDamage, baseFirerate, baseFireSpeed,
				baseUpgradeLvl, baseNetWorth, baseButton1aPressed, baseButton2aPressed, baseButton1bPressed,
				baseButton2bPressed, baseButtonSpecialPressed, baseUpg1aPrice, baseUpg2aPrice, baseUpg1bPrice,
				baseUpg2bPrice, baseUpgMasterPrice, baseIsSold, baseNumCollisions, lvl1upgrade, null, null, identity);

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
				if(s.distanceTravelled > targetEnemy.distanceTravelled) {
					targetEnemy = s;
				}		
			}
			double angleTo = new Point(x, y).angleTo(new Point(targetEnemy.x, targetEnemy.y));
			rotation = angleTo - Math.PI / 2;
			lockedOn = true;
		}

		if (lockedOn && timeSLS >= firerate) {
			double pvx = Math.sin(rotation) * fireSpeed;
			double pvy = -Math.cos(rotation) * fireSpeed;
			projectiles.add(new Projectile(x, y, 10, 10, pvx, pvy, damage, numCollisions, 100, null, 1));
			if (upgradeLvl == 4) {
				double pvxR = Math.sin(rotation + 0.3) * fireSpeed;
				double pvyR = -Math.cos(rotation + 0.3) * fireSpeed;
				double pvxL = Math.sin(rotation - 0.3) * fireSpeed;
				double pvyL = -Math.cos(rotation - 0.3) * fireSpeed;
				projectiles.add(new Projectile(x, y, 10, 10, pvxR, pvyR, 40, numCollisions, 100, null, 1));
				projectiles.add(new Projectile(x, y, 10, 10, pvxL, pvyL, 40, numCollisions, 100, null, 1));
			}
			timeSLS = 0;
			// System.out.println(pvx + " " + pvy);
		}
		timeSLS++;

		if (upgradeLvl == 1) // stuff for graphics of turret as it upgrades			
			texture = lvl1upgrade;
		if (upgradeLvl == 2)
			texture = lvl2upgrade;
		if (upgradeLvl == 3)
			texture = lvl3upgrade;
		if (upgradeLvl == 4)
			texture = lvl4upgrade;
	}

}
