package dao;

import models.DepartmentNews;

import java.util.List;

public interface DepartmentNewsDao {
    void add(DepartmentNews departmentnews);//create department news
//Read data from department news
    List<DepartmentNews> getAll();
    DepartmentNews findById(int id);



    void deleteById(int id);//delete by Id
    void deleteAll();//delete all
}
