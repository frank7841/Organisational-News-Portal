package dao;

import junit.framework.TestCase;
import models.GeneralNews;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oGeneralNewsDaoTest{
    public GeneralNews setupNewGeneralNews(){
        return new GeneralNews("Early weekend",2);
    }
    public GeneralNews setupNewGeneralNews1(){
        return new GeneralNews("Agm meeting",3);
    }
    private static Sql2oGeneralNewsDao generalNewsDao;
    private static Connection con;

    @BeforeClass
    public static void setUp() throws Exception {
        generalNewsDao=new Sql2oGeneralNewsDao(DB.sql2o);
        con = DB.sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        generalNewsDao.deleteAll();
    }
    @AfterClass
    public static void shutDown() throws Exception { //changed to static
        con.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addingGeneralNewsSetsId() throws Exception {
        GeneralNews testGeneralNews = setupNewGeneralNews();
        int originalGeneralNewsId = testGeneralNews.getId();
        generalNewsDao.add(testGeneralNews);
        assertNotEquals(originalGeneralNewsId,testGeneralNews.getId());
    }
    @Test
    public void addedGeneralNewssAreReturnedFromGetAll() throws Exception {
        GeneralNews testGeneralNews = setupNewGeneralNews();
        GeneralNews testGeneralNews1=setupNewGeneralNews1();
        generalNewsDao.add(testGeneralNews);
        generalNewsDao.add(testGeneralNews1);
        assertEquals(2, generalNewsDao.getAll().size());
    }
    @Test
    public void noGeneralNewsReturnsEmptyList() throws Exception {
        assertEquals(0, generalNewsDao.getAll().size());
    }
}