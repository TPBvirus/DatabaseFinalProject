package hr.dao;

/**
 * StudentDto
 * 
 * Data Transfer Object for Student
 *   
 * Modifications:
 * 
 * 		12/06/2024 - tpbvirus - Created
 */
public class StudentDto extends UserDto {
	int studentId;
	String lastName;
	String firstName;
	String email;
	String subject;
	String degreeLevel;
	int year;
	int locationID;
	String streetAddress;
	String city;
	String county;
	String remote;



	public StudentDto() {
		super();
	}
	
	public void setStudentId(int id) {
		this.studentId = id;
	}

	public int getYear(){ return this.year; }

	public void setYear(int year) { this.year = year; }
	
	public int getStudentId() { return this.studentId;}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String name) { firstName = name;}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setSubject(String subject) { this.subject = subject;}

	public String getSubject() { return subject; }

	public void setDegreeLevel(String level) { degreeLevel = level;}

	public String getDegreeLevel() {return degreeLevel;}

	public void setCity(String city) {this.city = city;}

	public String getCity() {return city;}

	public int getLocationID() {return locationID;}

	public void setLocationID(int locationID) {this.locationID = locationID;}

	public void setCounty(String county) {this.county = county;}

	public String getCounty() {return county;}

	public void setRemote(String remote) {this.remote = remote;}

	public String getRemote() {return this.remote;}

	public void setStreetAddress(String addr) {streetAddress = addr;}

	public String getStreetAddress() {return streetAddress;}

}
