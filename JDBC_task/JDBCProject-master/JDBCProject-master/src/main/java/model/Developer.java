package model;


public class Developer {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int salary;
    private int companyID;
    private int projectID;


    public Developer() {
    }

    public Developer(int id, String firstName, String lastName, int age, int salary, int companyID, int projectID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.companyID = companyID;
        this.projectID = projectID;
    }

//Setters for empty default constructor:

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

//Getters for all kinds of constructors:

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public int getCompanyID() {
        return companyID;
    }

    public int getProjectID() {
        return projectID;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", companyID=" + companyID +
                ", projectID=" + projectID +
                "}/n";
    }
}
