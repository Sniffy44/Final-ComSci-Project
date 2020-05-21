import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel
		implements ActionListener, KeyListener, MouseMotionListener, MouseWheelListener, MouseListener {

	ArrayList<Double> fps = new ArrayList<Double>();

	Font fnt = new Font("Impact", 0, 50);
	Font fntBig = new Font("Impact", 0, 70);
	Font fntHuge = new Font("Impact", 0, 90);
	Font fntSmall = new Font("Impact", 0, 35);
	Font fntSmallish = new Font("Impact", 0, 28);
	Font fntTiny = new Font("Impact", 0, 20);
	Font fnt_B = new Font("Impact", 1, 50);
	Font fnt_I = new Font("Impact", 2, 50);
	Font fntHuge_I = new Font("Impact", 2, 90);
	Font fntTiny_I = new Font("Impact", 2, 20);

	Font fint = new Font("Inconsolata", 0, 12);

	static int screenWidth = 1920; // width of the screen "table"
	static int screenHeight = 1080;// height of the screen "table"

	static int scene = 0;

	static int frames = 0;

	double frameStart = 0;
	
	public static int track = 0;

	static Point mPos = new Point(0, 0);

	static boolean[] mouse = new boolean[10];
	static boolean[] mouseReleased = new boolean[10];

	public void paint(Graphics g) { // PAINT ||||||||
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		SceneManager.draw(g);

	} // END OF PAINT
		// ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

	public void update() { // UPDATE |||||||||||||||||||||||||||||||||||||||||||||||||||||||
		mPos = getMousePos();
		SceneManager.update();


	}// END OF UPDATE |||||||||||||||||||||||||||||||

	public void actionPerformed(ActionEvent arg0) {
		try {
			InputManager.mPos = getMousePos();

			update();
		} catch (Exception e) {
			e.printStackTrace();
		}
		repaint();
		InputManager.update();

	}

	public Point getMousePos() {
		try {
			return new Point(this.getMousePosition().x, this.getMousePosition().y);
		} catch (Exception e) {
			return InputManager.mPos;
		}
	}

	public Driver() {

		init();

		JFrame f = new JFrame();
		f.setTitle("Tower Defebce boii");
		f.setSize(screenWidth, screenHeight);
		f.setBackground(Color.BLACK);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseMotionListener(this);
		f.addMouseWheelListener(this);
		f.addMouseListener(this);
		f.add(this);
		t = new Timer(15, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	private void init() { // TODO
		SceneManager.initManager();
		SceneManager.scene_mainMenu.init();
		SceneManager.scene_mainMenu.setActive(true);
		// SceneManager.gs.init();

	}

	Timer t;

	public static void main(String[] args) {
		Driver d = new Driver();
		// URL url = new URL("/ObamaPrismRotating.gif");
		// Icon icon = new ImageIcon(url);
		// JLabel label = new JLabel(icon);

		// JFrame f = new JFrame("Animation");
		// f.getContentPane().add(label);
		// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// f.pack();
		// f.setLocationRelativeTo(null);
		// f.setVisible(true);
	}

	public static Point getmPos() {
		return mPos;
	}


	public int rBt(int min, int max) {
		return ((int) (Math.random() * (max - min + 1) + min));
	}

	public Color rColor() {
		return new Color(rBt(0, 255), rBt(0, 255), rBt(0, 255));
	}

	private int sineStuff() {
		if (Math.random() >= .5) {
			return 1;
		} else {
			return -1;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		InputManager.keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
//		if (scene == 0 && e.getKeyCode() == 83) // [s] start
//			mapStarter();
		InputManager.setKeyReleased(e.getKeyCode());
	}

	public void mousePressed(MouseEvent e) {
		InputManager.mouse[e.getButton()] = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		InputManager.mouse[e.getButton()] = false;
		InputManager.mouseReleased[e.getButton()] = true;
		InputManager.resetMouseReleased = true;

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouse[e.getButton()] = true;

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseWheelMoved(MouseWheelEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	

}

class Money{
	
	public int money;
}