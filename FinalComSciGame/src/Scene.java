import java.awt.Graphics;

public abstract class Scene {

	boolean running = false;
	boolean drawing = false;
	boolean init = false;

	public abstract void draw(Graphics g);

	public abstract void update();

	public abstract void init();

	public void setActive(boolean b) {
		this.running = b;
		this.drawing = b;
	}
	
	
}
