import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SCENE_2_Track1 extends Scene {
	
	ArrayList<Double> fps = new ArrayList<Double>();
	
	Font fntSmall = new Font("Impact", 0, 35);
	
	double frameStart = 0;
	
	ArrayList<Enemies> squaros = new ArrayList<Enemies>();
	
	BufferedImage track1Image;
	
	public static int lives = 10;
	
	
	
	public void draw(Graphics g) { // |||||||||||||||||||||||||||||||||||||||||||||||| DRAW
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(track1Image, 0, 0, Driver.screenWidth, Driver.screenHeight, null);
		
		g.setFont(fntSmall);
		g.setColor(Color.white);
		g.drawString("" + lives, 137, 729);
		
		
		for (int i = 0; i < squaros.size(); i++) { // draws coins items with arrayList
			squaros.get(i).draw(g2);
		}
		
		//for (int i = 0; i < Path.segments.size(); i++) {
		//	Path.segments.get(i).draw(g2);
		//}
		
		
		
		
		
		// FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS___FPS \\
		fps.add((double) (1 / ((System.currentTimeMillis() - frameStart) / 1000)));
		if (fps.size() >= 60) {
			fps.remove(0);
		}
		double sum = 0;
		for (Double d : fps) {
			sum += d;
		}
		double avg = sum / fps.size();
		g.setFont(fntSmall);
		g.setColor(Color.CYAN);
		g.drawString((int) avg + "", Driver.screenWidth - 60, 40);
		frameStart = System.currentTimeMillis();
		
	} // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| END OF DRAW

	public void update() { //||||||||||||||||||||||||||| UPDATE START
		
		for (int i = 0; i < squaros.size(); i++) {
			squaros.get(i).update(squaros);
		}
		
		
		
		
	} // ||||||||||||||||||||||||||||||||||||||||||||||| END OF UPDATE

	public void init() {
		track1Image = Misc.loadImage("/track1_example.png");
		Driver.track = 1;
		
		squaros.add(new Enemies(200, 200, 5, 1, 50, 50, 3, 100, null, 0));
		squaros.add(new Enemies(100, 200, 5, 1, 50, 50, 4, 100, null, 0));
		
		Path.segments.add(new Path(150, 730, 10, 10, 0));
		Path.segments.add(new Path(0, 369, 1320, 10, 1));
		Path.segments.add(new Path(1337, 369, 10, 360, 2));
		Path.segments.add(new Path(220, 730, 1130, 10, 3));
		
		
	}

}
