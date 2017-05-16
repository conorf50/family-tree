package models;

import java.util.Iterator;

/*
	 * From the given file, a person has:
	 * Name
	 * Gender
	 * Year of Birth
	 * Mother (if known)
	 * Father (if known)
	 */
	public class Person <T extends Comparable<T>> implements Iterable<T>{

		//in order based on file
		private String name;
		private String gender;
		private int birthYear;
		private Person<String> mother;
		private Person<String> father;



		/**
		 * @param name
		 * @param gender
		 * @param birthYear
		 * @param mother
		 * @param father
		 */


		
		/*
		 * We store Person objects for the mother and father because they are seperate people.
		 * We can also compare these as well 
		 */
		public Person(String name, String gender, int birthYear, Person<String> mother, Person<String> father) {
			super();
			this.name = name;
			this.gender = gender;
			this.birthYear = birthYear;
			this.mother = mother;
			this.father = father;
		
		}



	

		public Person() {
			// TODO Auto-generated constructor stub
		}





		public String getName() {
			return name;
		}

	
		



		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public void setName(String name) {
			this.name = name;
		}
		 
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
	




		public String getName(String name){
			return name;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Person [" + (name != null ? "name=" + name + ", " : "")
					+ (gender != null ? "gender=" + gender + ", " : "") + "birthYear=" + birthYear + ", "
					+ (mother != null ? "mother=" + mother + ", " : "") + (father != null ? "father=" + father : "")
					+ "]";
		}





		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getBirthYear() {
			return birthYear;
		}

		public void setBirthYear(int birthYear) {
			this.birthYear = birthYear;
		}

		public Person<String> getMother() {
			return mother;
		}

		public void setMother(Person<String> mother) {
			this.mother = mother;
		}

		public Person<String> getFather() {
			return father;
		}

		public void setFather(Person<String> father) {
			this.father = father;
		}

	
		public int compareTo(Person<?> p) {
			// TODO Auto-generated method stub
			return name.compareTo(p.getName());
		}


		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}





		public Person<String> getFatherName() {

			return father;
		}

		public Person<String> getMotherName() {

			return mother;
		}


		

		
		

		
		
		
}
