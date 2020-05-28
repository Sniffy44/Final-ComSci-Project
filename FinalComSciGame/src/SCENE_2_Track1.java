import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SCENE_2_Track1 extends Scene {

	ArrayList<Double> fps = new ArrayList<Double>();

	Font fntSmall = new Font("Yu Gothic UI Semilight", 0, 35);
	Font fntSmall2 = new Font("Bahnschrift", 0, 35); // i likie

	LevelManager lvlManager;

	Button buttonLevelStart;
	Button turret1Icon;

	double frameStart = 0;

	ArrayList<Enemies> squaros = new ArrayList<Enemies>();

	ArrayList<Turret> turrets = new ArrayList<Turret>();

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	ArrayList<Path> segments = new ArrayList<Path>();

	BufferedImage track1Image;
	BufferedImage track1ImageBright;
	BufferedImage turret1Image;

	public static int lives = 10;
	int fullLives = 10;

	int livesMover;

	boolean mouseIsPressingT1 = false;
	boolean canPlace = true;

	Turret turretSelected = null;

	Color tinter;
	Color whiteBlue = new Color(190, 255, 255);
	Color dimBlue = new Color(100, 100, 100, 50);

	float alpha = 1.0f; // draw half transparent
	float alpha2 = 1.0f; // draw half transparent

	float alphaHalf = 0.3f; // draw half transparent

	AlphaComposite ac2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha2);
	AlphaComposite acHalf = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaHalf);

	Money money = new Money();

	Rect mouseHitbox;

	int level = 0;
	public static boolean levelIsActive = false;

	public void draw(Graphics g) { // |||||||||||||||||||||||||||||||||||||||||||||||| DRAW
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.drawImage(track1Image, -10, 0, Driver.screenWidth, Driver.screenHeight, null);

		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha); // changes opacity of bright
																						// track
		((Graphics2D) g).setComposite(ac);
		g2.drawImage(track1ImageBright, -10, 0, Driver.screenWidth, Driver.screenHeight, null);
		((Graphics2D) g).setComposite(ac2);

		if (lives < 10) {
			livesMover = 6; // makes life counter move to be centered
		} else
			livesMover = 0;
		g.setFont(fntSmall2);
		g.setColor(whiteBlue);
		g.drawString("" + lives, 345 + livesMover, 858);

		g.drawString("Round  " + level, 30, 50);
		g.drawString("$" + money.money, 30, 100);

		for (int i = 0; i < squaros.size(); i++) { // draws coins items with arrayList
			squaros.get(i).draw(g2);
		}
		for (Turret t : turrets) {
			t.draw(g2);
		}
		for (Projectile p : projectiles) {
			p.draw(g2);
		}
		// for (Path s : segments) {
		// s.draw(g2);
		// }

		buttonLevelStart.draw(g, 18, 60);
		// turret1Icon.draw(g, 28, 60);

		if (mouseIsPressingT1) {
			((Graphics2D) g).setComposite(acHalf);
			if (!canPlace)
				g.setColor(Color.red);
			if (canPlace)
				g.setColor(Color.gray);
			g.fillOval((int) InputManager.mPos.x - BasicTurret.range, (int) InputManager.mPos.y - BasicTurret.range,
					BasicTurret.range * 2, BasicTurret.range * 2);
			g2.drawImage(turret1Image, (int) InputManager.mPos.x - BasicTurret.width / 2,
					(int) InputManager.mPos.y - BasicTurret.height / 2, BasicTurret.width, BasicTurret.height, null);

			((Graphics2D) g).setComposite(ac2);
		}

		if (turretSelected != null) { // SELECTED TURRET INFORMATION SCREEN
			g.drawImage(turretSelected.texture, 700, 80, 100, 100, null);
			g.setColor(whiteBlue);
			g.drawString("Range:  " + turretSelected.range, 1100, 70);
			g.drawString("Firerate:  " + (double) 60 / turretSelected.firerate, 1100, 100);

			g.setColor(Color.white);
			g2.drawOval(turretSelected.x - turretSelected.range, turretSelected.y - turretSelected.range,
					turretSelected.range * 2, turretSelected.range * 2);
			g2.setPaint(dimBlue);
			g2.fillOval(turretSelected.x - turretSelected.range, turretSelected.y - turretSelected.range,
					turretSelected.range * 2, turretSelected.range * 2);
		}
		// if (mouseIsPressingT1 == true) {
		// g.setColor(Color.white);
		// mouseHitbox.draw(g2);
		// }
		// FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS
		// \\
		fps.add((double) (1 / ((System.currentTimeMillis() - frameStart) / 1000)));
		if (fps.size() >= 60) {
			fps.remove(0);
		}
		double sum = 0;
		for (Double d : fps) {
			sum += d;
		}
		double avg = sum / fps.size();
		g.setFont(fntSmall2);
		g.setColor(whiteBlue);
		g.drawString((int) avg + "", Driver.screenWidth - 60, 40);
		frameStart = System.currentTimeMillis();

	} // ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
		// END OF DRAW

	public void update() { // ||||||||||||||||||||||||||| UPDATE START

		buttonLevelStart.update();
		turret1Icon.update();
		lvlManager.update(squaros, level);

		if (squaros.size() == 0) {
			if (buttonLevelStart.clicked) {
				level++;
				// levelIsActive = true;

				if (level == 1)
					lvlManager.levelOneT1(squaros);
				if (level == 2)
					lvlManager.levelTwoT1(squaros);

			}
		}

		if (turret1Icon.glowing && InputManager.mouse[1] && money.money >= BasicTurret.price) { //
			mouseIsPressingT1 = true;
		}
		if (mouseIsPressingT1 == true) {

			mouseHitbox = new Rect(800, 800, 300, 50);
			mouseHitbox.pos.x = InputManager.mPos.x - BasicTurret.width / 2;
			mouseHitbox.pos.y = InputManager.mPos.y - BasicTurret.height / 2;
			mouseHitbox.w = BasicTurret.width;
			mouseHitbox.h = BasicTurret.height;
		}

		if (mouseIsPressingT1 == true) {
			canPlace = true;
			for (int i = 0; i < segments.size(); i++) {
				if (mouseHitbox.intersects(segments.get(i).hitbox)) {
					canPlace = false;
					break;
				}
			}
			for (int i = 0; i < turrets.size(); i++) {
				if (mouseHitbox.intersects(turrets.get(i).hitbox)) {
					canPlace = false;
					break;
				}
			}
		}
		// System.out.println(canPlace);
		if (InputManager.mouseReleased[1]) {
			if (canPlace && mouseIsPressingT1) {
				turrets.add(new BasicTurret((int) InputManager.mPos.x, (int) InputManager.mPos.y, 0, 0));
				money.money -= BasicTurret.price;
			}
			mouseIsPressingT1 = false;
		}
		if (InputManager.mouseReleased[1]) { // click on turret, shows turret info and upgrade etc.
			for (Turret t : turrets) {
				if (InputManager.mPos.inside(t.hitbox)) {
					turretSelected = t;
					break;
				}
				turretSelected = null;
			}

		}
		if (turretSelected != null) { // SELECTED TURRET INFORMATION SCREEN

		}

		for (int i = 0; i < squaros.size(); i++) {
			squaros.get(i).update(squaros, money, segments);
		}

		for (Turret t : turrets) {
			t.update(squaros, projectiles);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update(squaros, turrets, projectiles);
		}

		alpha = (float) ((double) lives / (double) fullLives);
		// tinter = new Color(0, 0, 0, BgOpacityChanger);

		if (InputManager.keysReleased[32] && squaros.size() == 0) {
			level++;

			if (level == 1)
				lvlManager.levelOneT1(squaros);
			if (level == 2)
				lvlManager.levelTwoT1(squaros);
		}
		// if(level == 1) System.out.println(levelTime);

	} // ||||||||||||||||||||||||||||||||||||||||||||||| END OF UPDATE

	public void init() {
		track1Image = Misc.loadImage("/TrackOneUI_Graphic.png");
		track1ImageBright = Misc.loadImage("/TrackOneUI_littleLines_BRIGHT2.png");
		turret1Image = Misc.loadImage("/BasicTurretGraphic.png");

		Driver.track = 1;
		lvlManager = new LevelManager();

		money.money = 40;

		//turrets.add(new BasicTurret(960, 480, 0, 0));
		//turrets.add(new BasicTurret(1400, 350, 0, 0));

		segments.add(new Path(355, 841, 10, 10, false, 0)); // ending box
		segments.add(new Path(310, 798, 100, 100, false, -10)); // buffer box at end, prevent turret on end
		// ikaguf
		segments.add(new Path(-200, 487, 770, 10, false, 1));
		segments.add(new Path(584, 487, 10, 10, true, 2)); // diagonal boxes
		for (int i = 0; i < 4; i++) {
			segments.add(new Path(595 + i * 15, 472 - i * 15, 10, 10, true, 2.1));
		}
		segments.add(new Path(650, 410, 615, 10, false, 3));
		segments.add(new Path(1290, 410, 160, 10, false, 4));

		segments.add(new Path(1455, 280, 10, 150, false, 5)); // vertical up
		segments.add(new Path(1290, 260, 180, 10, false, 6));
		segments.add(new Path(1274, 255, 10, 150, false, 7)); // vertical down
		segments.add(new Path(1274, 435, 10, 280, false, 8)); // vertical down

		segments.add(new Path(1147, 731, 140, 10, false, 9));
		segments.add(new Path(870, 731, 250, 10, false, 10));

		segments.add(new Path(847, 730, 10, 200, false, 11)); // vertical down

		segments.add(new Path(845, 940, 270, 10, false, 12)); // right
		segments.add(new Path(1129, 750, 10, 210, false, 13)); // vertical up
		segments.add(new Path(1129, 680, 10, 45, false, 14)); // vertical up

		segments.add(new Path(1129, 661, 10, 10, true, 15)); // diagonal north_west
		for (int i = 0; i < 6; i++) {
			segments.add(new Path(1109 - i * 20, 645 - i * 20, 10, 10, true, 15.1));
		}
		segments.add(new Path(740, 525, 280, 10, false, 16));

		segments.add(new Path(713, 525, 10, 10, true, 17)); // diagonal south_west
		for (int i = 0; i < 7; i++) {
			segments.add(new Path(697 - i * 19, 545 + i * 19, 10, 10, true, 17.1));
		}
		segments.add(new Path(563, 670, 10, 155, false, 18)); // vertical down

		segments.add(new Path(400, 841, 180, 10, false, 19)); // left

		buttonLevelStart = new Button(new Rect(1700, 900, 200, 100), null, Color.black, "Start Round", Color.WHITE,
				fntSmall, true, Color.gray, false);

		turret1Icon = new Button(new Rect(1800, 175, 80, 80), null, Color.white, "", Color.WHITE, fntSmall, true,
				Color.gray, false);

	}

}
