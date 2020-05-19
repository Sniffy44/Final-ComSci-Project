import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SCENE_0_MainMenu extends Scene {
	
	Button buttonStart;
	
	Font fntSmall = new Font("Impact", 0, 35);
	
	public void draw(Graphics g) {
		
		g.setColor(new Color(55, 50, 49));
		g.fillRect(0, 0,  Driver.screenWidth, Driver.screenHeight);
		
		buttonStart.draw(g, 110, 38);
	}

	public void update() {
		buttonStart.update();
		
		if (buttonStart.clicked) {
			
			SceneManager.scene_levelSelect.init();
			
			SceneManager.scene_mainMenu.setActive(false);
			SceneManager.scene_levelSelect.setActive(true);
			
		}
		
	}

	public void init() {
		
		buttonStart = new Button(new Rect(780, 400, 300, 50), null, Color.GRAY, "Play", Color.WHITE, fntSmall, true, Color.WHITE, false);
	}

}
