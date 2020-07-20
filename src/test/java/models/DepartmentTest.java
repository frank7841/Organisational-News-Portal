package models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentTest{
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    public Department setUpDepartment(){
        return new Department("Design","Designs are a live");
    }
    @Test
    public void DepartmentInstanciatesCorrectly_true(){
        Department testDepartment=setUpDepartment();
        assertEquals(true,testDepartment instanceof Department);
    }
    @Test
    public void getDepName_returnsCorrectDepartmentName(){
        Department testDepartment=setUpDepartment();
        assertEquals("Design",testDepartment.getDepName());
    }


}