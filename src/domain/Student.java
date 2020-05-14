package domain;

/**
 * @author liyu
 */
public class Student {
    private String id;
    private String name;
    private String deptName;
    private String totCred;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", totCred='" + totCred + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTotCred() {
        return totCred;
    }

    public void setTotCred(String totCred) {
        this.totCred = totCred;
    }
}
