package models;

import java.util.Objects;

public class Users {
    private String username;
    private String positionInCompany;
    private String role;
    private int id;
    private int departmentId;

    public Users(String username, String positionInCompany, String role, int departmentId) {
        this.username = username;
        this.positionInCompany = positionInCompany;
        this.role = role;
        this.departmentId = departmentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPositionInCompany() {
        return positionInCompany;
    }

    public void setPositionInCompany(String positionInCompany) {
        this.positionInCompany = positionInCompany;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                departmentId == users.departmentId &&
                username.equals(users.username) &&
                positionInCompany.equals(users.positionInCompany) &&
                role.equals(users.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, positionInCompany, role, id, departmentId);
    }
}
