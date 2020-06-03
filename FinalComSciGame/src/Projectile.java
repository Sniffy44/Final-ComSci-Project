import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Projectile {

	double x, y;
	int width, height;
	double vx, vy;
	int damage;
	int collisions;
	int ageLimit;
	BufferedImage texture;
	int identity;

	int age = 0;
	ArrayList<Enemies> hasHitList = new ArrayList<Enemies>();

	Rect hitbox1;
	Color dimPurple = new Color(75,0,130, 100);
	

	public Projectile(double x, double y, int width, int height, double vx, double vy, int damage, int collisions,
			int ageLimit, BufferedImage texture, int identity) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vx = vx;
		this.vy = vy;
		this.damage = damage;
		this.collisions = collisions;
		this.ageLimit = ageLimit;
		this.texture = texture;
		this.identity = identity;

		this.hitbox1 = new Rect(x, y, width, height);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (identity == 1) { // blue balls from basicTurrent
			g.setColor(Color.green);
			g.fillOval((int) x - width / 2, (int) y - height / 2, width, height);
			// hitbox1.draw(g2);
		}
		if (identity == 2) { // blue balls from basicTurrent
			g.setColor(new Color(147, 112, 219));
			g.fillOval((int) x - width / 2, (int) y - height / 2, width, height);
			// hitbox1.draw(g2);
		}
		if(identity == 3) {
			g2.setPaint(dimPurple);
			g.fillOval((int) x - width / 2, (int) y - height / 2, width, height);
			
		}

	}

	public void update(ArrayList<Enemies> squaros, ArrayList<Turret> turrets, ArrayList<Projectile> projectiles) {
		x += vx;
		y += vy;

		hitbox1.pos.x = x - width / 2;
		hitbox1.pos.y = y - height / 2;
		hitbox1.w = width;
		hitbox1.h = height;

//		for (int i = 0; i < squaros.size(); i++) {
//			for (int j = 0; j < projectiles.size(); j++) {
//				if (projectiles.get(j).hitbox1.intersects(squaros.get(i).hitbox)) {
//
//					if (!hasHitList.contains(squaros.get(i))) {
//						squaros.get(i).health -= projectiles.get(j).damage;
//						projectiles.get(j).collisions--;
//						hasHitList.add(squaros.get(i));
//
//						if (projectiles.get(j).collisions <= 0) {
//							projectiles.remove(j);
//							break;
//						}
//					}
//				}
//			}
//		}
		for (int i = 0; i < squaros.size(); i++) {
			if (hitbox1.intersects(squaros.get(i).hitbox)) {

				if (!hasHitList.contains(squaros.get(i))) {
					squaros.get(i).health -= damage;
					collisions--;
					hasHitList.add(squaros.get(i));

					if (collisions <= 0) {
						projectiles.remove(this);
						break;
					}
				}
			}
		}
		if(identity == 3) {
			width += 20;
			height += 20;
		}

		age++;
		if (age > ageLimit)
			projectiles.remove(this);

	}
}
