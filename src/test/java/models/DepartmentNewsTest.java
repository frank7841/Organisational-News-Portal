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


}