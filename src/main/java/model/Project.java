package model;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "projects")
public class Project {

//    Properties

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "proj_name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "projects")
    private Collection<Developer> projectTeam;

//    Constructors

    //    default constructor

    public Project() {
    }

    //    constructor with 1 parameter

    public Project(String name) {
        this.name = name;
    }

    //    constructor with all parameters

    public Project(String name, Collection<Developer> projectTeam) {
        this.name = name;
        this.projectTeam = projectTeam;
    }


//Getter & Setter

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

    public Collection<Developer> getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(Collection<Developer> developers) {
        this.projectTeam = developers;
    }


    //  equals(), hashCode(), toString()


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (!name.equals(project.name)) return false;
        return projectTeam.equals(project.projectTeam);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + projectTeam.hashCode();
        return result;
    }

//    version 1

//    @Override
//    public String toString() {
//
//            String developersOnProject = "";
//            if(projectTeam != null) {
//                for (Developer teamMember : projectTeam) {
//                    developersOnProject += "    ID разработчика: " + teamMember.getId() + "\n" +
//                    "   Имя разработчика: " + teamMember.getName() + "\n" +
//                    "   Зарплата разработчика: " +  teamMember.getSalary() + "\n";
//                }
//            }
//            return  "-----------------------------------------------------------------------------------------------" + "\n" +
//                    "Информация о проекте: " + "\n" +
//                    "ID проекта: " + id + "; " + "\n" +
//                    "Название проекта: " + name + "\n" +
//                    "Проектная команда: " + "\n" + developersOnProject;
//    }


//    version 2

    @Override
    public String toString() {

            return  "-----------------------------------------------------------------------------------------------" + "\n" +
                    "Информация о проекте: " + "\n" +
                    "ID проекта: " + id + "; " + "\n" +
                    "Название проекта: " + name + "\n" +
                    "Проектная команда: " + "\n" + developersListToString(projectTeam);
    }

    public String developersListToString(Collection<Developer> developers) {

        String developersList = "";
            for (Developer teamMember : developers) {
                developersList += "    ID разработчика: " + teamMember.getId() + "\n" +
                        "   Имя разработчика: " + teamMember.getName() + "\n" +
                        "   Зарплата разработчика: " +  teamMember.getSalary() + "\n";
            }
        return developersList;
    }
}
