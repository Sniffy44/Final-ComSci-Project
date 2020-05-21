import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class SCENE_1_LevelSelect extends Scene {
	
	Button buttonBack;
	
	Button buttonTrack1;
	
	Font fntSmall = new Font("Impact", 0, 35);
	Font fntSmallc = new Font("Press Start", 0, 35);
	
	BufferedImage LevelSelectBackGround;
	BufferedImage BackButtonGraphic_bright;
	
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(LevelSelectBackGround, 0, 0, Driver.screenWidth, Driver.screenHeight, null);
		
		if(buttonBack.glowing) g.drawImage(BackButtonGraphic_bright, 0, 0, Driver.screenWidth, Driver.screenHeight, null);
			
		
		//buttonBack.draw(g, 110, 38);
		buttonTrack1.draw(g, 104, 38);
	}

	public void update() {
		buttonBack.update();
		buttonTrack1.update();
		
		if(buttonBack.clicked) {
			SceneManager.scene_mainMenu.init();
			
			SceneManager.scene_levelSelect.setActive(false);
			SceneManager.scene_mainMenu.setActive(true);
		}
		
		if(buttonTrack1.clicked) {	
			SceneManager.scene_track1.init();
			
			SceneManager.scene_levelSelect.setActive(false);
			SceneManager.scene_track1.setActive(true);
		}
		
	}

	public void init() {
		
		LevelSelectBackGround = Misc.loadImage("/LevelSelectBG.png");
		BackButtonGraphic_bright = Misc.loadImage("/BackButton_Bright.png");
		
		
		buttonBack = new Button(new Rect(113, 125, 200, 85), null, Color.black, "Back", Color.WHITE, fntSmallc, true, Color.gray, false);
		
		buttonTrack1 = new Button(new Rect(300, 400, 300, 250), Misc.loadImage("/track1_example.png"), Color.black, "Track 1", Color.white, fntSmallc, true, Color.gray, false);
	}

}
