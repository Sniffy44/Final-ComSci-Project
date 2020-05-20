import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Path {
	
	int x,y,width, height;
	int identity;
	
	Rect hitbox;
	
	public static ArrayList<Path> segments = new ArrayList<Path>();
	
	
	public Path(int x, int y, int width, int height, int identity) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.identity = identity;
		
		this.hitbox = new Rect(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g.setColor(Color.white);
		hitbox.draw(g2);;
		
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
