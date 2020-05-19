import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuScene extends Scene {
	
	Button buttonStart;
	
	Font fntSmall = new Font("Impact", 0, 35);
	
	public void draw(Graphics g) {
		
		g.setColor(new Color(55, 50, 49));
		g.fillRect(0, 0,  Driver.screenWidth, Driver.screenHeight);
		
		buttonStart.draw(g, 110, 38);
	}

	public void update() {
		buttonStart.update(Driver.mouse, Driver.mPos, Driver.mouseReleased);
		
		if (buttonStart.clicked) {
			
			SceneManager.ms.setActive(false);
			
		}
		
	}

	public void init() {
		
		buttonStart = new Button(new Rect(780, 400, 300, 50), null, 0, "Start", fntSmall, Color.GRAY, true, 0);
	}

}
