# Смена последовательности столбцов
# ALTER TABLE `table_name` MODIFY `column_name` column_definition AFTER column_before;

# просмотр column_definition:
SHOW CREATE TABLE Developers;

# команды на перестановку столбцов
ALTER TABLE Developers MODIFY dev_salary INT(11) NOT NULL AFTER dev_age;

ALTER TABLE Developers MODIFY comp_id INT(11) NOT NULL AFTER dev_salary;

ALTER TABLE Projects MODIFY proj_cost INT(11) NOT NULL AFTER proj_name;

