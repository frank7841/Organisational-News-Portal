package models;

import java.util.Objects;

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
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentNews that = (DepartmentNews) o;
        return id == that.id &&
                departmentId == that.departmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId);
    }
}
