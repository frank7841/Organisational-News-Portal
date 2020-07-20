import com.google.gson.Gson;
import dao.*;
import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.Users;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static spark.Spark.get;
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
        post("/users/new", "application/json", (req, res) -> {
            Users user = gson.fromJson(req.body(), Users.class);
            userDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });
        post("/generalnews/new", "application/json", (req, res) -> {
            GeneralNews generalNews = gson.fromJson(req.body(), GeneralNews.class);//            ;
            generalNewsDao.add(generalNews);
            res.status(201);
            return gson.toJson(generalNews);
        });
        post("/departmentnews/new", "application/json", (req, res) -> {
            DepartmentNews departmentNews = gson.fromJson(req.body(), DepartmentNews.class);
            System.out.println(departmentNews.getDepartmentid());
            departmentNewsDao.add(departmentNews);
            res.status(201);
            return gson.toJson(departmentNews);
        });
        get("/departments", "application/json", (req, res) -> {
            System.out.println(departmentDao.getAll());
            if(departmentDao.getAll().size() > 0){
                return gson.toJson(departmentDao.getAll());
            }
            else {
                return "{\"message\":\"Apologies , no departments are available.\"}";
            }
        });
        get("/departments/:id", "application/json", (req, res) -> {
            int idOfDepartmentToFind=Integer.parseInt(req.params("id"));
            Department departmentToFind=departmentDao.findById(idOfDepartmentToFind);
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentToFind);
        });
        get("/users", "application/json", (req, res) -> {
            System.out.println(userDao.getAll());
            if(userDao.getAll().size() > 0){
                return gson.toJson(userDao.getAll());
            }
            else {
                return "{\"message\":\"Apologies , no users are available.\"}";
            }
        });
        get("/users/:id", "application/json", (req, res) -> {
            int idOfUserToFind=Integer.parseInt(req.params("id"));
            Users userToFind=userDao.findById(idOfUserToFind);
            if (userToFind == null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(userToFind);
        });




    }
}
