package dao;

import model.Project;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vladimir on 17/11/16.
 */
public interface ProjectDao {


//    Get information:

    Project getProject(int id) throws SQLException;

    List<Project> getAllProjectsList() throws SQLException;

//    Edit data:

    void addProject(Project project) throws SQLException;

    void updateProject(Project project) throws SQLException;

    void removeProject(int id) throws SQLException;

}
