package dao;

import junit.framework.TestCase;
import models.Department;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentDaoTest {
    public Department setupNewDepartment(){
        return new Department("production","Furnace of the Company");
    }
    public Department setupAnotherDepartment(){
        return new Department("Advertising","We sale unsaleable");
    }
    private static Sql2oDepartmentDao departmentDao;
    private static Connection con;

    @BeforeClass
    public static void setUp() throws Exception {
        departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        con = DB.sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentDao.deleteAll();
    }
    @AfterClass
    public static void shutDown() throws Exception {
        con.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addDepartment_returnsCorectlySetId() throws Exception {
        Department testDepartment = setupNewDepartment();
        int originalDepartmentId = testDepartment.getId();
        departmentDao.add(testDepartment);
        assertEquals(originalDepartmentId,testDepartment.getId());
    }
    @Test
    public void addedDepartmentsAreReturnedFromGetAll() throws Exception {
        Department testDepartment = setupNewDepartment();
        Department newTestDepartment=setupAnotherDepartment();
        departmentDao.add(testDepartment);
        departmentDao.add(newTestDepartment);
        assertEquals(2, departmentDao.getAll().size());
    }
    @Test
    public void noDepartmentsReturnsEmptyList() throws Exception {
        assertEquals(0, departmentDao.getAll().size());
    }


}