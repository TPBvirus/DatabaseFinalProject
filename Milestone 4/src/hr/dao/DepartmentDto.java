package hr.dao;

public class DepartmentDto extends BaseDto {
	int departmentId;
	String deptName;
	String deptDecsription;
	int universityId;
	
	public DepartmentDto() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int deptId) {
		this.departmentId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String name) {
		this.deptName = name;
	}

	public String getDeptDecsription() { return deptDecsription;}

	public void setDeptDecsription(String deptDecsription) {this.deptDecsription = deptDecsription; }

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int id) {
		this.universityId = id;
	}
	
}
