package dao;

import models.DepartmentNews;
import models.GeneralNews;
import models.Users;

import java.util.List;

public interface UsersDao {
    void add(Users user);//Create User
//Read Users data
    List<Users> getAll();
    Users findById(int id);
    List<GeneralNews> getAllGerneralNewsForUser (int id);
    List<DepartmentNews> getAllDepartmentNewsForUser (int id);

//Update Users datails
    void update(int id,String userName,String positionInCompany,String role,int departmentId);

    void deleteById(int id);//delete user by Id
    void deleteAll();//delete all users
}
