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
	int a = 120;
	int a2 = 170;
	int a3 = 230;

	Color dimGray = new Color(100, 100, 100, a);
	Color dimBlue2 = new Color(0,0,139, a2);
	Color dimBlue3 = new Color(30,140,255, a3);

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
			g2.setPaint(dimGray);		
			g2.drawLine(x, y, x2, y2);		
			
		}
		if (identity == 2 || identity == 3) { // green balls from basicTurrent
			g2.setPaint(dimBlue2);
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(x, y, x2, y2);
			g2.setStroke(new BasicStroke(1));
			
		}
		if (identity == 4) { // green balls from basicTurrent
			g2.setPaint(dimBlue3);
			g2.setStroke(new BasicStroke(3));
			g2.drawLine(x, y, x2, y2);
			g2.setStroke(new BasicStroke(1));
			
		}
		

	}

	public void update(ArrayList<Enemies> squaros, ArrayList<Turret> turrets, ArrayList<Projectile> projectiles, ArrayList<Line> lines) {
		if(a > 2) a -= 3;
		if(a2 > 2) a2 -= 3;
		if(a3 > 2) a3 -= 3;
		
		dimGray = new Color(100, 100, 100, a);
		dimBlue2 = new Color(176,196,222, a2);
		dimBlue3 = new Color(30,140,255, a3);
		if(age > ageLimit) {
			a = 120;
			a2 = 170;
			a3 = 230;
			lines.remove(this);
		}


		age++;
	}
}
