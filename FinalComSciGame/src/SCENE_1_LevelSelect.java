import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SCENE_1_LevelSelect extends Scene {
	
	Button buttonBack;
	
	Button buttonTrack1;
	
	Font fntSmall = new Font("Impact", 0, 35);
	
	public void draw(Graphics g) {
		
		g.setColor(new Color(60, 50, 49));
		g.fillRect(0, 0,  Driver.screenWidth, Driver.screenHeight);
		
		buttonBack.draw(g, 110, 38);
		buttonTrack1.draw(g, 104, 38);
	}

	public void update() {
		buttonBack.update();
		buttonTrack1.update();
		
		if(buttonBack.clicked) {
			
			SceneManager.scene_levelSelect.setActive(false);
			SceneManager.scene_mainMenu.setActive(true);
			
		}
		
	}

	public void init() {
		
		buttonBack = new Button(new Rect(80, 80, 300, 50), null, Color.GRAY, "Back", Color.WHITE, fntSmall, true, Color.WHITE, false);
		
		buttonTrack1 = new Button(new Rect(200, 400, 300, 250), null, Color.GRAY, "Track 1", Color.WHITE, fntSmall, true, Color.WHITE, false);
	}

}
