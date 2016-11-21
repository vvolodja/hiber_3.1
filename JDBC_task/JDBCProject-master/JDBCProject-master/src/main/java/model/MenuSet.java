package model;


import dao.daoDeveloperImpl;
import dao.daoProjectImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSet {

    public static daoDeveloperImpl daoDev = new daoDeveloperImpl();
    public static daoProjectImpl daoProj = new daoProjectImpl();
    public static Developer developer = new Developer();
    public static Project project = new Project();

//  1.Стартовое меню

    public void getTitleMenu() {

        System.out.println("Введите число, соответствующее выбранной вами операции.\n");

        System.out.println(
                "1 -- Ваша цель - получить информацию\n" +
                        "2 -- Ваша цель - изменить данные\n");
        System.out.println("Сделайте выбор:");
    }

//      2.1 Меню получения информации

    public void getBaseInfoMenu() {
//        System.out.println("Введите число, соответствующее выбранной вами операции.\n");

        System.out.println(
                "1 -- Информация о разработчиках\n" +
                        "2 -- Информация о проектах\n");

        System.out.println("Сделайте выбор:");
    }

//              2.1.1 Меню получения информации по разработчикам

    public void getDeveloperInfoMenu() {
//        System.out.println("Введите число, соответствующее выбранной вами операции.\n");

        System.out.println(
                "1 -- Получить информацию о конкретном разработчике\n" +
                "2 -- Сформировать список разработчиков, задействованных в конкретном проекте\n" +
                        "3 -- Сформировать список всех разработчиков\n");

        System.out.println("Сделайте выбор:");
    }

//                      *** Методы меню 2.1.1

    public String executeDevById() throws SQLException {

        System.out.println("Введите ID разработчика:");

        Scanner in = new Scanner(System.in);
        int id = in.nextInt();

        developer = daoDev.getDeveloperById(id);
        return developer.toString();

//        ну, или :)
//        return daoDev.getDeveloperById(in.nextInt()).toString();
    }

    public String executeListDevByProject() throws SQLException {

        System.out.println("Введите ID проекта:");

        Scanner in = new Scanner(System.in);
        int id = in.nextInt();

        List<Developer> list;
        list = daoDev.getDevelopersByProject(id);
        return list.toString();
    }

    public String executeAllDevList() throws SQLException {

        List<Developer> list;
        list = daoDev.getAllDevelopersList();
        return list.toString();
    }

//              2.1.2 Меню получения информации по проектам

    public void getProjectInfoMenu() {

//        System.out.println("Введите число, соответствующее выбранной вами операции.\n");
        System.out.println(
                "1 -- Получить информацию о конкретном проекте\n" +
                        "2 -- Сформировать список всех проектов\n");

        System.out.println("Сделайте выбор:");

    }

//                      *** Методы меню 2.1.2

    public String executeProjById() throws SQLException {

        System.out.println("Введите ID проекта:");

        Scanner in = new Scanner(System.in);
        int id = in.nextInt();

        project = daoProj.getProject(id);
        return project.toString();

    }

    public String executeAllProjList() throws SQLException {

        List<Project> list;
        list = daoProj.getAllProjectsList();
        return list.toString();
    }

//      2.2 Меню редактирования данных

    public void getBaseEditMenu() {
        System.out.println("Введите число, соответствующее выбранной вами операции.\n");

        System.out.println(
                "1 -- Редактировать данные разработчиках\n" +
                        "2 -- Редактировать данные о проектах\n");

        System.out.println("Сделайте выбор:");
    }

//              2.2.1 Меню редактирования данных разработчиков

    public void getDeveloperEditMenu() {

        System.out.println("Введите число, соответствующее выбранной вами операции.\n");

        System.out.println(
                "1 -- Добавить данные о новом разработчике\n" +
                        "2 -- Изменить данные разработчика\n " +
                        "3 -- Удалить все данные о разработчике\n");

        System.out.println("Сделайте выбор:");
    }

//                      *** Методы меню 2.2.1

    public void addNewDeveloper() throws SQLException{

        //имя
        System.out.println("Введите First Name разработчика");
        Scanner in = new Scanner(System.in);
        String firstName = in.nextLine();
        developer.setFirstName(firstName);

        //фамилия
        System.out.println("Введите Last Name разработчика");
        in = new Scanner(System.in);
        String lastName = in.nextLine();
        developer.setLastName(lastName);

        //возраст
        System.out.println("Введите Age разработчика");
        in = new Scanner(System.in);
        int age = in.nextInt();
        developer.setAge(age);

        //зарплата
        System.out.println("Введите Salary разработчика");
        in = new Scanner(System.in);
        int salary = in.nextInt();
        developer.setSalary(salary);

        //ID компании
        System.out.println("Введите Company ID разработчика");
        in = new Scanner(System.in);
        int companyID = in.nextInt();
        developer.setCompanyID(companyID);

        //ID проекта
        System.out.println("Введите Project ID разработчика");
        in = new Scanner(System.in);
        int projectID = in.nextInt();
        developer.setProjectID(projectID);

        System.out.println(
                "Для подтверждения своего запроса, введите 1\n" +
                        "Для отмены текущей операции и возврата в предыдущее меню, введите 0");
        in = new Scanner(System.in);
        int confirm_code = in.nextInt();
        switch (confirm_code) {
            case 1:
                daoDev.addDeveloper(developer);
                System.out.println("Данные о новом разработчике успешно добавлены");
                break;
            case 0:
                getDeveloperEditMenu();
                new MenuController();
                break;
        }
    }

    public void editDevData() throws SQLException {

        System.out.println("Введите ID разработчика, данные которого следует изменить");

        Scanner in = new Scanner(System.in);
        int devID = in.nextInt();

        Developer editDeveloper = daoDev.getDeveloperById(devID);

        System.out.println("Введите окончательный вариант FirstName разработчика");
        in = new Scanner(System.in);
        String firstName = in.nextLine();
        editDeveloper.setFirstName(firstName);

        System.out.println("Введите окончательный вариант LastName разработчика");
        in = new Scanner(System.in);
        String lastName = in.nextLine();
        editDeveloper.setLastName(lastName);

        System.out.println("Введите окончательный вариант Age разработчика");
        in = new Scanner(System.in);
        int age = in.nextInt();
        editDeveloper.setAge(age);

        System.out.println("Введите окончательный вариант Salary разработчика");
        in = new Scanner(System.in);
        int salary = in.nextInt();
        editDeveloper.setSalary(salary);

        System.out.println("Введите окончательный вариант Company ID для данного разработчика");
        in = new Scanner(System.in);
        int companyID = in.nextInt();
        editDeveloper.setCompanyID(companyID);

        System.out.println("Введите окончательный вариант Project ID для данного разработчика");
        in = new Scanner(System.in);
        int projectID = in.nextInt();
        editDeveloper.setProjectID(projectID);

        System.out.println(
                "Для подтверждения своего запроса, введите 1\n" +
                        "Для отмены текущей операции и возврата в предыдущее меню, введите 0");
        in = new Scanner(System.in);
        int confirm_code = in.nextInt();
        switch (confirm_code) {
            case 1:
                daoDev.updateDeveloper(editDeveloper);
                System.out.println("Все сделано :)");
                break;
            case 0:
                getDeveloperEditMenu();
                new MenuController();
                break;
        }
    }

    public void deleteDeveloper() throws SQLException {

        System.out.println("Введите ID разработчика, данные которого следует удалить");

        Scanner in = new Scanner(System.in);
        int developerId = in.nextInt();

        System.out.println(
                "Для подтверждения своего запроса, введите 1\n" +
                        "Для отмены текущей операции и возврата в предыдущее меню, введите 0");
        in = new Scanner(System.in);
        int confirm_code = in.nextInt();
        switch (confirm_code) {
            case 1:
                daoDev.removeDeveloper(developerId);
                System.out.println("Разработчик с ID " + developerId + " удалён из DB");
                break;
            case 0:
                getDeveloperEditMenu();
                new MenuController();
                break;
        }
    }

//              2.2.2 Меню редактирования данных о проектах

    public void getProjectEditMenu() {

        System.out.println("Введите число, соответствующее выбранной вами операции.\n");

        System.out.println(
                "1 -- Добавить данные о новом проекте\n" +
                        "2 -- Изменить данные по проекту \n" +
                        "3 -- Удалить данные по проекту\n");

        System.out.println("Сделайте выбор:");
    }

//                      *** Методы меню 2.2.2

    public void addNewProject() throws SQLException {

        System.out.println("Введите Name проекта");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        project.setName(name);

        System.out.println("Введите Cost проекта");
        in = new Scanner(System.in);
        int cost = in.nextInt();
        project.setCost(cost);

        System.out.println("Введите Company ID для данного проекта");
        in = new Scanner(System.in);
        int companyID = in.nextInt();
        project.setCompanyId(companyID);

        System.out.println("Введите Customer ID для данного проекта");
        in = new Scanner(System.in);
        int customerID = in.nextInt();
        project.setCustomerId(customerID);

        System.out.println(
                "Для подтверждения своего запроса, введите 1\n" +
                        "Для отмены текущей операции и возврата в предыдущее меню, введите 0");
        in = new Scanner(System.in);
        int confirm_code = in.nextInt();
        switch (confirm_code) {
            case 1:
                daoProj.addProject(project);
                System.out.println("Данные о новом проекте успешно добавлены");
                break;
            case 0:
                getProjectEditMenu();
                new MenuController();
                break;
        }
    }

    public void editProjectData() throws SQLException {

        System.out.println("Введите ID проекта, данные о котором следует изменить");

        Scanner in = new Scanner(System.in);
        int projID = in.nextInt();

        Project editProject = daoProj.getProject(projID);

        System.out.println("Введите окончательный вариант Name проекта");
        in = new Scanner(System.in);
        String name = in.nextLine();
        editProject.setName(name);

        System.out.println("Введите окончательный вариант Cost проекта");
        in = new Scanner(System.in);
        int cost = in.nextInt();
        editProject.setCost(cost);

        System.out.println("Введите окончательный вариант Company ID для данного проекта");
        in = new Scanner(System.in);
        int companyID = in.nextInt();
        editProject.setCompanyId(companyID);

        System.out.println("Введите окончательный вариант Customer ID для данного проекта");
        in = new Scanner(System.in);
        int customerID = in.nextInt();
        editProject.setCustomerId(customerID);

        System.out.println(
                        "Для подтверждения своего запроса, введите 1\n" +
                        "Для отмены текущей операции и возврата в предыдущее меню, введите 0");
        in = new Scanner(System.in);
        int confirm_code = in.nextInt();
        switch (confirm_code) {
            case 1:
                int id = editProject.getId();
                daoProj.updateProject(editProject);
                System.out.println("Данные о проекте с ID "+ id +" успешно обновлены)");
                break;
            case 0:
                getProjectEditMenu();
                new MenuController();
                break;
        }
    }

    public void deleteProject() throws SQLException {

        System.out.println("Введите ID проекта, данные о котором следует удалить");

        Scanner in = new Scanner(System.in);
        int projectId = in.nextInt();

        System.out.println(
                "Для подтверждения своего запроса, введите 1\n" +
                        "Для отмены текущей операции и возврата в предыдущее меню, введите 0");

        in = new Scanner(System.in);
        int confirm_code = in.nextInt();

        switch (confirm_code) {
            case 1:
                daoProj.removeProject(projectId);
                System.out.println("Проект с ID " + projectId + " удалён из DB");
                break;
            case 0:
                getProjectEditMenu();
                new MenuController();
                break;
        }
    }
}

