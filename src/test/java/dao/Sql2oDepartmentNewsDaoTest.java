package dao;

import junit.framework.TestCase;
import models.DepartmentNews;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentNewsDaoTest {
    public DepartmentNews setupNewDepartmentNews(){
        return new DepartmentNews("We are having a gdepartment meeting",1,2);
    }
    public DepartmentNews setupNewDepartmentNews1(){ return new DepartmentNews("Projects should be submitted to the project supervisors ",2,3);
    }
    private static Sql2oDepartmentNewsDao departmentNewsDao;
    private static Connection con;

    @BeforeClass
    public static void setUp() throws Exception {
        departmentNewsDao=new Sql2oDepartmentNewsDao(DB.sql2o);
        con = DB.sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentNewsDao.deleteAll();
    }
    @AfterClass
    public static void shutDown() throws Exception {
        con.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addingDepartmentNewsSetsId() throws Exception {
        DepartmentNews testDepartmentNews = setupNewDepartmentNews();
        int originalDepartmentNewsId = testDepartmentNews.getId();
        departmentNewsDao.add(testDepartmentNews);
        assertNotEquals(originalDepartmentNewsId,testDepartmentNews.getId());
    }
    @Test
    public void addingDepartmentNewsAddsDepartmentIdId() throws Exception {
        DepartmentNews testDepartmentNews = setupNewDepartmentNews();
        departmentNewsDao.add(testDepartmentNews);
        assertEquals(2,testDepartmentNews.getDepartmentid());
    }
    @Test
    public void addingDepartmentNewsCanSetDepartmentIdId() throws Exception {
        DepartmentNews testDepartmentNews = setupNewDepartmentNews();
        testDepartmentNews.setDepartmentid(4);
        departmentNewsDao.add(testDepartmentNews);
        assertEquals(4,testDepartmentNews.getDepartmentid());
    }
    @Test
    public void addedDepartmentNewssAreReturnedFromGetAll() throws Exception {
        DepartmentNews testDepartmentNews = setupNewDepartmentNews();
        DepartmentNews testDepartmentNews1=setupNewDepartmentNews1();
        departmentNewsDao.add(testDepartmentNews);
        departmentNewsDao.add(testDepartmentNews1);
        assertEquals(2, departmentNewsDao.getAll().size());
    }
    @Test
    public void noDepartmentNewsReturnsEmptyList() throws Exception {
        assertEquals(0, departmentNewsDao.getAll().size());
    }
    @Test
    public void deleteByIdDeletesCorrectDepartmentNews() throws Exception {
        DepartmentNews departmentNews = setupNewDepartmentNews();
        departmentNewsDao.add(departmentNews);
        departmentNewsDao.deleteById(departmentNews.getId());
        assertEquals(0, departmentNewsDao.getAll().size());
    }


}