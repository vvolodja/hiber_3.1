package dao;

import model.Developer;

import java.sql.SQLException;
import java.util.List;


interface daoDeveloper {

//    Get information:

    Developer getDeveloperById(int id) throws SQLException;

    List<Developer> getDevelopersByProject(int projectID) throws SQLException;

    List<Developer> getAllDevelopersList() throws SQLException;

//    Edit data:

    void addDeveloper(Developer developer) throws SQLException;

    void updateDeveloper(Developer developer) throws SQLException;

    void removeDeveloper(int id) throws SQLException;

}
