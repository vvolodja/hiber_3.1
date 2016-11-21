package controller;

import view.MenuSet;

import java.sql.SQLException;
import java.util.Scanner;


public class MenuController {

    public static MenuSet menuSet = new MenuSet();

    public int userChoice() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

//    default constructor MenuController

    public MenuController() throws SQLException {
    }

//    главное меню

    public void getUserMenu() throws SQLException {

        menuSet.getTitleMenu();
        int choice = userChoice();

        switch (choice) {
            case 1:
                getInfo();
                break;
            case 2:
                editData();
                break;
        }
    }

//      информационное меню

    public void getInfo() throws SQLException {

        menuSet.getBaseInfoMenu();
        int choice = userChoice();

        switch (choice) {
            case 1:
                getDevInfo();
                break;
            case 2:
                getProjInfo();
                break;
        }
    }

//        меню редактирования данных

    public void editData() throws SQLException {

        menuSet.getBaseEditMenu();
        int choice = userChoice();

        switch (choice) {
            case 1:
                editDevelData();
                break;
            case 2:
                editProjData();
                break;
        }
    }

//        доступ к информации о разработчиках

    public void getDevInfo() throws SQLException {

        menuSet.getDeveloperInfoMenu();
        int choice = userChoice();

        switch (choice) {
            case 1:
                menuSet.executeDevById();
                break;
            case 2:
                menuSet.executeListDevByProject();
                break;
            case 3:
                menuSet.executeAllDevList();
                break;
        }
    }

//        доступ к информации о проектах

    public void getProjInfo() throws SQLException {

        menuSet.getProjectInfoMenu();
        int choice = userChoice();

        switch (choice) {
            case 1:
                menuSet.executeProjById();
                break;
            case 2:
                menuSet.executeAllProjList();
                break;
        }
    }

    //        редактирование данных о разработчиках

    public void editDevelData() throws SQLException {

        menuSet.getDeveloperEditMenu();
        int choice = userChoice();

        switch (choice) {
            case 1:
                menuSet.addNewDeveloper();
                break;
            case 2:
                menuSet.editDevData();
                break;
            case 3:
                menuSet.deleteDeveloper();
                break;
        }
    }

//        редактирование данных о проектах

    public void editProjData() throws SQLException {

        menuSet.getProjectEditMenu();
        int choice = userChoice();

        switch (choice) {
            case 1:
                menuSet.addNewProject();
                break;
            case 2:
                menuSet.editProjectData();
                break;
            case 3:
                menuSet.deleteProject();
                break;
        }
    }


}
