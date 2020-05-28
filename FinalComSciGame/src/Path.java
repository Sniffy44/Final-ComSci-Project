import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Path {
	
	int x,y,width, height;
	boolean isDiagonal;
	double identity;
	
	Rect hitbox;
	
	Font fint = new Font("Inconsolata", 0, 12);
	
	
	
	
	public Path(int x, int y, int width, int height, boolean isDiagonal, double identity) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isDiagonal = isDiagonal;
		this.identity = identity;
		
		this.hitbox = new Rect(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g.setColor(Color.white);
		hitbox.draw(g2);;
		g.setFont(fint);
		g.drawString("" + identity, x + width/2 - 5, y + height/2 -5);
		
	}
	
	public void update(ArrayList<Enemies> squaros, ArrayList<Path> segments) {
		hitbox.pos.x = x;
		hitbox.pos.y = y;
		hitbox.w = width;
		hitbox.h = height;
	}
	
	public void init() {
		
	}
}
