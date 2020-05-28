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
	Font fntSmall2 = new Font("Bahnschrift", 0, 35); //i likie
	
	LevelManager lvlManager;

	Button buttonLevelStart;

	double frameStart = 0;

	ArrayList<Enemies> squaros = new ArrayList<Enemies>();
	
	ArrayList<Turret> turrets = new ArrayList<Turret>();
	
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	BufferedImage track1Image;
	BufferedImage track1ImageBright;

	public static int lives = 10;
	int fullLives = 10;
	
	int livesMover;
	
	int BgOpacityChanger = 255;	
	Color tinter;
	Color whiteBlue = new Color(190, 255, 255);
	
	float alpha = 1.0f; //draw half transparent
	float alpha2 = 1.0f; //draw half transparent
		
		AlphaComposite ac2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha2);
	
	Money money = new Money();

	int level = 0;
	public static boolean levelIsActive = false;

	public void draw(Graphics g) { // |||||||||||||||||||||||||||||||||||||||||||||||| DRAW
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.drawImage(track1Image, -10, 0, Driver.screenWidth, Driver.screenHeight, null);
		
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha); // changes opacity of bright track
		((Graphics2D) g).setComposite(ac);
		g2.drawImage(track1ImageBright, -10, 0, Driver.screenWidth, Driver.screenHeight, null);
		((Graphics2D) g).setComposite(ac2);
		
		if(lives < 10) {
			livesMover = 6; // makes life counter move to be centered
		}else livesMover = 0;
		g.setFont(fntSmall2);
		g.setColor(whiteBlue);
		g.drawString("" + lives, 345 + livesMover, 858);
		
		g.drawString("Round  " + level, 30, 50);
		g.drawString("$" + money.money, 30, 100);

		for (int i = 0; i < squaros.size(); i++) { // draws coins items with arrayList
			squaros.get(i).draw(g2);
		}
		for(Turret t : turrets) {
			t.draw(g2);
		}
		for(Projectile p : projectiles) {
			p.draw(g2);
		}
		//for(Path s : Path.segments) {
			//s.draw(g2);
		//}

		buttonLevelStart.draw(g, 28, 60);

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
		lvlManager.update(squaros, level);;
		
		if (squaros.size() == 0) {
			if (buttonLevelStart.clicked) {
				level ++;
				//levelIsActive = true;
				
				if(level == 1) lvlManager.levelOneT1(squaros);
				if(level == 2) lvlManager.levelTwoT1(squaros);
				
			}
		}
		
		for (int i = 0; i < squaros.size(); i++) {
			squaros.get(i).update(squaros, money);
		}
		
		
		for(Turret t : turrets) {
			t.update(squaros, projectiles);
		}
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update(squaros, turrets, projectiles);
		}
		
		alpha = (float) ((double)lives/(double)fullLives);
		//tinter = new Color(0, 0, 0, BgOpacityChanger);
		
		if(InputManager.keysReleased[32] && squaros.size() == 0) {
			level ++;
			
			if(level == 1) lvlManager.levelOneT1(squaros);
			if(level == 2) lvlManager.levelTwoT1(squaros);
		}
		//if(level == 1) System.out.println(levelTime);
		
	} // ||||||||||||||||||||||||||||||||||||||||||||||| END OF UPDATE

	public void init() {
		track1Image = Misc.loadImage("/TrackOneUI_Graphic.png");
		track1ImageBright = Misc.loadImage("/TrackOneUI_littleLines_BRIGHT2.png");
		Driver.track = 1;
		lvlManager = new LevelManager();

		turrets.add(new BasicTurret(960, 480, 0, 0));
		turrets.add(new BasicTurret(1400, 350, 0, 0));
		

		Path.segments.add(new Path(355, 841, 10, 10, false, 0)); // ending box
		// ikaguf
		Path.segments.add(new Path(-200, 487, 770, 10, false, 1));
		Path.segments.add(new Path(584, 487, 10, 10, true, 2)); // diagonal boxes
		for(int i = 0; i < 4; i ++) {
			Path.segments.add(new Path(595 + i*15, 472 - i*15, 10, 10, true, 2.1));
		}
		Path.segments.add(new Path(650, 410, 615, 10, false, 3));
		Path.segments.add(new Path(1290, 410, 160, 10, false, 4));
		
		Path.segments.add(new Path(1455, 280, 10, 150, false, 5)); // vertical up
		Path.segments.add(new Path(1290, 260, 180, 10, false, 6));
		Path.segments.add(new Path(1274, 255, 10, 150, false, 7)); // vertical down
		Path.segments.add(new Path(1274, 435, 10, 280, false, 8)); // vertical down
		
		Path.segments.add(new Path(1147, 731, 140, 10, false, 9));
		Path.segments.add(new Path(870, 731, 250, 10, false, 10));
		
		Path.segments.add(new Path(847, 730, 10, 200, false, 11)); // vertical down
		
		Path.segments.add(new Path(845, 940, 270, 10, false, 12)); // right
		Path.segments.add(new Path(1129, 750, 10, 210, false, 13)); // vertical up
		Path.segments.add(new Path(1129, 680, 10, 45, false, 14)); // vertical up
		
		Path.segments.add(new Path(1129, 661, 10, 10, true, 15)); // diagonal north_west
		for(int i = 0; i < 6; i ++) {
			Path.segments.add(new Path(1109 - i*20, 645 - i*20, 10, 10, true, 15.1));
		}
		Path.segments.add(new Path(740, 525, 280, 10, false, 16));
		
		Path.segments.add(new Path(713, 525, 10, 10, true, 17 )); // diagonal south_west
		for(int i = 0; i < 7; i ++) {
			Path.segments.add(new Path(697 - i*19, 545 + i*19, 10, 10, true, 17.1));
		}
		Path.segments.add(new Path(563, 670, 10, 155, false, 18)); // vertical down
		
		Path.segments.add(new Path(400, 841, 180, 10, false, 19)); // left
		
		buttonLevelStart = new Button(new Rect(1700, 900, 200, 100), null, Color.black, "Start Level", Color.WHITE,
				fntSmall, true, Color.gray, false);

	}
	
	
	


}
