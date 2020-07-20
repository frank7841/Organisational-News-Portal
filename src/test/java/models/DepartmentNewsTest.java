package models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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


}