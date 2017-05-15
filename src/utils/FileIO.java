package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import models.Person;

public class FileIO<T extends Comparable<T>> implements Iterable<T> {

	//ListModel lm = new DefaultListModel();

	// map used to match parents to children
	final HashMap<String, Person> people = new HashMap<String, Person>();

	// map that contains all relationships
	// The integer here is the person number;
	final HashMap<Integer, Person> allPeople = new HashMap<Integer, Person>();

	private Person person = null;
	// A number to keep track of the amount of people we add into the alPeople
	// hashMap
	//
	private int personNum = 0;

	public boolean isEmpty() {
		if (person == null) {
			return true;
		} else {
			return false;
		}
	}

	public void importer() throws FileNotFoundException {
		/*
		 * Import in 2 steps First step: only count first 3 tokens Second step:
		 * count the last two tokens only Third step: using the fName from the
		 * people set, map parents to children and vice versa Fourth step:
		 * create a new Map with this information
		 * 
		 */

		System.out.println("loading file (pass 1 of 2)");
		/*
		 * First stage of file importing
		 */
		File usersFile = new File("large-database.txt");
		Scanner firstInput = new Scanner(usersFile);
		String delims = " ";// each field in the file is separated(delimited)

		// by a space
		while (firstInput.hasNextLine()) {
			// get info from data source
			String userDetails = firstInput.nextLine();
			userDetails = userDetails.trim();

			// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 5) {

				String fName = userTokens[0];
				Person p = new Person(personNum,userTokens[0], userTokens[1], Integer.parseInt(userTokens[2]), null, null);
				people.put(fName, p);
			//	System.out.println(personNum);

			}
		}
		firstInput.close();
		System.out.println(people.toString());
		// lm.add(people.toString().charAt(0));

		System.out.println("loading file (pass 2 of 2)");
		/*
		 * /////////////////////////////////////////////////////////////////////
		 * ////////////////////////////////////////////////////////////
		 * /////////////////////////////////////////* Second stage of file
		 * importing////////////////////////////////////////////////////////
		 */
		Scanner secondInput = new Scanner(usersFile);
		// by a space
		while (secondInput.hasNextLine()) {
			// get info from data source
			String userDetails = secondInput.nextLine();
			userDetails = userDetails.trim();

			// parse user details string
			String[] allUserTokens = userDetails.split(delims);

			String name = allUserTokens[0];
			
		

			/*
			 * 
			 * userTokens[3] = mother userTokens[4] = father
			 */

			if (allUserTokens.length == 5) {

				for (Entry<String, Person> entry : people.entrySet()) {


					Person p = (Person) people.get(name);
					String motherName = allUserTokens[3];
					String fatherName = allUserTokens[4];
					Person mother = (Person) people.get(motherName);
					Person father = (Person) people.get(fatherName);
					p.setMother(mother);
					p.setFather(father);
					allPeople.put(personNum, p);
					//personNum ++;


				}
				

			}
		
			System.out.println(allPeople.toString());
			
		}		

		secondInput.close();
		

		/// System.out.println(people.toString());

	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
