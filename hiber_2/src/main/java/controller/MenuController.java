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

//    ����������� MenuController

    public MenuController() throws SQLException {
    }

//    ������� ����

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

//        ���� ����������

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

//        ���� ��������������

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

//        ���������� � �������������

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

//        ���������� � ��������

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

    //        �������������� ������ � �������������

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

//        �������������� ������ � ��������

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
