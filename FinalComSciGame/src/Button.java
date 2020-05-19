import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button {
	Rect bounds;
	BufferedImage img;
	int centeringMethod;
	boolean clicked, glowing, glow;
	String text = "";
	Font f = new Font("Arial", 0, 12);
	Color c;
	int identity;

	public Button(Rect bounds, BufferedImage img, int centeringMethod, String text, Font f, Color c, boolean glow,
			int identity) {
		super();
		this.bounds = bounds;
		this.img = img;
		this.centeringMethod = centeringMethod;
		this.text = text;
		this.f = f;
		this.c = c;
		this.glow = glow;
		this.identity = identity;
	}

	public void update(boolean[] mouse, Point mPos, boolean[] mouseReleased) {
		if (mouse[1] && mPos.inside(bounds)) {
			clicked = true;
// mouseReleased[1] = false;
		} else {
			clicked = false;
		}
		if (mPos.inside(bounds) && glow) {
			glowing = true;
		} else {
			glowing = false;
		}
	}

	public void draw(Graphics g, int xOff, int yOff) {
		g.setFont(f);
		g.setColor(c);
		if (glowing)
			g.setColor(Color.WHITE);
		g.fillRoundRect((int) bounds.pos.x, (int) bounds.pos.y, (int) bounds.w, (int) bounds.h, 10, 10);
		g.setColor(Color.black);
		g.drawRoundRect((int) bounds.pos.x, (int) bounds.pos.y, (int) bounds.w, (int) bounds.h, 10, 10);
		if (img != null)
			g.drawImage(img, (int) bounds.pos.x, (int) bounds.pos.y,
					(int) bounds.w < (int) bounds.h ? (int) bounds.w : (int) bounds.h,
					(int) bounds.w < (int) bounds.h ? (int) bounds.w : (int) bounds.h, null);
		if (text != null)
			g.drawString(text, (int) bounds.pos.x + xOff, (int) bounds.pos.y + yOff);
	}
}

// Quit Button == System.exit(0);
