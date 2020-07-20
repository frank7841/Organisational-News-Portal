package dao;

import models.Department;
import models.DepartmentNews;
import models.Users;

import java.util.List;

public interface DeapartmentDao {
    void add(Department department);//Create department

    //Reading Data
    List<Department> getAll();
    Department findById(int id);
    List<Users> getAllUsersByDepartment(int id);
    List<DepartmentNews> getAllDepartmentNewsForDepartment(int id);

    //Update department
    void update(int id,String name,String description);

    void deleteById(int id);//delete records by Id
    void deleteAll();//Delete all
}
