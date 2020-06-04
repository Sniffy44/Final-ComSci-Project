import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class SCENE_3_DeathScreen extends Scene {
	
	Button buttonMainMenu;
	
	Font fntSmall = new Font("Impact", 0, 35);
	Font fntSmallc = new Font("Press Start", 0, 40);
	Font fntBigc = new Font("Press Start", 0, 80);
	
	//BufferedImage LevelSelectBackGround;
	
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//g.drawImage(LevelSelectBackGround, 0, 0, Driver.screenWidth, Driver.screenHeight, null);
		g.setFont(fntBigc);
		g.setColor(new Color(20, 10, 90));
		g.fillRect(0,  0, 2000, 1100);
		g.setColor(Color.WHITE);
		g.drawString("You Lost loser", 800, 300);
		g.setFont(fntSmallc);
		g.drawString("you survived to round " + SCENE_2_Track1.level, 750, 500);
		
		buttonMainMenu.draw(g, 104, 38);
	}

	public void update() {
		buttonMainMenu.update();
		
		if (buttonMainMenu.clicked) {
			
			SceneManager.scene_mainMenu.init();
			
			
			SceneManager.scene_deathScreen.setActive(false);
			SceneManager.scene_mainMenu.setActive(true);
			
		}
		
	}

	public void init() {
		
		//LevelSelectBackGround = Misc.loadImage("/LevelSelectBG.png");
		
		buttonMainMenu = new Button(new Rect(113, 125, 200, 85), null, Color.black, "Main Menu", Color.WHITE, fntSmallc, true, Color.gray, false);
	}

}
