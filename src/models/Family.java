package models;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import models.Person;

/*
 * This is the tree class
 * All code based on previous assignments
 */

public class Family<T extends Comparable<T>> {
	private Person root;
	//  This HashMap stores the leaves, or the bottoms of the nodes. The Character is the letter and the String is
	// the binary code obtained from traversing the tree
	public static Map <String, String> mp  = new HashMap <String, String>();

	public Family(Person root) {
		this.setRoot(root);
	}

	// Node class set to null
	private Person person = null;
	


	//Check if the array is empty or not, returns true if it is
	public boolean isEmpty() {
		if(person == null){
			return true;
		}
		else{
			return false;
		}
	}
/*
	 * @return the root
	 */
	public Person getRoot() {
		return root;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot(Person root) {
		this.root = root;
	}

	
	
}

