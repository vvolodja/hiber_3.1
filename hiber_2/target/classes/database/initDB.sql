DROP DATABASE IF EXISTS SQL_task2;

        CREATE DATABASE IF NOT EXISTS SQL_task2 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

        # IT-компании

        CREATE TABLE SQL_task2.Companies(
        comp_id INT AUTO_INCREMENT,
        comp_name VARCHAR(100) NOT NULL,

        PRIMARY KEY (comp_id)

        );

        # Заказчики:

        CREATE TABLE SQL_task2.Customers(
        cust_id INT AUTO_INCREMENT,
        cust_name VARCHAR(100) NOT NULL,

        comp_id INT NOT NULL,

        PRIMARY KEY (cust_id),
        FOREIGN KEY (comp_id) REFERENCES SQL_task2.Companies(comp_id)
        );

        # Проекты:

        CREATE TABLE SQL_task2.Projects(
        proj_id INT AUTO_INCREMENT,
        proj_name VARCHAR(100) NOT NULL,

        comp_id INT NOT NULL,
        cust_id INT NOT NULL,

        PRIMARY KEY (proj_id),
        FOREIGN KEY (comp_id) REFERENCES SQL_task2.Companies(comp_id),
        FOREIGN KEY (cust_id) REFERENCES SQL_task2.Customers(cust_id)
        );

        # Разработчики

        CREATE TABLE SQL_task2.Developers(
        dev_id INT AUTO_INCREMENT,
        dev_firstName VARCHAR(45) NOT NULL,
        dev_lastName VARCHAR(45) NOT NULL,
        dev_age INT NOT NULL,

        proj_id INT NOT NULL,
        comp_id INT NOT NULL ,

        PRIMARY KEY (dev_id),
        FOREIGN KEY (proj_id) REFERENCES SQL_task2.Projects(proj_id),
        FOREIGN KEY (comp_id) REFERENCES SQL_task2.Companies(comp_id)
        );

        # Команды для добавления дополнительных столбцов

        ALTER TABLE SQL_task2.Developers
        ADD COLUMN dev_salary INT NOT NULL;

        ALTER TABLE SQL_task2.Projects
        ADD COLUMN proj_cost INT NOT NULL;

        # Связуюшая таблица для ассоциации ManyToMany между Developer и Project

        CREATE TABLE SQL_task2.developer_project(
        developer_id INT NOT NULL,
        project_id INT NOT NULL,

        PRIMARY KEY (developer_id, project_id),
        FOREIGN KEY (developer_id) REFERENCES SQL_task2.Developers(dev_id),
        FOREIGN KEY (project_id) REFERENCES SQL_task2.Projects(proj_id)

        );

        # Навыки (programming languages):

        CREATE TABLE SQL_task2.Skills(
        skill_id INT AUTO_INCREMENT,
        skill_name VARCHAR(45) NOT NULL,
        #   dev_id INT NOT NULL,

        PRIMARY KEY (skill_id)
        #   FOREIGN KEY (dev_id) REFERENCES SQL_task2.Developers(dev_id)
        );

        CREATE TABLE SQL_task2.Developer_Skills(
        dev_id INT NOT NULL,
        skill_id INT NOT NULL,

        PRIMARY KEY (dev_id, skill_id),
        FOREIGN KEY (dev_id) REFERENCES SQL_task2.Developers(dev_id),
        FOREIGN KEY (skill_id) REFERENCES SQL_task2.Skills(skill_id)
        );
