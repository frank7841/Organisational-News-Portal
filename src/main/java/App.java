import Exception.ApiException;
import com.google.gson.Gson;
import dao.*;
import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.Users;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        Sql2oDepartmentDao departmentDao;
        Sql2oDepartmentNewsDao departmentNewsDao;
        Sql2oGeneralNewsDao generalNewsDao;
        Sql2oUsersDao usersDao;
        Connection con;
        Gson gson=new Gson();
        staticFileLocation("/");

        Sql2o sql2o = DB.sql2o;
        departmentDao=new Sql2oDepartmentDao(sql2o);
        departmentNewsDao=new Sql2oDepartmentNewsDao(sql2o);
        generalNewsDao=new Sql2oGeneralNewsDao(sql2o);
        usersDao=new Sql2oUsersDao(sql2o);

        get("/departments", "application/json", (req, res) -> {
            System.out.println(departmentDao.getAll());
            if(departmentDao.getAll().size() > 0){
                return gson.toJson(departmentDao.getAll());
            }
            else {
                return "{\"message\":\"Apologies , no departments are available.\"}";
            }
        });
        post("/department/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });
        get("/department/:id", "application/json", (req, res) -> {
            int idOfDepartmentToFind=Integer.parseInt(req.params("id"));
            Department departmentToFind=departmentDao.findById(idOfDepartmentToFind);
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentToFind);
        });
        post("/users/new", "application/json", (req, res) -> {
            Users user = gson.fromJson(req.body(), Users.class);
            usersDao.add(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });
        get("/users", "application/json", (req, res) -> {
            System.out.println(usersDao.getAll());
            if(usersDao.getAll().size() > 0){
                return gson.toJson(usersDao.getAll());
            }
            else {
                return "{\"message\":\"Apologies , no users are available.\"}";
            }
        });
        get("/users/:id", "application/json", (req, res) -> {
            int idOfUserToFind=Integer.parseInt(req.params("id"));
            Users userToFind=usersDao.findById(idOfUserToFind);
            if (userToFind == null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(userToFind);
        });
        get("/generalnews", "application/json", (req, res) -> {

            int sizeNews = generalNewsDao.getAll().size();
            if (sizeNews == 0){
                throw new ApiException(404, String.format("No general news available"));
            }
            return gson.toJson(generalNewsDao.getAll());

        });
        post("/generalnews/new", "application/json", (req, res) -> {
            GeneralNews generalNews = gson.fromJson(req.body(), GeneralNews.class);//            ;
            generalNewsDao.add(generalNews);
            res.status(201);
            return gson.toJson(generalNews);
        });
        get("/departmentnews", "application/json", (req, res) -> {
            System.out.println(departmentNewsDao.getAll());
            System.out.println(DepartmentNews.getDatabaseType());
            int sizeNews = departmentNewsDao.getAll().size();
            if (sizeNews == 0){
                throw new ApiException(404, String.format("No departmental news available"));
            }
            return gson.toJson(departmentNewsDao.getAll());
        });
        post("/departmentnews/new", "application/json", (req, res) -> {
            DepartmentNews departmentNews = gson.fromJson(req.body(), DepartmentNews.class);
            System.out.println(departmentNews.getDepartmentid());
            departmentNewsDao.add(departmentNews);
            res.status(201);
            return gson.toJson(departmentNews);
        });
        get("/users/department/:id", "application/json", (req, res) -> {
            int departmentId=Integer.parseInt(req.params("id"));
            System.out.println(departmentId);
            int sizeUsers = departmentDao.getAllUsersByDepartment(departmentId).size();
            if (sizeUsers == 0){
                throw new ApiException(404, String.format("No users available in this department"));
            }
            return gson.toJson(departmentDao.getAllUsersByDepartment(departmentId));
        });
        get("/departmentnews/department/:id", "application/json", (req, res) -> {
            int departmentId=Integer.parseInt(req.params("id"));
            System.out.println(departmentDao.getAllDepartmentNewsForDepartment(departmentId));

            int sizeNews = departmentDao.getAllDepartmentNewsForDepartment(departmentId).size();
            if (sizeNews == 0){
                throw new ApiException(404, String.format("No news available for this department"));
            }
            return gson.toJson(departmentDao.getAllDepartmentNewsForDepartment(departmentId));
        });





//Implementing filters
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
