import java.awt.Graphics;

public class Rect {
	Point pos;
	double h, w;

	public Rect(double x, double y, double w, double h) {

		this.pos = new Point(x, y);
		this.h = h;
		this.w = w;

	}

	public boolean intersects(Rect r) {
		return (pos.inside(r) || new Point(pos.x + w, pos.y).inside(r) || new Point(pos.x + w, pos.y + h).inside(r)
				|| new Point(pos.x, pos.y + h).inside(r) || r.pos.inside(this)
				|| new Point(r.pos.x + r.w, r.pos.y).inside(this)
				|| new Point(r.pos.x + r.w, r.pos.y + r.h).inside(this)
				|| new Point(r.pos.x, r.pos.y + r.h).inside(this));
	}

	public int classifyCol(Rect r) {
		if (!this.intersects(r)) {
			return 0;
		}
		double right = Math.abs(pos.x + w - r.pos.x);
		double left = Math.abs(pos.x - (r.pos.x + r.w));
		double bottom = Math.abs(pos.y + h - (r.pos.y));
		double top = Math.abs(pos.y - (r.pos.y + r.h));
		// 3 = top, 1 = bottom
		if (top < right && top < left && top < bottom) {		
			return 1;
		}
		if (right < left && right < bottom && right < top) {
			return 2;
		}
		if (bottom < right && bottom < left && bottom < top) {
			return 3;
		}
		if (left < right && left < bottom && left < top) {
			return 4;
		}
		return 0;

	}

	public void draw(Graphics g) {
		g.drawRect((int) pos.x, (int) pos.y, (int) w, (int) h);
	}

	public Rect getCopy() {

		return new Rect(pos.x, pos.y, w, h);
	}
}
