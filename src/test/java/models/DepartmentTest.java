package models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    @Test
    public void setDepName__true(){
        Department testDepartment=setUpDepartment();
        testDepartment.setDepName("Animation");
        assertNotEquals("Design",testDepartment.getDepName());
    }
    @Test
    public void getDescription_returnsCorrectDescription(){
        Department testDepartment=setUpDepartment();
        assertEquals("Designs are a live",testDepartment.getDescription());
    }
    @Test
    public void setDescription_true(){
        Department testDepartment=setUpDepartment();
        testDepartment.setDescription("Best Dishes");
        assertNotEquals("Designs are a live",testDepartment.getDescription());
    }
    @Test
    public void setId_setAnId_true(){
        Department testDepartment=setUpDepartment();
        testDepartment.setId(1);
        assertEquals(1,testDepartment.getId());
    }

}