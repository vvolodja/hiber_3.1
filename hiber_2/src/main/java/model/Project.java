package model;


import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "proj_name")
    private String name;

    @Column(name = "proj_cost")
    private int cost;

    @Column(name = "comp_id")
    private int companyId;

    @Column(name = "cust_id")
    private int customerId;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "projects")
    private Collection<Developer> developers;

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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Collection<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Collection<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (getId() != project.getId()) return false;
        if (getCost() != project.getCost()) return false;
        if (getCompanyId() != project.getCompanyId()) return false;
        if (getCustomerId() != project.getCustomerId()) return false;
        if (!getName().equals(project.getName())) return false;
        return getProjectTeam().equals(project.getProjectTeam());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCost();
        result = 31 * result + getCompanyId();
        result = 31 * result + getCustomerId();
        result = 31 * result + getProjectTeam().hashCode();
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
                ", developers=" + developers +
                '}';
    }
}
