package test;

import java.util.List;

import hr.dao.StudentDao;
import hr.dao.StudentDto;
import hr.dao.impl.StudentDaoImpl;

/**
 * Employee
 *
 * Test class to access for Employee.
 *
 * Modifications:
 *
 * 		04/20/2024 - jhui - Created.
 */

public class Student {

	public Student() { }

	public static void main(String[] args) {
		System.out.println("Entering test.Student.main");

		StudentDao studentDao = new StudentDaoImpl();
		StudentDto studentDto = null;
		List<StudentDto> studentDtoList = null;

		try {
			int test = 1;
			switch(test) {
				case 1:

					String params[] = new String[2];
					params[0] = "Student";
					params[1] = "StudentLocation";

					studentDto = new StudentDto();
					studentDto.setFirstName("John");
					studentDto.setLastName("Smith");
					studentDto.setStudentId(9851235);
					studentDto.setSubject("Political Science");
					studentDto.setUserId(3491229);
					studentDto.setEmail("jsmith@sfsu.edu");
					studentDto.setDegreeLevel("Senior");
					studentDto.setYear(2026);

					studentDto.setLocationID(3);
					studentDto.setCity("Sunnyvale");
					studentDto.setStreetAddress("80 Washington St.");
					studentDto.setCounty("Santa Clara");
					studentDto.setRemote("N/A");
					studentDao.update(studentDto, params);
					break;

				case 2:
					studentDtoList = studentDao.getRows("state", "CA");
					for (int i = 0; i < studentDtoList.size(); i++) {
						studentDto = studentDtoList.get(i);
						System.out.println("\nReturned Student(" + studentDto.getUserId() + "):" + studentDto.toJson());
					}
					break;

				default:
					System.out.println("Invalid test");
			}
			//print out db with locations
			studentDtoList = studentDao.getAll();
			for (int i = 0; i < studentDtoList.size(); i++) {
				studentDto = studentDtoList.get(i);
				System.out.println("\nReturned Student(" + studentDto.getStudentId() + "):" + studentDto.toJson());
			}
		}
		catch (Throwable th) {
			System.out.println(th.getMessage());
		}

	}

}
