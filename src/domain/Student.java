package domain;

/**
 * @author liyu
 */
public class Student {
    private String id;
    private String name;
    private String deptName;
    private int totCred;

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

    public int getTotCred() {
        return totCred;
    }

    public void setTotCred(int totCred) {
        this.totCred = totCred;
    }

}
