package util;

import model.Project;

import java.sql.SQLException;


public class ProjectCreator {

    public ProjectCreator() throws SQLException {

        Project project_1 = new Project("IBM project");
        Project project_2 = new Project("Oracle project");
        Project project_3 = new Project("Adobe project");


    }
}
