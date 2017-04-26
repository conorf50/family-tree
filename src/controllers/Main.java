package controllers;
import java.io.FileNotFoundException;

import utils.FileIO;;
public class Main {

	public static void main(String[] args) {
		FileIO imports = new FileIO();
		try {
			imports.importer();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
