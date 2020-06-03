import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Line {

	int x, y;
	int x2, y2;
	int ageLimit;
	int identity;

	int age = 0;
	int a = 190;

	Color dimBlue = new Color(100, 100, 100, 150);

	public Line(int x, int y, int x2, int y2, int ageLimit, int identity) {
		super();
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.ageLimit = ageLimit;
		this.identity = identity;
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (identity == 1) { // green balls from basicTurrent
			g2.setPaint(dimBlue);
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(x, y, x2, y2);
			g2.setStroke(new BasicStroke(1));
			
			// hitbox1.draw(g2);
		}
		

	}

	public void update(ArrayList<Enemies> squaros, ArrayList<Turret> turrets, ArrayList<Projectile> projectiles, ArrayList<Line> lines) {
		a -= 3;
		dimBlue = new Color(100, 100, 100, a);
		if(age > ageLimit) {
			a = 190;
			lines.remove(this);
		}


		age++;
	}
}
