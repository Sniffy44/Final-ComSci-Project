import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SCENE_2_Track1 extends Scene {
	
	ArrayList<Double> fps = new ArrayList<Double>();
	
	double frameStart = 0;
	
	BufferedImage track1Image;
	
	Font fntSmall = new Font("Impact", 0, 35);
	
	public void draw(Graphics g) { // |||||||||||||||||||||||||||||||||||||||||||||||| DRAW
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(track1Image, 0, 0, Driver.screenWidth, Driver.screenHeight, null);
		
		
		
		
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
		
		
		
		
	} // ||||||||||||||||||||||||||||||||||||||||||||||| END OF UPDATE

	public void init() {
		track1Image = Misc.loadImage("/track1_example.png");
		
	}

}
