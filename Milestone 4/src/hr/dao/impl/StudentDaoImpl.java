package hr.dao.impl;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import hr.dao.BaseDto;
import hr.dao.UserDao;
import hr.dao.UserDto;
import hr.dao.StudentDao;
import hr.dao.StudentDto;
import hr.dao.exception.DaoException;
import util.jdbc.JdbcConnection;

/**
 * EmployeeDaoImpl
 * 
 * Implementation for EmployeeDao (Data Access Object) 
 *   
 * Modifications:
 * 
 * 		04/20/2024 - jhui - Created
 */


public class StudentDaoImpl extends BaseDaoImpl implements StudentDao {
	String _tableName = "Student";
	String _primaryKey = "StudentID";
	Properties _empQueries = null;
	
	public StudentDaoImpl() {
		super();
		
		_empQueries = new Properties();
		try {
			_empQueries.load(this.getClass().getClassLoader().getResourceAsStream("hr/sql/sql.properties"));
			//String query = _empQueries.getProperty("EMP_UPDATE");
			//System.out.println("Update query: \n" + query);
		}
		catch (IOException io) {
			System.out.println("Exception during sql.properties load: " + io);
		}
	}
	
	public StudentDto get(Integer id) throws DaoException {
		return (StudentDto) super.get(id);
	}
	
	public StudentDto getRow(String field, Object value) throws DaoException {
		return (StudentDto) super.getRow(field, value);
	}
	
	
	/**
	 * save
	 * 
	 * Convert the DTO into a SQL row and INSERT into the table
	 *   
	 * @param StudentDto t - DTO that contains the values for the new row
	 */
    public void save(StudentDto t) throws DaoException {
    	// write to DB
    	
    	return;
    }
    
	/**
	 * update
	 * 
	 * Update the corresponding row in the database for the DTO with the 
	 * values in params
	 *   
	 * @param StudentDto t - pull the primary key out of t
	 * @param String[] params - values to update the row 
	 * 	 
	 */
    public void update(StudentDto t, String[] params) throws DaoException{
		// update DB
		try{
			Connection connection = JdbcConnection.getConnection();
			connection.setAutoCommit(true);

			String sql = "INSERT INTO " + params[0] + "(StudentID, Subject, Email, First_Name, Last_Name, DegreeLevel, Year, UserIO)"+ " VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, t.getStudentId());
			statement.setString(2, t.getSubject());
			statement.setString(3, t.getEmail());
			statement.setString(4, t.getFirstName());
			statement.setString(5, t.getLastName());
			statement.setString(6, t.getDegreeLevel());
			statement.setInt(7, t.getYear());
			statement.setInt(8, t.getUserId());

			statement.executeUpdate(sql);
			System.out.println("Executing first statement");

			connection.close();

			Connection connection2 = JdbcConnection.getConnection();
			connection2.setAutoCommit(true);

			System.out.printf("%s\n", params[1]);
			String sqls = "INSERT INTO " + params[1] + "(LocationID, StreetAddress, City, County, Remote, StudentID)" + "VALUES(?,?,?,?,?,?)";
			PreparedStatement statement2 = connection2.prepareStatement(sqls);
			statement2.setInt(1, t.getLocationID());
			statement2.setString(2, t.getStreetAddress());
			statement2.setString(3, t.getCity());
			statement2.setString(4, t.getCounty());
			statement2.setString(5, t.getRemote());
			statement2.setInt(6, t.getStudentId());
			System.out.printf(statement2.toString());
			System.out.println("Executing last statement");
			statement2.executeUpdate(sqls);
		}
		catch(Exception e){
			System.out.println(e);
		}


		return;
	}
    
	/**
	 * delete
	 * 
	 * Delete the corresponding row in the database for the DTO
	 *   
	 * @param EmployeeDto t - pull the primary key out of t
	 * 	 
	 */
    public void delete(StudentDto t) throws DaoException {
    	// delete from DB
    	
    	return;
    }
    
    /**
     * convertRStoDto
     * 
     * Utility method that copies the values in the ResultSet into the DTO.
     * Needed specific implementation for the method getMultipleRows in the
     * BaseDaoImpl.
     * 
     * @param ResultSet result - the source values from a query to the DB
     * @param BaseDto dto - the destination Data Transfer Object
     */
    void convertRStoDto(ResultSet result, BaseDto dto) throws DaoException {
    	StudentDto stud = (StudentDto) dto;
    	try {
    		stud.setStudentId(result.getInt(1));
    		stud.setLastName(result.getString(2));
    		stud.setFirstName(result.getString(3));
			stud.setEmail(result.getString(4));
			stud.setUserId(result.getInt(5));
			stud.setSubject(result.getString(6));
			stud.setDegreeLevel(result.getString(7));
			stud.setYear(result.getInt(8));
			stud.setLocationID(result.getInt(9));
			stud.setStreetAddress(result.getString(10));
			stud.setCity(result.getString(11));
			stud.setCounty(result.getString(12));
			stud.setRemote(result.getString(13));
    	}
    	catch (SQLException se) {
    		throw new DaoException(se.getMessage());
    	}
    }
    
    /**
     * getAllRowsQuery
     * 
     * Returns the query for retrieving all rows for this table
     * 
     * @return String - equivalent to "select * from tableName"
     */
    String getAllRowsQuery() {
		return _empQueries.getProperty("STUDENT_GET_ALL_WITH_LOCATION");
    }
    
    /**
     * getInsertQuery
     * 
     * Returns the INSERT query for this table
     * 
     * @return String - INSERT query
     */
    public String getInsertQuery() {
		return _empQueries.getProperty("STUDENT_INSERT");
    }
    
    /**
     * getDeleteQuery
     * 
     * Returns the DELETE query for this table
     * 
     * @return String - DELETE query
     */
    String getDeleteQuery() {
		return _empQueries.getProperty("STUDENT_DELETE_ID");
    }
    
    /**
     * getUpdateQuery
     * 
     * Returns the UPDATE query for this table
     * 
     * @return String - UPDATE query
     */
    String getUpdateQuery() {
		return _empQueries.getProperty("STUDENT_UPDATE_ID");
    }
    
    /**
     * getPrimaryKey
     * 
     * Returns the Primary Key for this table
     * 
     * @return String - Primary Key 
     */
    String getPrimaryKey() {
		return _primaryKey;
    }
   
    
    /**
     * getDto
     * 
     * Returns the appropriate Data Transfer Object for this Data Access Object.
     * 
     * @return appropriate DTO
     */
    BaseDto getDto() {
    	return new StudentDto();
    }
}
