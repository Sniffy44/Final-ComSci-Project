import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemies {

	double x, y, vx, vy;
	int width, height;
	double speed;
	int health;
	int fullHealth;
	boolean hasSpawned;
	int levell, time;
	int prize;
	BufferedImage texture;
	int identity;

	Rect hitbox;
	Rect pathHitbox;

	double healthRatio;

	// ArrayList<Enemies> squaros = new ArrayList<Enemies>();

	public Enemies(double x, double y, double vx, double vy, int width, int height, double speed, int health,
			int fullHealth, boolean hasSpawned, int levell, int time, int prize, BufferedImage texture, int identity) {
		super();
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.health = health;
		this.fullHealth = fullHealth;

		this.hasSpawned = hasSpawned;
		this.levell = levell;
		this.time = time;
		this.prize = prize;

		this.texture = texture;
		this.identity = identity;

		this.hitbox = new Rect(x, y, width, height);
		this.pathHitbox = new Rect(x, y, width, height);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (identity == 1) {
			g.setColor(Color.green);
			g.fillRect((int) x - width / 2, (int) y - height / 2, width, height);
		}

		if (identity == 2) {
			g.setColor(Color.red);
			g2.setStroke(new BasicStroke(8));
			g.drawOval((int) x - width / 2, (int) y - height / 2, width, height);
			g2.setStroke(new BasicStroke(1));
		}

		if (health - fullHealth < 0) {
			g.setColor(Color.red);
			g.fillRect((int) x - 30, (int) y - height / 2 - 20, 60, 10);
			g.setColor(Color.green);
			g.fillRect((int) x - 30, (int) y - height / 2 - 20, (int) (healthRatio * 60), 10);
		}

		g.setColor(Color.white);
		// hitbox.draw(g2);

		g.setColor(Color.blue);
		pathHitbox.draw(g2);

	}

	public void update(ArrayList<Enemies> squaros, Money money) {
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

		healthRatio = (double) health / fullHealth;

		for (Enemies i : squaros) { // fancy for loop for doing for stuff
			if (i.health <= 0) {
				money.money += i.prize;
				squaros.remove(i);
				break;
			}
			if (i.hasSpawned) {
				if (i.x < -150) {
					money.money += i.prize;
					squaros.remove(i);
					break;
				}
				if (i.x > 1970) {
					money.money += i.prize;
					squaros.remove(i);
					break;
				}
				if (i.y < -50) {
					money.money += i.prize;
					squaros.remove(i);
					break;
				}
				if (i.y > 1130) {
					money.money += i.prize;
					squaros.remove(i);
					break;
				}
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

						if (Path.segments.get(i).identity == 2 || Path.segments.get(i).identity == 2.1) { // -----first
																											// diagonal
																											// (north-east)
							// squaros.get(j).x = Path.segments.get(i).x + 5;
							squaros.get(j).vx = Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
							squaros.get(j).vy = -Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
						}

						if (Path.segments.get(i).identity == 3 || Path.segments.get(i).identity == 4
								|| Path.segments.get(i).identity == 12) { // RIGHT riGHt Right RIGHt rIGHt RIGHT
							squaros.get(j).y = Path.segments.get(i).y + 5;
							squaros.get(j).vx = squaros.get(j).speed;
							squaros.get(j).vy = 0;
						}

						if (Path.segments.get(i).identity == 5 || Path.segments.get(i).identity == 13) { // vertical UP
							squaros.get(j).x = Path.segments.get(i).x + 5;
							squaros.get(j).vx = 0;
							squaros.get(j).vy = -squaros.get(j).speed;
						}

						if (Path.segments.get(i).identity == 6 || Path.segments.get(i).identity == 9
								|| Path.segments.get(i).identity == 10 || Path.segments.get(i).identity == 16
								|| Path.segments.get(i).identity == 19) { // LEFT LEft LEFT left LEft
							squaros.get(j).y = Path.segments.get(i).y + 5;
							squaros.get(j).vx = -squaros.get(j).speed;
							squaros.get(j).vy = 0;
						}
						if (Path.segments.get(i).identity == 7 || Path.segments.get(i).identity == 8
								|| Path.segments.get(i).identity == 11 || Path.segments.get(i).identity == 18) { // vertical
																													// DOWN
							squaros.get(j).x = Path.segments.get(i).x + 5;
							squaros.get(j).vx = 0;
							squaros.get(j).vy = squaros.get(j).speed;
						}
						if (Path.segments.get(i).identity == 15 || Path.segments.get(i).identity == 15.1) { // -----
																											// diagonal
																											// (north-west)
							// squaros.get(j).y = Path.segments.get(i).y + 5;
							squaros.get(j).vx = -Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
							squaros.get(j).vy = -Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
						}

						if (Path.segments.get(i).identity == 17 || Path.segments.get(i).identity == 17.1) { // -----
																											// diagonal
																											// (north-west)
							// squaros.get(j).y = Path.segments.get(i).y + 5;
							squaros.get(j).vx = -Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
							squaros.get(j).vy = Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
						}

						// FINAL
						if (Path.segments.get(i).identity == 0) {
							squaros.remove(j);
							SCENE_2_Track1.lives--;

							break;
						}
					}

					// MAKES MAIN ENEMY HITBOX HIT LINES
//					if (squaros.get(j).hitbox.intersects(Path.segments.get(i).hitbox) && Path.segments.get(i).identity > 100) {
//						
//						if (Path.segments.get(i).identity == 104.1) { //support diagonal (south-east)
//							squaros.get(j).vx = Math.sqrt((squaros.get(j).speed*squaros.get(j).speed)/2);
//							squaros.get(j).vy = Math.sqrt((squaros.get(j).speed*squaros.get(j).speed)/2);
//						}
//					}

				}
			}
		}

	}

}
