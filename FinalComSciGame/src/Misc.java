import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Misc {

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Misc.class.getResource(path));
		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1); // if image is not loaded dont run game
		}
		return null;
	}
	public static int rBt(int min, int max) {
		return ((int) (Math.random() * (max - min + 1) + min));
	}
	
	public static String[] read(String location) {
		String[] text = null;
		String line = null;
		int i = 0;
		// The name of the file to open.
		String fileLocation = location;
		// This will reference one line at a time
		try {
			// FileReader reads text files in the default encoding.
			FileReader linesCounter = new FileReader(fileLocation);

			// Always wrap FileReader in BufferedReader.
			BufferedReader lineCounter = new BufferedReader(linesCounter);
			while ((line = lineCounter.readLine()) != null) {
				i++;
			}
			lineCounter.close();
			FileReader fileReader = new FileReader(fileLocation);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			text = new String[i];
			i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				text[i] = line;
				i++;
			}
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to find file '" + fileLocation + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileLocation + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		// String fullText = String.join(" ", text);
		return (text);
	}
	public static void writeToFile(String path, String text) {
		// writes directly to file & will replace all previous text there
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
			bufferedWriter.write(text);
		} catch (IOException e) {
			System.out.println("Error: IO Exception");
		}
	}
	
}