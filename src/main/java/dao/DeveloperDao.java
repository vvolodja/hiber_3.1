package dao;

import model.Developer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vladimir on 17/11/16.
 */
public interface DeveloperDao {

    //    Get information:

    Developer getDeveloperById(int id) throws SQLException;

    List<Developer> getDevelopersByProject(int projectID) throws SQLException;

    List getAllDevelopersList() throws SQLException;

    void showDeveloper(int id);

//    Edit data:

    void addDeveloper(Developer developer) throws SQLException;

    void updateDeveloper(Developer developer) throws SQLException;

    void removeDeveloper(int id) throws SQLException;


}
