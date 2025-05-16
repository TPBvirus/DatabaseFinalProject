package hr.dao;

import java.util.List;

import hr.dao.exception.DaoException;

/**
 * StudentDao
 * 
 * Interface for Data Access Object, Student
 *   
 * Modifications:
 * 12/06/24: tpbvirus created
 *
 */


public interface StudentDao {
    StudentDto get(Integer id) throws DaoException;
    
    StudentDto getRow(String field, Object value) throws DaoException;
    
    List<StudentDto> getRows(String field, Object value) throws DaoException;
    
    List<StudentDto> getAll() throws DaoException;
    
    void save(StudentDto t) throws DaoException;
    
    void update(StudentDto t, String[] params) throws DaoException;

    void delete(StudentDto t) throws DaoException;

}
