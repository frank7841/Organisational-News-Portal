package dao;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oUsersDao implements UsersDao {
    private final Sql2o sql2o;

    public Sql2oUsersDao(Sql2o sql2o){
        this.sql2o=sql2o;
    }
    @Override
    public void add(Users users){
        String sql = "INSERT INTO users (username,positionincompany,role,departmentid) VALUES (:Username,:positionincompany,:role,:departmentid)";
        try (Connection con=sql2o.open()){
            int id=(int) con.createQuery(sql,true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public List<Users> getAll(){
        try(Connection con= sql2o.open()){
            return con.createQuery("SELECT * FROM users ")
                    .executeAndFetch(Users.class);
        }
    }
    @Override
    public Users findById(int id){
        try(Connection con=sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE id = :id ")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Users.class);
        }
    }
    @Override
    public List<GeneralNews> getAllGerneralNewsForUser (int id){
        ArrayList<GeneralNews> generalNews=new ArrayList<>();
        String sql="SELECT * FROM news WHERE type='general' AND id = :userid";
        try(Connection con=sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(GeneralNews.class);
        }    catch (Sql2oException ex){
            System.out.println(ex);
        }
        return generalNews;
    }
    @Override
    public List<DepartmentNews> getAllDepartmentNewsForUser (int id){
        ArrayList<DepartmentNews> departmentNews=new ArrayList<>();
        String sql="SELECT * FROM news WHERE type='department' AND id = :userid";
        try(Connection con=sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(DepartmentNews.class);
        }    catch (Sql2oException ex){
            System.out.println(ex);
        }
        return departmentNews;
    }

    @Override
    public void update(int id,String newUsername,String newPositionInCOmpany,String newRole,int newDepartmentid){
        String sql="UPDATE users SET (username, positionincompany, role, departmentid) = (:username, :positionincompany, :role, :departmentid)";
        try(Connection con=sql2o.open()){
            con.createQuery(sql)
                    .addParameter("username", newUsername)
                    .addParameter("positionincompany",newPositionInCOmpany)
                    .addParameter("role",newRole)
                    .addParameter("departmentid",newDepartmentid)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void deleteById(int id){
        String sql="DELETE FROM users WHERE id=:id";
        try(Connection con=sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public void deleteAll(){
        try(Connection con=sql2o.open()){
            con.createQuery("DELETE FROM users")
                    .executeUpdate();
        }
    }
}