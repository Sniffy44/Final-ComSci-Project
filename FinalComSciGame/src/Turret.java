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
	double fireSpeed;
	int upgradeLvl;
	int netWorth;
	boolean button1aPressed;
	boolean button2aPressed;
	boolean button1bPressed;
	boolean button2bPressed;
	boolean buttonSpecialPressed;
	int upg1aPrice;
	int upg2aPrice;
	int upg1bPrice;
	int upg2bPrice;
	int upgMasterPrice;
	boolean isSold;
	int numCollisions;
	//int damage;
	BufferedImage texture;
	int identity;

	Rect hitbox;

	Color dimBlue = new Color(100, 100, 100, 50);

	public Turret(int x, int y, int width, int height, int price, double rotation, int range, int damage, int firerate,
			double fireSpeed, int upgradeLvl, int netWorth, boolean button1aPressed, boolean button2aPressed,
			boolean button1bPressed, boolean button2bPressed, boolean buttonSpecialPressed, int upg1aPrice,
			int upg2aPrice, int upg1bPrice, int upg2bPrice, int upgMasterPrice, boolean isSold, int numCollisions,
			BufferedImage texture, int identity) {
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
		this.fireSpeed = fireSpeed;
		this.upgradeLvl = upgradeLvl;
		this.netWorth = netWorth;
		this.button1aPressed = button1aPressed;
		this.button2aPressed = button2aPressed;
		this.button1bPressed = button1bPressed;
		this.button2bPressed = button2bPressed;
		this.buttonSpecialPressed = buttonSpecialPressed;
		this.upg1aPrice = upg1aPrice;
		this.upg2aPrice = upg2aPrice;
		this.upg1bPrice = upg1bPrice;
		this.upg2bPrice = upg2bPrice;
		this.upgMasterPrice = upgMasterPrice;
		this.isSold = isSold;
		this.numCollisions = numCollisions;
		this.texture = texture;
		this.identity = identity;
		this.hitbox = new Rect(x - width / 2, y - height / 2, width, height);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);

		g2.rotate(rotation, x, y);

		// g.setColor(Color.white);
		// g2.drawOval(x - range, y - range, range * 2, range * 2);
		// g2.setPaint(dimBlue);
		// g2.fillOval(x - range, y - range, range * 2, range * 2);
		g2.drawImage(texture, x - width / 2, y - height / 2, width, height, null);

		g2.rotate(-rotation, x, y);

	}

	public abstract void update(ArrayList<Enemies> squaros, ArrayList<Projectile> projectiles);

}
