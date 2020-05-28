import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BasicTurret extends Turret{
	
	int upgradeLvl;
	boolean lockedOn = false;
	int timeSLS;
	
	static int fireSpeed = 10;
	static int firerate = 40; // INVERSE (lower number is faster)
	
	static int width = 70;
	static int height = 70;
	static int price = 10;
	static int range = 150;
	static int damage = 1;
	
	public BasicTurret(int x, int y, double rotation, int identity) {
		super(x, y, width, height, price, rotation, range, damage, firerate, Misc.loadImage("/BasicTurretGraphic.png"), identity);
		
		
	}

	@Override
	public void update(ArrayList<Enemies> squaros, ArrayList<Projectile> projectiles) {
		lockedOn = false;
		for(Enemies s : squaros) {
			if(new Point(x,y).distanceTo(new Point(s.x, s.y)) < range) {
				double angleTo = new Point(x,y).angleTo(new Point(s.x, s.y));
				rotation = angleTo - Math.PI/2;
				lockedOn = true;
				
			}
		}
		
		if(lockedOn && timeSLS >= firerate) {
			double pvx = Math.sin(rotation)*fireSpeed;
			double pvy = -Math.cos(rotation)*fireSpeed;
			projectiles.add(new Projectile(x, y, 10, 10, pvx, pvy, 40, 1, null, 1));
			timeSLS = 0;
			//System.out.println(pvx + "  " + pvy);
		}
		
		
		
		timeSLS ++;
	}

	

}
