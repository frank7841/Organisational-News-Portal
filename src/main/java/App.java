import com.google.gson.Gson;
import dao.*;
import models.Department;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static spark.Spark.post;

public class App {
    public static void main(String[] args){
        Sql2oDepartmentDao departmentDao;
        Sql2oDepartmentNewsDao departmentNewsDao;
        Sql2oGeneralNewsDao generalNewsDao;
        Sql2oUsersDao userDao;
        Connection conn;
        Gson gson=new Gson();
        Sql2o sql2o = DB.sql2o;
        departmentDao=new Sql2oDepartmentDao(sql2o);
        departmentNewsDao=new Sql2oDepartmentNewsDao(sql2o);
        generalNewsDao=new Sql2oGeneralNewsDao(sql2o);
        userDao=new Sql2oUsersDao(sql2o);


        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });
    }
}
