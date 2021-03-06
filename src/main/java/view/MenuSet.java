package view;

import controller.MenuController;
import dao.DeveloperDaoImpl;
import dao.ProjectDaoImpl;
import model.Developer;
import model.Project;

import java.sql.SQLException;
import java.util.*;

public class MenuSet {

    public static DeveloperDaoImpl daoDev = new DeveloperDaoImpl();
    public static ProjectDaoImpl daoProj = new ProjectDaoImpl();
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
//        daoDev.showAllDevelopers();
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

    public void addNewDeveloper() throws SQLException {

        //имя
        System.out.println("Введите Name разработчика");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        developer.setName(name);

        //зарплата
        System.out.println("Введите Salary разработчика");
        in = new Scanner(System.in);
        int salary = in.nextInt();
        developer.setSalary(salary);

        //закрепление разработчика за проектом по project ID
        System.out.println("Введите ID проекта, за которым закрепляется разработчик");
        in = new Scanner(System.in);
        int projectID = in.nextInt();
        Project project = daoProj.getProject(projectID);
        developer.getProjects().add(project);

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

        System.out.println("Введите окончательный вариант Name разработчика");
        in = new Scanner(System.in);
        String name = in.nextLine();
        editDeveloper.setName(name);

        System.out.println("Введите окончательный вариант Salary разработчика");
        in = new Scanner(System.in);
        int salary = in.nextInt();
        editDeveloper.setSalary(salary);

        System.out.println("Введите ID проекта, за которым следует закрепить данного разработчика");
        in = new Scanner(System.in);
        int projectID = in.nextInt();
        Project project = daoProj.getProject(projectID);
        editDeveloper.getProjects().add(project);

        System.out.println("Введите ID проекта, с которого следует снять данного разработчика");
        in = new Scanner(System.in);
        projectID = in.nextInt();
        project = daoProj.getProject(projectID);
        editDeveloper.getProjects().remove(project);

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

//        in = new Scanner(System.in);
        System.out.println("Введите количество разработчиков, закрепляемых за данным проектом");
        int dev_count = in.nextInt();        //число разработчиков
        int[] team = new int[dev_count];     //создаем массив размером с количество закрепленных разработчиков
        int i = 0;                          //счетчик для перебора элементов массива

        for (int element : team) {          //перебираем вводимые с клавиатуры элементы массива

            System.out.println("Введите ID " + (i + 1) + "-го разработчика");
            team[i] = in.nextInt();         //id очередного разработчика из команды

            developer = daoDev.getDeveloperById(team[i]);
            project.getProjectTeam().add(developer);     //добавляем разработчика в коллекцию проекта

            i++;                            //переходим к следующему разработчику
        }


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
        int projId = in.nextInt();

        Project editProject = daoProj.getProject(projId);

        System.out.println("Введите окончательный вариант Name проекта");
        in = new Scanner(System.in);
        String name = in.nextLine();
        editProject.setName(name);

        System.out.println("Введите новое количество разработчиков в команде данного проекта");
        int dev_count = in.nextInt();
        int[] team = new int[dev_count];     //создаем массив размером с количество закрепленных разработчиков
        editProject.getProjectTeam().clear();    //обнуляем список проектной команды
        int i = 0;                          //счетчик для перебора элементов массива

        for (int element : team) {          //перебираем вводимые с клавиатуры элементы массива

            System.out.println("Укажите значение ID для " + (i + 1) + "-го разработчика");
            team[i] = in.nextInt();         //новый id очередного разработчика из комманды

            developer = daoDev.getDeveloperById(team[i]);
            editProject.getProjectTeam().add(developer);     //добавляем разработчика в коллекцию проекта

            i++;                            //переходим к следующему разработчику
        }

        System.out.println(
                "Для подтверждения своего запроса, введите 1\n" +
                        "Для отмены текущей операции и возврата в предыдущее меню, введите 0");
        in = new Scanner(System.in);
        int confirm_code = in.nextInt();
        switch (confirm_code) {
            case 1:
                int id = editProject.getId();
                daoProj.updateProject(editProject);
                System.out.println("Данные о проекте с ID " + id + " успешно обновлены)");
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