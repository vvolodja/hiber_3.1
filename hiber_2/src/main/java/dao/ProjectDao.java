package dao;

import model.Project;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 15.11.2016.
 */

interface ProjectDao {


//    Get information:

    Project getProject(int id) throws SQLException;

    List<Project> getAllProjectsList() throws SQLException;

//    Edit data:

    void addProject (Project project) throws SQLException;

    void updateProject (Project project) throws SQLException;

    void removeProject(int id) throws SQLException;

}
