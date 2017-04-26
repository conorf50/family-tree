package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import models.Person;

public class FileIO <T extends Comparable<T>> implements Iterable<T>{
	public static String URL = "./wiki.txt";
	// map used to match parents to children
	final HashMap<String, Person> people  = new HashMap<String, Person> ();
	
	// map that contains all relationships
	final HashMap<String, String> allPeople  = new HashMap<String, String> ();

	private Person person = null;
	private int personNum = 0;

	
	public boolean isEmpty() {
		if(person == null){
			return true;
		}
		else{
			return false;
		}
	}

	public void importer() throws FileNotFoundException {
		/*
		 * Import in 2 steps
		 * First step: only count first 3 tokens
		 * Second step: count the last two tokens only
		 * Third step: using the fName from the people set, map parents to children and vice versa
		 * Fourth step: create a new Map with this information 
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

				Person p = new Person(userTokens[0], userTokens[1], Integer.parseInt(userTokens[2]));
				people.put(fName, p);
		      

			}
		}
		firstInput.close();
		System.out.println(people.toString());
		
		
		
		System.out.println("loading file (pass 2 of 2)");
/*
 * Second stage of file importing
 */
		Scanner secondInput = new Scanner(usersFile);
		// by a space
		while (secondInput.hasNextLine()) {
			// get info from data source
			String userDetails = secondInput.nextLine();
			userDetails = userDetails.trim();

			// parse user details string
			String[] allUserTokens = userDetails.split(delims);

			/*
			 * 
			 * userTokens[3] = mother
			 * userTokens[4] = father
			 */
			


			if (allUserTokens.length == 5){

				for(Entry<String, Person> entry : people.entrySet()){
					String name = allUserTokens[0];
					String gender = allUserTokens[1];
					Integer birthYear = Integer.parseInt(allUserTokens[2]);
					
					
					
					// if the character is not ? 
					
					/*
					 * datatype disaster
					 */
					//Person p = new Person(allUserTokens[0], allUserTokens[1], Integer.parseInt(allUserTokens[2]), allUserTokens[3],  allUserTokens[4]);
//					allPeople.put(name, p);
//					System.out.println(allPeople.toString());
					
					
				}
				
			//add();
				
				
			
					

			}
			
			//System.out.println(allPeople.toString());

			
		}
		secondInput.close();
	
		///System.out.println(people.toString());
		

	}
	@SuppressWarnings("unchecked")
// for addig people to a family
	public void add(Comparable item) {
		// check if the tree is empty, if it is we set the
		// input to be the root of the tree by casting it as a Node
		if(isEmpty()){
			person = (Person) item;
			personNum ++;
		}
		// if there is already items in the Tree, call the second 
		// addR method to handle it
		else{
			addR(item, person);
			personNum ++;
		}

	}

	@SuppressWarnings("unchecked")
	private void addR(Comparable item, Person current) {
		// check if what's coming in is less than 
		// the current Node

		// eg; item.lessThan(current)
		if(item.compareTo(current) > 0){
			if (current.getMother() == null )
				// cast the left item as a Node
				current.setMother((Person) item);
			else
				addR(item, current.getMother());
		}

		// else the item goes on the right child
		else{
			if (current.getFather() == null)
				current.setFather((Person) item);
			else
				addR(item, current.getFather());
		}
	}
	// end of add methods

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	}
	
	


