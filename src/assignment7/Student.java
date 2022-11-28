package assignment7;

public class Student {

	private String firstName = "";// First Name
	private String lastName = "";// Last Name
	private int sID = 0;// Student ID Number
	private int att = 0;// Attempted Credits
	private int pass = 0;// Passing Credits
	private double gqp = 0; // Total Grade Quality Points
	private double bb = 0.0;// Bear Bucks Balance
	/*
	 * Constructs a student without a bb count
	 * @param firstName is the students firstname
	 * @param lastName is the students lastname
	 * @param myInt is the students ID
	 */
	public Student(String firstName, String lastName, int myInt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sID = myInt;
	}
	/*
	 * Constructs a student with a bb count
	 * @param firstName is the students firstname
	 * @param lastName is the students lastname
	 * @param myInt is the students ID
	 * @param bb is the students bear bucks count
	 */
	public Student(String firstName, String lastName, int myInt, double bb) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sID = myInt;
		this.bb = bb;
	}
	/*
	 * Returns the students full name
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	/*
	 * Returns the students ID
	 */
	public int getId() {
		return sID;
	}
	/*
	 * adds a grade to the student's gpa.
	 * @param grade is the grade in the course
	 * @param credit is the credit that class is worth
	 */
	public void submitGrade(double grade, int credit) {
		att += credit;
		if (grade >= 1.7) {
			pass += credit;
		}
		gqp += credit * grade;
	}

	/*
	 * Returns the credits the student has attempted
	 */
	public int getTotalAttemptedCredits() {
		return att;
	}
	/*
	 * Returns the credits the student has passed
	 */
	public int getTotalPassingCredits() {
		return pass;
	}
	/*
	 * Sets the student's firstname
	 * @param fn is the student's new firstname
	 */
	public void setFirstName(String fn) {
		firstName = fn;
	}

	/*
	 * Caclulates the students GPA
	 */
	public double calculateGradePointAverage() {
		return gqp / att; 
	}
	/*
	 * Returns a string with the student's class standing
	 */
	public String getClassStanding() {
		if (pass < 30) {
			return "First Year";
		} else if (pass < 60) {
			return "Sophomore";
		} else if (pass < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	/*
	 * Returns boolean if student is eligible for PBK
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (pass >= 98 && gqp / att >= 3.6 || pass >= 75 && gqp / att >= 3.8) {
			return true;
		}
		return false;
	}
	/*
	 * deposits amount bear bucks into the student's account
	 * @param amount is the amount of BB depoisited
	 */
	public void depositBearBucks(double amount) {
		bb += amount;
	}
	/*
	 * deducts amount bear bucks into the student's account
	 * @param amount is the amount of BB deducted
	 */
	public void deductBearBucks(double amount) {
		bb -= amount;
	}
	/*
	 * returns the bearbucks in the students account
	 */
	public double getBearBucksBalance() {
		return bb;
	}
	/*
	 * cashes out bear bucks from the students account, with a 10$ fee.
	 */
	public double cashOutBearBucks() {
		double temp = bb;
		bb = 0;
		if (temp <= 10) {
			return 0;
		} else {
			return temp - 10;
		}
	}
	/*
	 * Creates a legacy student from two parents, dropping down those parent's bearbucks balances.
	 * @param firstName is the students firstname
	 * @param other is the other parent to drop balance from
	 * @param isHyphenated is if the lastname is hyphenated both parents' names.
	 * @param id is the student's new id.
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		int p1ID = this.sID;
		String p1lastName = this.lastName;
		if (isHyphenated) {
			return new Student(firstName, p1lastName + "-" + other.lastName, id,
					this.cashOutBearBucks() + other.cashOutBearBucks());
		}
		return new Student(firstName, p1lastName, id, this.cashOutBearBucks() + other.cashOutBearBucks());
	}
	/*
	 * Returns the student name and ID.
	 */
	public String toString() {
		return getFullName() + " " + getId();
	}
}
