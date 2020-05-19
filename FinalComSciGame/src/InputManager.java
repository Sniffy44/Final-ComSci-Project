
public abstract class InputManager {

	static Point mPos = new Point(0, 0); // updating in driver constantly
	static boolean[] mouse = new boolean[10];
	static boolean[] mouseReleased = new boolean[10];
	static boolean[] keys = new boolean[300];
	static boolean[] keysReleased = new boolean[300];
	static boolean[] keysToggled = new boolean[300];
	static boolean resetKeysReleased = false;
	static boolean resetMouseReleased = false;

	public static void update() {
		updateReleased();
	}

	private static void updateReleased() {
		if (resetMouseReleased) {
			for (int i = 0; i < mouseReleased.length; i++) {
				mouseReleased[i] = false;
			}
			resetMouseReleased = false;
		}
		if (resetKeysReleased) {
			for (int i = 0; i < keysReleased.length; i++) {
				keysReleased[i] = false;
			}
			resetKeysReleased = false;
		}
		
	}

	public static void setKeyReleased(int e) {
		keysReleased[e] = true;
		resetKeysReleased = true;

		keys[e] = false;

		if (keysToggled[e]) {
			keysToggled[e] = false;
		} else {
			keysToggled[e] = true;
		}

	}

}
