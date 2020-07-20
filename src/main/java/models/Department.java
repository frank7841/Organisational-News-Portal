package models;

import java.util.Objects;

public class Department {
    private String depName;
    private String description;
    private int id;

    public Department(String depName, String description) {
        this.depName = depName;
        this.description = description;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                depName.equals(that.depName) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depName, description, id);
    }
}
