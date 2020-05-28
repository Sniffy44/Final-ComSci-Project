import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Turret {

	int x, y, width, height;
	int price;
	double rotation;
	int range;
	int damage;
	int firerate;
	BufferedImage texture;
	int identity;
	
	Rect hitbox;

	Color dimBlue = new Color(100, 100, 100, 50);

	public Turret(int x, int y, int width, int height, int price, double rotation, int range, int damage,
			int firerate, BufferedImage texture, int identity) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.price = price;
		this.rotation = rotation;
		this.range = range;
		this.damage = damage;
		this.firerate = firerate;
		this.texture = texture;
		this.identity = identity;
		this.hitbox = new Rect(x - width/2, y - height/2, width, height);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (identity == 0) {
			
			g2.rotate(rotation, x, y);
			
			//g.setColor(Color.white);
			//g2.drawOval(x - range, y - range, range * 2, range * 2);
			//g2.setPaint(dimBlue);
			//g2.fillOval(x - range, y - range, range * 2, range * 2);
			g2.drawImage(texture, x - width/2, y - height/2, width, height, null);
			
			g2.rotate(-rotation, x, y);
		}

	}

	public abstract void update(ArrayList<Enemies> squaros, ArrayList<Projectile> projectiles);

}
