package main;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

import javax.swing.JOptionPane;

public class Autogoogler_main {

	public static void main(String[] args) {

		String cells[][];

		int collumn = 0,
				row = 1;
		boolean selecterror = false;

		FileHandler fh = new FileHandler();
		AlphabetManager am = new AlphabetManager();
		File f = fh.getPath();
		fh.loadFile(f);

		cells = fh.getArray();

		// select Collumn
		do {
			selecterror = false;
			try {
				char[] in= JOptionPane.showInputDialog("Selected Collumn").toCharArray();
				collumn = (in.length-1)*26;
				collumn += am.getPosition(in[in.length-1]);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Malformed Input. Could not parse Integer");
				selecterror = true;
			}
		} while (selecterror);

		// Select first row
		do {
			selecterror = false;
			try {
				row = Integer.parseInt(JOptionPane.showInputDialog("Selected First Row (Starting at 0)"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Malformed Input. Could not parse Integer");
				selecterror = true;
			}
		} while (selecterror);

		// Read Cells
		for (int i = row; i < cells.length; i++) {

			String name = cells[i][collumn];

			if (name != "") {

				try {
					Desktop.getDesktop().browse(new URI("https://www.google.com/search?q=" + getFormatted(name)));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error at " + name);
					e.printStackTrace();
				}
			}

			if (i % 5 == 0) {
				int state = JOptionPane.showConfirmDialog(null, "Next");
				if (state == 1 || state == 2) {
					System.exit(0);
				}
			}

		}

	}

	static String getFormatted(String cell) {

		String out = cell.replaceAll(" ", "+");
		out = out.replaceAll("&", "%26");
		out = out.replaceAll("\'", "%27");
		out = out.replaceAll("\\\\", "%5C");
		out = out.replaceAll("\\(", "%28");
		out = out.replaceAll("\\)", "%29");
		out = out.replaceAll(",", "%2C");

		return out;

	}

}
