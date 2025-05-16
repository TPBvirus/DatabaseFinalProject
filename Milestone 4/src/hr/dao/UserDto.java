package hr.dao;

/**
 * UserDto
 * 
 * Data Transfer Object for User
 *   
 * Modifications:
 * 
 * 		12/06/2024 - tpbvirus - Created
 */


// Super-class for all users in the DB
public class UserDto extends BaseDto {
	int userId;
	int tutorId;
	int facultyId;
	int expertId;
	int studentId;
	String username;


	public UserDto() {
		super();
	}
	
	public void setUserId(int id) {
		userId = id;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setTutorId(int id) {this.tutorId = id;}

	public int getTutorId() { return this.tutorId;}

	public void setFacultyId(int id) {this.facultyId = id;}

	public int getFacultyId() { return this.facultyId;}

	public void setExpertId(int id) {this.expertId = id;}

	public int getExpertId() { return this.expertId;}

	public void setStudentId(int id) {this.studentId = id;}

	public int getStudentId() { return this.studentId;}

	public void setUsername(String username) {this.username = username;}

	public String getUsername() {return this.username;}

}
