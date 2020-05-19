import java.awt.Color;
import java.awt.Graphics2D;

public class Point {
	double x, y;
	

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		
	}

	public void draw(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g;
				
			
		
	}

	public double distanceTo(Point p2) {
		return Math.sqrt((this.x - p2.x) * (this.x - p2.x) + (this.y - p2.y) * (this.y - p2.y));
	}

	public double angleTo(Point p2) {
		try {
			return Math.atan2(this.y - p2.y, this.x - p2.x);
		} catch (Exception e) {

		}
		return 0;
	}

	public boolean inside(Rect r) {
		return (x >= r.pos.x && x <= r.pos.x + r.w && y >= r.pos.y && y <= r.pos.y + r.h);
	}
	// public boolean inside(CircHitbox r) {
	// return (this.distanceTo(new Point(r.pos.x + r.r, r.pos.y + r.r)) < r.r);
	// }

	public String toStr() {
		return ("(" + this.x + ", " + this.y + ")");
	}
}