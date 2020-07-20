package dao;

import junit.framework.TestCase;
import models.Users;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oUsersDaoTest {
    public Users setupNewUser(){
        return new Users("frankline","Manager","Overseeing Everything",1);
    }
    public Users setupNewUser1(){ return new Users("wakanda","Employee","Drying Code",2);
    }
    private static Sql2oUsersDao userDao;
    private static Connection con;

    @BeforeClass
    public static void setUp() throws Exception{
        userDao=new Sql2oUsersDao(DB.sql2o);
        con = DB.sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        userDao.deleteAll();
    }

    @AfterClass
    public static void shutDown() throws Exception { //changed to static
        con.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }

    @Test
    public void addingUserSetsId() throws Exception {
        Users testUser = setupNewUser();
        int originalUserId = testUser.getId();
        userDao.add(testUser);
        assertEquals(originalUserId,testUser.getId());
    }
    @Test
    public void addedUsersAreReturnedFromGetAll() throws Exception {
        Users testUser = setupNewUser();
        Users testUser1=setupNewUser1();
        userDao.add(testUser);
        userDao.add(testUser1);
        assertEquals(2, userDao.getAll().size());
    }
    @Test
    public void noUsersReturnsEmptyList() throws Exception {
        assertEquals(0, userDao.getAll().size());
    }
    @Test
    public void deleteByIdDeletesCorrectUsers() throws Exception {
        Users users = setupNewUser();
        userDao.add(users);
        userDao.deleteById(users.getId());
        assertEquals(0, userDao.getAll().size());
    }
    @Test
    public void deleteAll() throws Exception{
        Users testUser=setupNewUser();
        Users testUser1=setupNewUser1();
        userDao.add(testUser);
        userDao.add(testUser1);
        userDao.deleteAll();
        assertEquals(0,userDao.getAll().size());
    }

}

