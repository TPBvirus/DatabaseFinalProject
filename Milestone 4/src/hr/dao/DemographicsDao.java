package hr.dao;

import hr.dao.exception.DaoException;

import java.util.List;

/**
 * EmployeeDao
 * 
 * Interface for Data Access Object, EmployeeDao 
 *   
 * Modifications:
 * 
 * 		04/20/2024 - jhui - Created
 */


public interface DemographicsDao {
    StudentDto get(Integer id) throws DaoException;
    
    StudentDto getRow(String field, Object value) throws DaoException;
    
    List<StudentDto> getRows(String field, Object value) throws DaoException;
    
    List<StudentDto> getAll() throws DaoException;
    
    void save(UserDto t) throws DaoException;
    
    void update(UserDto t, String[] params) throws DaoException;
    
    void delete(UserDto t) throws DaoException;

}
