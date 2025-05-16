package hr.dao;

/**
 * EmployeeDto
 * 
 * Data Transfer Object for Employee 
 *   
 * Modifications:
 * 
 * 		04/20/2024 - jhui - Created
 */
public class DemographicsDto extends UserDto {
	int userId;
	int demographicsId;
	String gender;
	int age;
	String ethnicity;

	//contains data for demographics

	public DemographicsDto() {
		super();
	}
	
	public void setUserId(int id) {
		userId = id;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setDemographicsId(int id) { this.demographicsId = id; }

	public int getDemographicsId() {return this.demographicsId; }

	public void setGender(String gender) {this.gender = gender; }

	public String getGender() {return this.gender; }

	public void setAge(int age) {this.age = age; }

	public int getAge() {return this.age; }

	public  void setEthnicity(String ethnicity) { this.ethnicity = ethnicity; }

	public String getEthnicity() {return this.ethnicity; }



}
