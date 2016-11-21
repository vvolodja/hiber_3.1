import controller.MenuController;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {

        MenuController menuController = new MenuController();

        try {
            menuController.getUserMenu();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
