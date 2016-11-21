package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect
{
    static Connection connection;

    /*
     * Main method
     */
    public static void main(String[] arg)
    {
        String drv = "com.mysql.jdbc.Driver";     // Адрес драйвера
        String url = "jdbc:mysql://localhost:3306/SQL_task2"; // База данных
        String login = "root";                         // Логин
        String pwd = "7073926";                               // Парольчик
        try
        {
            Class.forName(drv);

            connection = DriverManager.getConnection(url, login, pwd);
            System.out.println("Есть соединение с БД!");

            connection.close();
        }
        catch (ClassNotFoundException ex) //Если найти класс драйвера не удалось
        {
            System.err.println("Нет драйвера.");
            System.err.println(ex);
        }
        catch (SQLException ex)
        {
            System.err.println("Нет соединения.");
            System.err.println(ex);
        }
    }
}