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

	ListModel lm = new DefaultListModel();

	// map used to match parents to children
	final HashMap<String, Person> people = new HashMap<String, Person>();

	// map that contains all relationships
	final HashMap<String, Person> allPeople = new HashMap<String, Person>();

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
				Person p = new Person(userTokens[0], userTokens[1], Integer.parseInt(userTokens[2]), null, null);
				people.put(fName, p);

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
			String gender = allUserTokens[1];
			Integer birthYear = Integer.parseInt(allUserTokens[2]);

		

			/*
			 * 
			 * userTokens[3] = mother userTokens[4] = father
			 */

			if (allUserTokens.length == 5) {

				for (Entry<String, Person> entry : people.entrySet()) {

					Person p = (Person) people.get(name);
					// a is the new empty person that was initalised earlier
					Person mother = p.getMother();
					Person father = p.getFather();
					
					// if the character is not ?
					if (!allUserTokens[3].equals("?")) {
						/*
						 * datatype disaster
						 */

						Person pers = new Person(allUserTokens[0], allUserTokens[1], Integer.parseInt(allUserTokens[2]),
								mother, father);
						allPeople.put(name, pers);
						// System.out.println(allPeople.toString());
					} else if (allUserTokens[3].equals("?")) {
						Person pers = new Person(allUserTokens[0], allUserTokens[1], Integer.parseInt(allUserTokens[2]),
								null, father);
						allPeople.put(name, pers);


						allPeople.put(name, pers);
					} else if (allUserTokens[4].equals("?")) {
						Person pers = new Person(allUserTokens[0], allUserTokens[1], Integer.parseInt(allUserTokens[2]),
								mother, null);

						allPeople.put(name, pers);
					}

				}

			}
			System.out.println(allPeople.toString());
		}		

		secondInput.close();

		/// System.out.println(people.toString());

	}

	@SuppressWarnings("unchecked")
	// for adding people to a family
	public void add(Person pers) {
		// check if the tree is empty, if it is we set the
		// input to be the root of the tree by casting it as a Node
		if (isEmpty()) {
			person = (Person) pers;
			personNum++;
		}
		// if there is already items in the Tree, call the second
		// addR method to handle it
		else {
			addR(pers, person);
			personNum++;
		}

	}

	@SuppressWarnings("unchecked")
	private void addR(Person pers, Person current) {
		// check if what's coming in is less than
		// the current Node

		// eg; item.lessThan(current)
		if (pers.compareTo(current) > 0) {
			if (current.getMother() == null)
				// cast the left item as a Node
				current.setMother((Person) pers);
			else
				addR(pers, current.getMother());
		}

		// else the item goes on the right child
		else {
			if (current.getFather() == null)
				current.setFather((Person) pers);
			else
				addR(pers, current.getFather());
		}
	}
	// end of add methods

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
