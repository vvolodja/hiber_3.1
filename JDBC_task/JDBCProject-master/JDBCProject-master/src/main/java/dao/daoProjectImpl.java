package dao;

import model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoProjectImpl implements daoProject {

    private ConnectionManager connectionManager = ConnectionManager.getInstance();
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public void addProject(Project project) throws SQLException {

        String addProjectSQL = "INSERT INTO Projects " +
                "(proj_id, proj_name, proj_cost, comp_id, cust_id) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(addProjectSQL);

            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setInt(3, project.getCost());
            preparedStatement.setInt(4, project.getCompanyId());
            preparedStatement.setInt(5, project.getCustomerId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    public Project getProject(int id) throws SQLException {

        Project project = null;
        String getProjectSQL = "SELECT * FROM Projects WHERE proj_id = ?";

        try {
            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(getProjectSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(getProjectSQL);

//      variant # 1 for empty Project constructor
            while (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getInt("proj_id"));
                project.setName(resultSet.getString("proj_name"));
                project.setCost(resultSet.getInt("proj_cost"));
                project.setCompanyId(resultSet.getInt("comp_id"));
                project.setCustomerId(resultSet.getInt("cust_id"));
            }
            resultSet.close();

//      variant # 2 for Project constructor with parameters
//            while (resultSet.next()){
//                project = new Project(
//                        resultSet.getInt("proj_id"),
//                        resultSet.getString("proj_name"),
//                        resultSet.getInt("proj_cost"),
//                        resultSet.getInt("comp_id"),
//                        resultSet.getInt("cust_id"),
//                );
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return project;
    }

    public List<Project> getAllProjectsList( ) throws SQLException {

        List<Project> allProjectList = new ArrayList<Project>();
        String getAllProjectsList = "SELECT * FROM Projects";

        try {
            connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllProjectsList);

            while (resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("proj_id"));
                project.setName(resultSet.getString("proj_name"));
                project.setCost(resultSet.getInt("proj_cost"));
                project.setCompanyId(resultSet.getInt("comp_id"));
                project.setCustomerId(resultSet.getInt("cust_id"));

                allProjectList.add(project);
            }
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null){
                connection.close();
            }
        }
        return allProjectList;
    }

    public void updateProject(Project project) throws SQLException {

        String updateProjectSQL = "UPDATE Projects " +
                "SET " +
                "proj_name = ?," +
                "proj_cost = ?," +
                "comp_id = ?," +
                "cust_id = ? " +
                "WHERE " +
                "proj_id = ?";
        try {
            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(updateProjectSQL);

            preparedStatement.setString(1, project.getName());
            preparedStatement.setInt(2, project.getCost());
            preparedStatement.setInt(3, project.getCompanyId());
            preparedStatement.setInt(4, project.getCustomerId());
            preparedStatement.setInt(5, project.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    public void removeProject(int id) throws SQLException {

        String removeProjectSQL = "DELETE FROM Projects " +
                "WHERE " +
                "proj_id = ?";
        try {
            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(removeProjectSQL);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }
}
