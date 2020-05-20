import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemies {

	double x, y, vx, vy;
	int width, height;
	int speed;
	int health;
	boolean hasSpawned;
	int levell, time;
	BufferedImage texture;
	int identity;

	Rect hitbox;
	Rect pathHitbox;

	// ArrayList<Enemies> squaros = new ArrayList<Enemies>();

	public Enemies(double x, double y, double vx, double vy, int width, int height, int speed, int health,
			boolean hasSpawned, int levell, int time, BufferedImage texture, int identity) {
		super();
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.health = health;
		
		this.hasSpawned = hasSpawned;
		this.levell = levell;
		this.time = time;
		
		this.texture = texture;
		this.identity = identity;

		this.hitbox = new Rect(x, y, width, height);
		this.pathHitbox = new Rect(x, y, width, height);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		if (identity == 1) {
			g.setColor(Color.green);
			g.fillRect((int) x - width / 2, (int) y - height / 2, width, height);
		}
		
		if(identity == 2) {
			g.setColor(Color.red);
			g2.setStroke(new BasicStroke(8));
			g.drawOval((int)x - width / 2, (int)y - height / 2, width, height);
			g2.setStroke(new BasicStroke(1));
		}


		g.setColor(Color.white);
		//hitbox.draw(g2);

		g.setColor(Color.blue);
		pathHitbox.draw(g2);

	}

	public void update(ArrayList<Enemies> squaros) {
		x += vx;
		y += vy;

		hitbox.pos.x = x - width / 2;
		hitbox.pos.y = y - height / 2;
		hitbox.w = width;
		hitbox.h = height;

		pathHitbox.pos.x = x - 1;
		pathHitbox.pos.y = y - 1;
		pathHitbox.w = 3;
		pathHitbox.h = 3;

		for (Enemies i : squaros) { // fancy for loop for doing for stuff
			if (i.health <= 0) {
				squaros.remove(i);
				break;
			}
		}

		if (Driver.track == 1) { // TRACK ONE INFO COLLISIONS YAY
			for (int i = 0; i < Path.segments.size(); i++) {
				for (int j = 0; j < squaros.size(); j++) {
					if (squaros.get(j).pathHitbox.intersects(Path.segments.get(i).hitbox)) {

						if (Path.segments.get(i).identity == 1) {
							squaros.get(j).y = Path.segments.get(i).y + 5;
							squaros.get(j).vx = squaros.get(j).speed;
							squaros.get(j).vy = 0;
						}

						if (Path.segments.get(i).identity == 2) {
							squaros.get(j).x = Path.segments.get(i).x + 5;
							squaros.get(j).vx = 0;
							squaros.get(j).vy = squaros.get(j).speed;
						}

						if (Path.segments.get(i).identity == 3) {
							squaros.get(j).y = Path.segments.get(i).y + 5;
							squaros.get(j).vx = -squaros.get(j).speed;
							squaros.get(j).vy = 0;
						}

						if (Path.segments.get(i).identity == 0) {
							squaros.remove(j);
							SCENE_2_Track1.lives--;
							break;
						}
					}
				}
			}
		}

	}

}
