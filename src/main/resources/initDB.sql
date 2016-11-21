DROP DATABASE IF EXISTS hiber_3;

        CREATE DATABASE IF NOT EXISTS hiber_3 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


        # Проекты:

        CREATE TABLE hiber_3.projects(
        proj_id INT AUTO_INCREMENT,
        proj_name VARCHAR(100) NOT NULL,

        PRIMARY KEY (proj_id)
        );

        # Разработчики

        CREATE TABLE hiber_3.developers(
        dev_id INT AUTO_INCREMENT,
        dev_name VARCHAR(45) NOT NULL,
        dev_salary INT NOT NULL,

        PRIMARY KEY (dev_id)
        );


        # Связуюшая таблица для ассоциации ManyToMany между Developer и Project

        CREATE TABLE hiber_3.developer_project(
        developer_id INT NOT NULL,
        project_id INT NOT NULL,

        PRIMARY KEY (developer_id, project_id),
        FOREIGN KEY (developer_id) REFERENCES hiber_3.developers(dev_id),
        FOREIGN KEY (project_id) REFERENCES hiber_3.projects(proj_id)
        );

