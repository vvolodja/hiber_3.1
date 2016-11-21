package model;

import java.util.List;

/**
 * Created by vv on 03.10.16.
 */

public class Project {

    private int id;
    private String name;
    private int cost;
    private int companyId;
    private int customerId;

    private List<Developer> developersList;

    public Project() {
    }

    public Project(int id, String name, int cost, int companyId, int customerId, List<Developer> developersList) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.companyId = companyId;
        this.customerId = customerId;
        this.developersList = developersList;
    }

    //Setters for empty default constructor:

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setDevelopersList(List<Developer> developersList) {
        this.developersList = developersList;
    }


//Getters for all kinds of constructors:


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getCompanyId() {
        return companyId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Developer> getDevelopersList() {
        return developersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (cost != project.cost) return false;
        if (companyId != project.companyId) return false;
        if (customerId != project.customerId) return false;
        if (!name.equals(project.name)) return false;
        return developersList != null ? developersList.equals(project.developersList) : project.developersList == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + cost;
        result = 31 * result + companyId;
        result = 31 * result + customerId;
        result = 31 * result + (developersList != null ? developersList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", companyId=" + companyId +
                ", customerId=" + customerId +
                '}';
    }

//    @Override
//    public String toString(List<Developer> list) {
//        final StringBuilder sb = new StringBuilder("Project{");
//        sb.append("developersList=").append(developersList);
//        sb.append('}');
//        return sb.toString();
//    }
//
//    public static java.lang.String join(java.util.Collection collection,
//                                        char separator)
}