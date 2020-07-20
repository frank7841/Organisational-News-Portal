package models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UsersTest extends TestCase {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    public Users setUpUsers(){
        return new Users("Frankline","CTO","Oversee ICT",1);
    }
    @Test
    public void instanciatesCorrectly_true(){
        Users testUser=setUpUsers();
        assertEquals(true,testUser instanceof Users);
    }

}