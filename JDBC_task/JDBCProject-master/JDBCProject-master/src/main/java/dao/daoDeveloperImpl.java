package dao;

import model.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//реализация DAO-методов через JDBC

public class daoDeveloperImpl implements daoDeveloper {

    private ConnectionManager connectionManager = ConnectionManager.getInstance();
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public void addDeveloper(Developer developer) throws SQLException {

        String addDeveloperSQL = "INSERT INTO Developers" +
                "(dev_firstName, dev_lastName, dev_age, dev_salary, comp_id, proj_id)" +
                "VALUES" +
                "(?, ?, ?, ?, ?, ?)";
        try {
            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(addDeveloperSQL);

            preparedStatement.setString(1, developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());
            preparedStatement.setInt(3, developer.getAge());
            preparedStatement.setInt(4, developer.getSalary());
            preparedStatement.setInt(5, developer.getCompanyID());
            preparedStatement.setInt(6, developer.getProjectID());

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

    public void updateDeveloper(Developer developer) throws SQLException{

        String updateDeveloperSQL = "UPDATE Developers " +
                "SET " +
                "dev_firstName = ?," +
                "dev_lastName = ?," +
                "dev_age = ?," +
                "dev_salary = ?," +
                "comp_id = ?," +
                "proj_id = ?" +
                "WHERE " +
                "dev_id = ?";
        try {
            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(updateDeveloperSQL);

            preparedStatement.setString(1, developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());
            preparedStatement.setInt(3, developer.getAge());
            preparedStatement.setInt(4, developer.getSalary());
            preparedStatement.setInt(5, developer.getCompanyID());
            preparedStatement.setInt(6, developer.getProjectID());
            preparedStatement.setInt(7, developer.getId());

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

    public void removeDeveloper(int id) throws SQLException{

        String removeDeveloperSQL = " DELETE * FROM Developers " +
                "WHERE " +
                "dev_id = ?";
        try {
            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(removeDeveloperSQL);
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

    public Developer getDeveloperById(int id) throws SQLException{

        String getDeveloperByIdSQL = "SELECT * FROM Developers " +
                "WHERE " +
                "dev_id = ?";
        Developer developer = null;

        try {

            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(getDeveloperByIdSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(getDeveloperByIdSQL);

//      variant # 1 for empty Developer constructor
            while (resultSet.next()) {
                developer = new Developer();
                developer.setId(resultSet.getInt("dev_id"));
                developer.setFirstName(resultSet.getString("dev_firstName"));
                developer.setLastName(resultSet.getString("dev_lastName"));
                developer.setAge(resultSet.getInt("dev_age"));
                developer.setSalary(resultSet.getInt("dev_salary"));
                developer.setCompanyID(resultSet.getInt("comp_id"));
                developer.setProjectID(resultSet.getInt("proj_id"));
            }
            resultSet.close();
//      variant # 2 for Developer constructor with parameters
//            while (resultSet.next()){
//                developer = new Developer(
//                        resultSet.getInt("dev_id"),
//                        resultSet.getString("firstName"),
//                        resultSet.getString("firstName"),
//                        resultSet.getInt("dev_age"),
//                        resultSet.getInt("dev_salary"),
//                        resultSet.getInt("comp_id"),
//                        resultSet.getInt("proj_id")
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
        return developer;
    }

//    список разработчиков, задействованых на конкретном проекте
    public List<Developer> getDevelopersByProject(int id) throws SQLException{

        List<Developer> allDevelopersOnProject = new ArrayList<Developer>();

        String getDevelopersByProjectSQL = "SELECT * FROM Developers " +
                "WHERE " +
                "proj_id = ?";
        try {
            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(getDevelopersByProjectSQL);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Developer developer = new Developer();
                developer.setId(resultSet.getInt("dev_id"));
                developer.setFirstName(resultSet.getString("dev_firstName"));
                developer.setLastName(resultSet.getString("dev_lastName"));
                developer.setAge(resultSet.getInt("dev_age"));
                developer.setSalary(resultSet.getInt("dev_salary"));
                developer.setCompanyID(resultSet.getInt("comp_id"));
                developer.setProjectID(resultSet.getInt("proj_id"));

                allDevelopersOnProject.add(developer);
            }
            resultSet.close();

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

        return allDevelopersOnProject;
    }

//    список всех разработчиков
    public List<Developer> getAllDevelopersList() throws SQLException{

        List<Developer> allDevelopersList = new ArrayList<Developer>();
        String getAllDevelopersListSQL = "SELECT * FROM Developers";

        try {
            connection = connectionManager.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllDevelopersListSQL);

            while (resultSet.next()){
                Developer developer = new Developer();
                developer.setId(resultSet.getInt("dev_id"));
                developer.setFirstName(resultSet.getString("dev_firstName"));
                developer.setFirstName(resultSet.getString("dev_lastName"));
                developer.setAge(resultSet.getInt("dev_age"));
                developer.setAge(resultSet.getInt("dev_salary"));
                developer.setAge(resultSet.getInt("comp_id"));
                developer.setAge(resultSet.getInt("proj_id"));

                allDevelopersList.add(developer);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null){
                connection.close();
            }
        }
        return allDevelopersList;
    }
}