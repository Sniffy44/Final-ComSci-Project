import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Turret2Spread extends Turret {

	static int baseUpgradeLvl = 1;
	boolean lockedOn = false;
	int timeSLS;

	static double baseFireSpeed = 10.0;
	static int baseFirerate = 60; // INVERSE ([how many frames between shots])

	static int baseWidth = 70;
	static int baseHeight = 70;
	static int basePrice = 20;
	static int baseRange = 100;
	static int baseDamage = 1;
	static int baseNetWorth = 20;
	static boolean baseButton1aPressed = false;
	static boolean baseButton2aPressed = false;
	static boolean baseButton1bPressed = false;
	static boolean baseButton2bPressed = false;
	
	static BufferedImage lvl1upgrade = Misc.loadImage("/Turret2Spread.png");
	//static BufferedImage lvl2upgrade = Misc.loadImage("/Turret1Basic_lvl2.png");

	public Turret2Spread(int x, int y, double rotation, int identity) {
		super(x, y, baseWidth, baseHeight, basePrice, rotation, baseRange, baseDamage, baseFirerate, baseFireSpeed,
				baseUpgradeLvl, baseNetWorth, baseButton1aPressed, baseButton2aPressed, baseButton1bPressed,
				baseButton2bPressed, lvl1upgrade, identity);

	}

	@Override
	public void update(ArrayList<Enemies> squaros, ArrayList<Projectile> projectiles) {
		lockedOn = false;
		for (Enemies s : squaros) {
			if (new Point(x, y).distanceTo(new Point(s.x, s.y)) < range) {
				lockedOn = true;

			}
		}

		if (lockedOn && timeSLS >= firerate) {
			// double pvx2 = Math.sin(3*Math.PI)*fireSpeed; // left-up
			// double pvy2 = -Math.cos(rotation)*fireSpeed;
			// projectiles.add(new Projectile(x, y, 6, 6, -fireSpeed, 0, 40, 1, null, 2));
			// // 1
			for (double i = -3; i < 5; i++) {
				projectiles.add(new Projectile(x, y, 6, 6, Math.sin(Math.PI * (i / 4)) * fireSpeed,
						Math.cos(Math.PI * (i / 4)) * fireSpeed, 40, 1, 12, null, 2));

			}
			timeSLS = 0;
			// System.out.println(pvx + " " + pvy);
		}

		timeSLS++;
		
		if (upgradeLvl == 1)
			texture = lvl1upgrade;
	//	if (upgradeLvl == 2)
			//texture = lvl2upgrade;
	}

}
