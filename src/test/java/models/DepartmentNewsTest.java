package models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DepartmentNewsTest{
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
    public DepartmentNews setUpDepartmentNews(){
        return new DepartmentNews("Check Your emails for meeting transcript",1,1);
    }
    @Test
    public void DepartmentNews_instanciatesCorrectly_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals(true,testDepartmentNews instanceof News);
    }
    @Test
    public void getContent_returnsCorrectNews_Content(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals("Check Your emails for meeting transcript",testDepartmentNews.getContent());
    }
    @Test
    public void setContent_setAContent_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setContent("No meeting today");
        assertNotEquals("Check Your emails for meeting transcript",testDepartmentNews.getContent());
    }
    @Test
    public void setId_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setId(4);
        assertEquals(4,testDepartmentNews.getId());
    }
    @Test
    public void getUserId_returnsCorrectUserId(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals(1,testDepartmentNews.getUserid());
    }
    @Test
    public void setUserId_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setUserid(2);
        assertNotEquals(1,testDepartmentNews.getUserid());
    }
    @Test
    public void getDepartmentId_returnsCorrectDepartmentId(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals(1,testDepartmentNews.getDepartmentid());
    }
    @Test
    public void setDepartmentId_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setDepartmentid(5);
        assertNotEquals(1,testDepartmentNews.getDepartmentid());
    }
    @Test
    public void getDatabaseType_returnsCorrectDepartmentType(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        assertEquals("department",testDepartmentNews.getDatabaseType());
    }
    @Test
    public void setType_setAType_true(){
        DepartmentNews testDepartmentNews=setUpDepartmentNews();
        testDepartmentNews.setDatabaseType("company");
        assertEquals("department",testDepartmentNews.getDatabaseType());
    }

}