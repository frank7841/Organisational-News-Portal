package models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GeneralNewsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public GeneralNews setUpGeneralNews() {
        return new GeneralNews("Agm meeting date", 2);
    }

    @Test
    public void GeneralNews_instanciatesCorrectly_true() {
        GeneralNews testGeneralNews = setUpGeneralNews();
        assertEquals(true, testGeneralNews instanceof News);
    }

    @Test
    public void getContent_returnsCorrectCOntent() {
        GeneralNews testGeneralNews = setUpGeneralNews();
        assertEquals("Agm meeting date", testGeneralNews.getContent());
    }

    @Test
    public void setContent_true() {
        GeneralNews testGeneralNews = setUpGeneralNews();
        testGeneralNews.setContent("Company layoffs");
        assertNotEquals("Agm meeting date ", testGeneralNews.getContent());
    }
    @Test
    public void getUserId_returnsCorrectUser_Id(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        assertEquals(2,testGeneralNews.getUserid());
    }
    @Test
    public void setUserId_true(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        testGeneralNews.setUserid(1);
        assertNotEquals(2,testGeneralNews.getUserid());
    }
    @Test
    public void getDatabaseType_returnsCorrectDepartmentTtype(){
        GeneralNews testGeneralNews=setUpGeneralNews();
        assertEquals("general",testGeneralNews.getDatabaseType());
    }
}