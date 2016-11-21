package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class ConnectionManager {


    private static final ConnectionManager connectionManager = new ConnectionManager();
    private static Connection connection;

//    JDBC driver name and database URL:

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SQL_task2";

//    Database credentials:

    private static final String USER = "root";
    private static final String PASS = "7073926";

//    ConnectionManager Constructor

    private ConnectionManager() {
        try {
            Class.forName(JDBC_DRIVER);
        }
        catch(ClassNotFoundException e )
        {
            e.printStackTrace();
        }
    }

    static ConnectionManager getInstance() {

        return connectionManager;
    }

//        Getting Connection

    Connection getConnection() throws SQLException, ClassNotFoundException{

        try {
            if (connection == null) {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}