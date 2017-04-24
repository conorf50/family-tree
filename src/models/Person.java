package models;



	/*
	 * From the given file, a person has:
	 * Name
	 * Gender
	 * Year of Birth
	 * Mother (if known)
	 * Father (if known)
	 * 
	 * Also we can add:
	 * Date of birth
	 * Grandmother
	 * Grandfather


	 */
	public class Person implements Comparable <Person>{
		
		//in order based on file
		private String name;
		private char gender;
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
		public Person(String name, char gender, int birthYear, Person mother, Person father) {
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

	
		@Override
		public String toString() {
			return "Person [" + (name != null ? "name=" + name + ", " : "") + "gender=" + gender + ", birthYear="
					+ birthYear + ", " + (mother != null ? "mother=" + mother + ", " : "")
					+ (father != null ? "father=" + father : "") + "]";
		}



		public void setName(String name) {
			this.name = name;
		}

		public char getGender() {
			return gender;
		}

		public void setGender(char gender) {
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

	
		@Override
		public int compareTo(Person p) {
			// TODO Auto-generated method stub
			return name.compareTo(p.getName());
		}

		
		
		
}
