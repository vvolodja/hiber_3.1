package model;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dev_firstName")
    private String firstName;

    @Column(name = "dev_lastName")
    private String lastName;

    @Column(name = "dev_age")
    private int age;

    @Column(name = "comp_id")
    private int companyID;

    @Column(name = "dev_salary")
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name ="developer_project",
            joinColumns = @JoinColumn(name = "developer_id"),
//            referencedColumnName = "dev_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
//            , referencedColumnName = "proj_id")
    )

//    Getter & Setter

    private Collection<Project> projects;

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (getId() != developer.getId()) return false;
        if (getAge() != developer.getAge()) return false;
        if (getCompanyID() != developer.getCompanyID()) return false;
        if (getSalary() != developer.getSalary()) return false;
        if (!getFirstName().equals(developer.getFirstName())) return false;
        if (!getLastName().equals(developer.getLastName())) return false;
        return getProjects().equals(developer.getProjects());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getCompanyID();
        result = 31 * result + getSalary();
        result = 31 * result + getProjects().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", companyID=" + companyID +
                ", salary=" + salary +
                '}';
    }
}
