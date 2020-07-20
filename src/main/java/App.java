import com.google.gson.Gson;
import dao.*;
import org.sql2o.Sql2o;

import java.sql.Connection;

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
    }
}
