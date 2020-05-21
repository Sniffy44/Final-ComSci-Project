import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class SCENE_0_MainMenu extends Scene {
	
	Button buttonStart;
	
	Font fntSmall = new Font("Impact", 0, 35);
	Font fntSmallc = new Font("Press Start", 0, 40);
	
	BufferedImage MainMenuBackGround;
	BufferedImage StartButtonGraphic_dark;
	BufferedImage StartButtonGraphic_bright;
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(MainMenuBackGround, 0, 0, Driver.screenWidth, Driver.screenHeight, null);
		g.drawImage(StartButtonGraphic_dark, -30, 0, Driver.screenWidth, Driver.screenHeight, null);
		
		if(buttonStart.glowing == true) {
			g.drawImage(StartButtonGraphic_bright, -30, 0, Driver.screenWidth, Driver.screenHeight, null);
		}
		
		
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
		
		MainMenuBackGround = Misc.loadImage("/MainMenuBG_FINAL.png");
		StartButtonGraphic_dark = Misc.loadImage("/StartButton_miniLines_wText.png");
		StartButtonGraphic_bright = Misc.loadImage("/StartButton_miniLines_wText_bright2.png");
		
		buttonStart = new Button(new Rect(830, 535, 200, 85), null, Color.black, "Play", Color.WHITE, fntSmallc, true, Color.gray, false);
	}

}
