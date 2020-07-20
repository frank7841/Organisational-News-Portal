package dao;

import models.GeneralNews;

import java.util.List;

public interface GeneralNewsDao {
    void add(GeneralNews generalNews);//Create general news instance
    //READ
    List<GeneralNews> getAll();
    GeneralNews findById(int id);


    void deleteById(int id);//Delete by Id
    void deleteAll();//Delete All
}
