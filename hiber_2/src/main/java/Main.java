import controller.MenuController;

import java.sql.SQLException;

/**
 * Created by Администратор on 15.11.2016.
 */

class Main {

    public static void main(String[] args) throws SQLException {

        MenuController menuController = new MenuController();

        try {
            menuController.getUserMenu();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
