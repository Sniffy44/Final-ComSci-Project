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
	double identity;

	Rect hitbox;
	Rect pathHitbox;

	double healthRatio;

	int distanceTravelled;

	int frames = 0;

	BufferedImage enemy1_1 = Misc.loadImage("/Enemy1-1.png");
	BufferedImage enemy1_2 = Misc.loadImage("/Enemy1-2.png");
	BufferedImage enemy2 = Misc.loadImage("/Enemy2.png");
	BufferedImage enemy3 = Misc.loadImage("/Enemy3.png");
	BufferedImage enemy4 = Misc.loadImage("/Enemy4.png");
	BufferedImage enemy4_1 = Misc.loadImage("/Enemy4-1.png");
	BufferedImage enemy5 = Misc.loadImage("/Enemy5.png");

	// ArrayList<Enemies> squaros = new ArrayList<Enemies>();

	public Enemies(double x, double y, double vx, double vy, int width, int height, double speed, int health,
			int fullHealth, boolean hasSpawned, int levell, int time, int prize, BufferedImage texture,
			double identity) {
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
		// this.hasRegen = hasRegen;

		this.texture = texture;
		this.identity = identity;

		this.hitbox = new Rect(x, y, width, height);
		this.pathHitbox = new Rect(x, y, width, height);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (identity == 1) {
			g2.drawImage(enemy1_1, (int) x - width / 2, (int) y - height / 2, width, height, null);
		}
		if (identity == 1.1) {
			g2.drawImage(enemy1_2, (int) x - width / 2, (int) y - height / 2, width, height, null);
		}

		if (identity == 2) {
			g2.rotate((double) frames / 15, x, y);
			g2.drawImage(enemy2, (int) x - width / 2, (int) y - height / 2, width, height, null);
			g2.rotate(-(double) frames / 15, x, y);
		}
		if (identity == 3) {
			g2.rotate((double) frames / 30, x, y);
			g2.drawImage(enemy3, (int) x - width / 2, (int) y - height / 2, width, height, null);
			g2.rotate(-(double) frames / 30, x, y);

		}
		if (identity == 3) {
			g2.rotate((double) frames / 30, x, y);
			g2.drawImage(enemy3, (int) x - width / 2, (int) y - height / 2, width, height, null);
			g2.rotate(-(double) frames / 30, x, y);

		}
		if (identity == 4) {
			g2.rotate((double) frames / 40, x, y);
			g2.drawImage(enemy4, (int) x - width / 2, (int) y - height / 2, width, height, null);
			g2.rotate(-(double) frames / 40, x, y);

		}
		if (identity == 4.1) {
			g2.drawImage(enemy4_1, (int) x - width / 2, (int) y - height / 2, width, height, null);
		}
		if (identity == 5) {
			g2.drawImage(enemy5, (int) x - width / 2, (int) y - height / 2, width, height, null);

		}

		if (health - fullHealth < 0) {
			g.setColor(Color.red);
			g.fillRect((int) x - 30, (int) y - height / 2 - 20, 60, 10);
			g.setColor(Color.green);
			g.fillRect((int) x - 30, (int) y - height / 2 - 20, (int) (healthRatio * 60), 10);
		}


//		g.setColor(Color.blue);
//		pathHitbox.draw(g2);

	}

	public void update(ArrayList<Enemies> squaros, Money money, ArrayList<Path> segments, int level) {
		x += vx;
		y += vy;

		distanceTravelled += (int) (Math.abs(vx) + Math.abs(vy));

		hitbox.pos.x = x - width / 2;
		hitbox.pos.y = y - height / 2;
		hitbox.w = width;
		hitbox.h = height;

		pathHitbox.pos.x = x - 1;
		pathHitbox.pos.y = y - 1;
		pathHitbox.w = 3;
		pathHitbox.h = 3;

		healthRatio = (double) health / fullHealth;

		if (hasSpawned && health < fullHealth) { // healing of certain enemies
			if (identity == 3) {
				if (frames % (4 - (int) level / 8) == 0) {
					health++;
				}
			}
			if (identity == 4) {
				if (frames % (12 - (int) level / 8) == 0) {
					health++;
				}
			}
			if (identity == 5) {
				if (frames % (9 - (int) level / 8) == 0) {
					health++;
				}
			}
		}
		if (identity == 4.1) {
			if (Misc.rBt(0, 400) == 69) { // Eggs become non-egg adults
				squaros.add(new Enemies(x, y, 1, 0, 50, 50, 1.8 + ((double) (level) * .1), 90, 90, true, -1, 0,
						8 + level / 2, null, 4));
				squaros.remove(this);
			}
		}

		if (health <= 0) {
			money.money += prize;
			
			if (identity == 4) { // this section is for when enemy4 dies and spawns in eggs
//					int launchAngle = Misc.rBt(0, 6);
//					double pvx = Math.sin(launchAngle) * 5;
//					double pvy = -Math.cos(launchAngle) * 5;

				if (Misc.rBt(0, 1) == 1) {
					squaros.add(new Enemies(x, y, 0, 0, 30, 30, 0, fullHealth * 2, fullHealth * 2, true, -1, 0,
							2 + level / 2, null, 4.1));
				}
				if (Misc.rBt(0, 3) == 0) {
					squaros.add(new Enemies(x - 20, y - 20, -2, -2, 30, 30, 0, fullHealth * 2, fullHealth * 2, true, -1,
							0, 2 + level / 2, null, 4.1));
				}
				if (Misc.rBt(0, 3) == 0) {
					squaros.add(new Enemies(x + 20, y + 20, 2, 2, 30, 30, 0, fullHealth * 2, fullHealth * 2, true, -1,
							0, 2 + level / 2, null, 4.1));
				}
			}
			squaros.remove(this);
			

		}
		if (hasSpawned) {
			if (x < -150 || x > 1970 || y < -50 || y > 1130) {
				if (identity == 4.1) {
					money.money += prize;
					squaros.remove(this);

				} else {
					x = -100;
					y = 490;
					distanceTravelled = 0;
				}
			}

		}

		if (Driver.track == 1) { // TRACK ONE INFO COLLISIONS YAY
			for (int i = 0; i < segments.size(); i++) {
				for (int j = 0; j < squaros.size(); j++) {
					if (squaros.get(j).pathHitbox.intersects(segments.get(i).hitbox)) {

						if (segments.get(i).identity == 1) {
							squaros.get(j).y = segments.get(i).y + 5;
							squaros.get(j).vx = squaros.get(j).speed;
							squaros.get(j).vy = 0;
						}

						if (segments.get(i).identity == 2 || segments.get(i).identity == 2.1) { // -----first
																								// diagonal
																								// (north-east)
							// squaros.get(j).x = segments.get(i).x + 5;
							squaros.get(j).vx = Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
							squaros.get(j).vy = -Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
						}

						if (segments.get(i).identity == 3 || segments.get(i).identity == 4
								|| segments.get(i).identity == 12) { // RIGHT riGHt Right RIGHt rIGHt RIGHT
							squaros.get(j).y = segments.get(i).y + 5;
							squaros.get(j).vx = squaros.get(j).speed;
							squaros.get(j).vy = 0;
						}

						if (segments.get(i).identity == 5 || segments.get(i).identity == 13) { // vertical UP
							squaros.get(j).x = segments.get(i).x + 5;
							squaros.get(j).vx = 0;
							squaros.get(j).vy = -squaros.get(j).speed;
						}

						if (segments.get(i).identity == 6 || segments.get(i).identity == 9
								|| segments.get(i).identity == 10 || segments.get(i).identity == 16
								|| segments.get(i).identity == 19) { // LEFT LEft LEFT left LEft
							squaros.get(j).y = segments.get(i).y + 5;
							squaros.get(j).vx = -squaros.get(j).speed;
							squaros.get(j).vy = 0;
						}
						if (segments.get(i).identity == 7 || segments.get(i).identity == 8
								|| segments.get(i).identity == 11 || segments.get(i).identity == 18) { // vertical
																										// DOWN
							squaros.get(j).x = segments.get(i).x + 5;
							squaros.get(j).vx = 0;
							squaros.get(j).vy = squaros.get(j).speed;
						}
						if (segments.get(i).identity == 15 || segments.get(i).identity == 15.1) { // -----
																									// diagonal
																									// (north-west)
							// squaros.get(j).y = segments.get(i).y + 5;
							squaros.get(j).vx = -Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
							squaros.get(j).vy = -Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
						}

						if (segments.get(i).identity == 17 || segments.get(i).identity == 17.1) { // -----
																									// diagonal
																									// (north-west)
							// squaros.get(j).y = segments.get(i).y + 5;
							squaros.get(j).vx = -Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
							squaros.get(j).vy = Math.sqrt((squaros.get(j).speed * squaros.get(j).speed) / 2);
						}

						// FINAL
						if (segments.get(i).identity == 0) {
							squaros.remove(j);
							SCENE_2_Track1.lives--;

							break;
						}
					}

					// MAKES MAIN ENEMY HITBOX HIT LINES
//					if (squaros.get(j).hitbox.intersects(segments.get(i).hitbox) && segments.get(i).identity > 100) {
//						
//						if (segments.get(i).identity == 104.1) { //support diagonal (south-east)
//							squaros.get(j).vx = Math.sqrt((squaros.get(j).speed*squaros.get(j).speed)/2);
//							squaros.get(j).vy = Math.sqrt((squaros.get(j).speed*squaros.get(j).speed)/2);
//						}
//					}

				}
			}
		}
		frames++;
	}

}
