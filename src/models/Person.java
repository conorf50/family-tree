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
	
		private Person mother;
		private Person father;



		/**
		 * @param name
		 * @param gender
		 * @param birthYear
		 * @param mother
		 * @param father
		 * @param grandmother
		 * @param grandfather
		 */
		public Person(String name, String gender, int birthYear) {
			super();

			this.name = name;
			this.gender = gender;
			this.birthYear = birthYear;
			
			
	}

		
		//            name                   gender       birthyear       mother name   fathers name
		public Person(String name, String gender, int birthYear, Person mother, Person father) {
			super();
			this.name = name;
			this.gender = gender;
			this.birthYear = birthYear;
			this.mother = mother;
			this.father = father;
		
		}



		public String getName() {
			return name;
		}

	
		



		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "["+(name != null ? "name=" + name + "," : "")
					+ (gender != null ? "gender=" + gender + "," : "") + "birthYear=" + birthYear + ","
					+ (mother != null ? "mother=" + mother + "," : "") + (father != null ? "father=" + father : "")
					+ "]" + "\n";
		}


		public void setName(String name) {
			this.name = name;
		}
		 
		public String getName(String name){
			return name;
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

		public Person getMother() {
			return mother;
		}

		public void setMother(Person mother) {
			this.mother = mother;
		}

		public Person getFather() {
			return father;
		}

		public void setFather(Person father) {
			this.father = father;
		}

	
		public int compareTo(Person p) {
			// TODO Auto-generated method stub
			return name.compareTo(p.getName());
		}


		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}


		
		

		
		
		
}
