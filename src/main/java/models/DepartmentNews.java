package models;

public class DepartmentNews extends News{
    private int id;
    private int departmentid;
    private static final String DATABASE_TYPE="department";//constant

    public DepartmentNews(String content, int userid, int departmentid) {
        this.content=content;
        this.userid=userid;
        this.departmentid=departmentid;
        type = DATABASE_TYPE;
    }
}
