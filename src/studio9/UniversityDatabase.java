package studio9;

import java.util.Map;
import java.util.HashMap;


import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> myMap;


	public UniversityDatabase() {
		this.myMap = new HashMap<String, Student>();

	}
	
	public void addStudent(String accountName, Student student) {
		this.myMap.put(accountName, student);
	}

	public int getStudentCount() {
		// TODO
		return this.myMap.size();
	}

	public String lookupFullName(String accountName) {
		// TODO: Complete according to studio instructions
		if(accountName == null || this.myMap.get(accountName) == null) {
			return null;
		}
		else {
			return this.myMap.get(accountName).getFullName();
		}
	}

	public double getTotalBearBucks() {
		// TODO
		double total = 0.0;
		for(Map.Entry<String, Student> s : myMap.entrySet()) {
			total+=s.getValue().getBearBucksBalance();
		}
		return total;		
	}
}
