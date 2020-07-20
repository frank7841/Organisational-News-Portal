package models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class UsersTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public Users setUpUsers() {
        return new Users("frankline", "CTO", "Oversee ICT", 1);
    }

    @Test
    public void instanciatesCorrectly_true() {
        Users testUser = setUpUsers();
        assertEquals(true, testUser instanceof Users);
    }

    @Test
    public void getName_returnsCorrectName() {
        Users testUser = setUpUsers();
        assertEquals("frankline", testUser.getUsername());
    }

    @Test
    public void setUsername_true() {
        Users testUser = setUpUsers();
        testUser.setUsername("marko");
        assertNotEquals("frankline", testUser.getUsername());
    }

    @Test
    public void getPositionInCOmpany_returnsCorrectPosition() {
        Users testUser = setUpUsers();
        assertEquals("CTO", testUser.getPositionInCompany());
    }

    @Test
    public void setPositionInCompany_true() {
        Users testUser = setUpUsers();
        testUser.setPositionInCompany("Director");
        assertNotEquals("CTO", testUser.getPositionInCompany());
    }

    @Test
    public void getRole_returnsCorrectRole() {
        Users testUser = setUpUsers();
        assertEquals("Oversee ICT", testUser.getRole());
    }

    @Test
    public void setRole_true() {
        Users testUser = setUpUsers();
        testUser.setRole("Direct");
        assertNotEquals("Oversee ICT", testUser.getRole());

    }
    @Test
    public void setId_true(){
        Users testUser=setUpUsers();
        testUser.setId(1);
        assertEquals(1,testUser.getId());
    }
    @Test
    public void getDepartmentId_returnsCorrectDepartment(){
        Users testUser=setUpUsers();
        assertEquals(1,testUser.getDepartmentId());
    }
    @Test
    public void setDepartmentId_true(){
        Users testUser=setUpUsers();
        testUser.setDepartmentId(4);
        assertEquals(4,testUser.getDepartmentId());
    }

}