package dao;

import models.GeneralNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oGeneralNewsDao implements GeneralNewsDao {
    private final Sql2o sql2o;
    public Sql2oGeneralNewsDao(Sql2o sql2o){
        this.sql2o=sql2o;
    }

    @Override
    public void add(GeneralNews generalNews){
        String sql="INSERT INTO news (content , userid , type) VALUES (:content , :userid , :type)";
        try(Connection con=sql2o.open()){
            int id=(int) con.createQuery(sql,true)
                    .bind(generalNews)
                    .executeUpdate()
                    .getKey();
            generalNews.setId(id);
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public List<GeneralNews> getAll(){
        try(Connection con= sql2o.open()){
            return con.createQuery("SELECT * FROM news WHERE type='general' ")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(GeneralNews.class);
        }
    }
    @Override
    public GeneralNews findById(int id){
        try(Connection con=sql2o.open()){
            return con.createQuery("SELECT * FROM news id = :id ")
                    .addParameter("id",id)
                    .executeAndFetchFirst(GeneralNews.class);
        }
    }
    @Override
    public void deleteById(int id){
        String sql="DELETE FROM news WHERE id = :id ";
        try(Connection con=sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
