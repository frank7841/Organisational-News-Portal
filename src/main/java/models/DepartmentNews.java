package models;

public class DepartmentNews extends News{
    private int id;
    private int departmentId;
    private static final String DATABASE_TYPE="department";//constant

    public DepartmentNews(String content, int userid, int departmentId) {
        this.content=content;
        this.userid=userid;
        this.departmentId=departmentId;
        type = DATABASE_TYPE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentid() {
        return departmentId;
    }

    public void setDepartmentid(int departmentId) {
        this.departmentId = departmentId;
    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }
}
