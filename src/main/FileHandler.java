package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class FileHandler {
	
	ArrayList<String> lines = new ArrayList<String>();

	
	/*
	 * Select File
	 */
	public File getPath() {

		System.out.println("Selecting Path...");
		String folder = System.getProperty("user.dir");
		JFileChooser chooser = new JFileChooser(folder);
		chooser.setDialogTitle("Select Demo File");

		chooser.showOpenDialog(null);

		return chooser.getSelectedFile();
	}

	
	/*
	 *  Reads File into Buffer
	 */
	public void loadFile(File f) {

		System.out.println("Loading File");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {

			JOptionPane.showMessageDialog(null, "No Such File Found");

			e.printStackTrace();

			System.exit(1);
		}

		String ln;

		try {
			while ((ln = br.readLine()) != null) {
				lines.add(ln);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File Read Failed");
			e.printStackTrace();
		}
	}
	
	/*
	 * Converts lines to Array
	 */
	public String[][] getArray() {
		
		String seperator = JOptionPane.showInputDialog("Seperator");
		
		String[][] cells = new String[lines.size()][2];
		
		for(int i = 0; i<lines.size(); i++) {
			
			cells[i] = lines.get(i).split(seperator);
			
		}
		
		return cells;
	
		
	}
	
}
