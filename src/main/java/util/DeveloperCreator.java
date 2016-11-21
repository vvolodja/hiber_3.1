package util;

import dao.DeveloperDao;
import dao.DeveloperDaoImpl;
import model.Developer;
import model.Project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class DeveloperCreator {

    public DeveloperCreator() throws SQLException {

//        Разработчики

        Developer developer_1 = new Developer("Victor Sokolov", 800);
        Developer developer_2 = new Developer("Petr Romanov", 1000);
        Developer developer_3 = new Developer("Alexey Orlov", 1500);
        Developer developer_4 = new Developer("Oleg Tihonov", 1800);
        Developer developer_5 = new Developer("Ivan Petrov", 2000);

//        Проекты

        Project project_1 = new Project("IBM project");
        Project project_2 = new Project("Oracle project");
        Project project_3 = new Project("Adobe project");



        Collection<Project> projects_1 = new ArrayList<Project>();

        projects_1.add(project_1);
        projects_1.add(project_2);
        projects_1.add(project_3);




    }
}
