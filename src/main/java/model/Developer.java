package model;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "developers")
public class Developer {

//    Properties

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dev_id")
    private int id;

    @Column(name = "dev_name")
    private String name;

    @Column(name = "dev_salary")
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "developer_project",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Collection<Project> projects;

//    Constructors

    //    default constructor
    public Developer() {
    }

    //    constructor with 2 parameters

    public Developer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    //    constructor with all parameters

    public Developer(String name, int salary, Collection<Project> projects) {
        this.name = name;
        this.salary = salary;
        this.projects = projects;
    }

    //  Properties


//  Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }


//  equals(), hashCode(), toString()


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (id != developer.id) return false;
        if (salary != developer.salary) return false;
        if (!name.equals(developer.name)) return false;
        return projects.equals(developer.projects);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + salary;
        result = 31 * result + projects.hashCode();
        return result;
    }

    @Override
    public String toString() {
            String projectsList = "";
            if(projects != null) {
                for (Project project : projects) {
                    projectsList += "   ID проекта: " + project.getId() + "\n" +
                            "   Название проекта: " + project.getName() + "\n";
                }
            }
            return "-----------------------------------------------------------------------------------------------" + "\n" +
                    "Данные разработчика:" + "\n" +
                    "ID: " + id + "\n" +
                    "Имя: " + name + "\n" +
                    "Зарплата: " + salary + "\n" +
                    "Информация о проекте: " + "\n" + projectsList;
    }
}
