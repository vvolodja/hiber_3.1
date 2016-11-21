# # 3 IT-компании-работодателя

INSERT INTO SQL_task2.Companies
(comp_name)
  VALUE
  ('Luxoft'),
  ('EPAM'),
  ('Ciklum');

# 6 компаний-заказчиков, распределенных по базовым компаниям

INSERT INTO SQL_task2.Customers(cust_name, comp_id)
  VALUE
  ('IBM', 1),
  ('Dell', 1),
  ('Apple', 2),
  ('Microsoft', 2),
  ('Google', 3),
  ('Amazon', 3);

# 6 проектов в разработке (рабочее название, заказчик, стоимость)

INSERT INTO SQL_task2.Projects
(proj_name, comp_id, cust_id, proj_cost)
  VALUE
  ('epam_1', 1, 1, 80000),
  ('epam_2', 1, 2, 75000),
  ('luxoft_1', 2, 3, 90000),
  ('luxoft_2', 2, 4, 70000),
  ('ciklum_1', 3, 5, 85000),
  ('ciklum_2', 3, 6, 65000);

# 18 программистов, закрепленных за проектами

INSERT INTO SQL_task2.Developers(dev_firstName, dev_lastName, dev_age, proj_id, comp_id, dev_salary)
  VALUE
  ('Frank', 'Sinatra', 45, 1, 1, 3500),
  ('Tom', 'Hanks', 42, 2, 1, 3400),
  ('Kevin', 'Costner', 39, 3, 2, 3300),
  ('Mel', 'Gibson', 40, 4, 2, 3300),
  ('Jack', 'Richer', 38, 5, 3, 3200),
  ('Frank', 'Ocean', 36, 6, 3, 3000),
  ('Billie', 'Kid', 32, 6, 3, 2500),
  ('Andy', 'Garcia', 33, 5, 3, 2500),
  ('Clint', 'Eastwood', 28, 4, 2, 2300),
  ('Bruce', 'Willis', 31, 3, 2, 2200),
  ('John', 'Lennon', 29, 2, 1, 2000),
  ('Din', 'Read', 30, 1, 1, 1800),
  ('Max', 'Wagner', 30, 3, 2, 2700),
  ('Jack', 'Nicholson', 32, 2, 1, 2600),
  ('Boris', 'Becker', 28, 1, 1, 800),
  ('Phil', 'Collins', 26, 6, 3, 700),
  ('Tom', 'Johns', 25, 5, 3, 500),
  ('Chris', 'Rea', 27, 4, 2, 400);

# языки программирования, применяемые на проекте

INSERT INTO SQL_task2.Skills(skill_name)
  VALUE
  ('Java'),
  ('Scala'),
  ('SQL'),
  ('JS_HTML_CSS');

# таблица связи "many-to-many" между программистами и профессиональными навыками

INSERT INTO SQL_task2.Developer_Skills(dev_id, skill_id)
  VALUE
  (1, 1),
  (1, 2),
  (1, 3),
  (1, 4),
  (2, 1),
  (2, 2),
  (2, 3),
  (2, 4),
  (3, 1),
  (3, 2),
  (3, 3),
  (3, 4),
  (4, 1),
  (4, 2),
  (4, 3),
  (4, 4),
  (5, 1),
  (5, 2),
  (5, 3),
  (5, 4),
  (6, 1),
  (6, 2),
  (6, 3),
  (6, 4),
  (7, 1),
  #   (7, 2),
  (7, 3),
  (7, 4),
  (8, 1),
  #   (8, 2),
  (8, 3),
  (8, 4),
  (9, 1),
  #   (9, 2),
  (9, 3),
  (9, 4),
  (10, 1),
  #   (10, 2),
  (10, 3),
  (10, 4),
  (11, 1),
  #   (11, 2),
  (11, 3),
  (11, 4),
  (12, 1),
  #   (12, 2),
  (12, 3),
  (12, 4),
  #   (13, 1),
  (13, 2),
  (13, 3),
  #   (13, 4),
  #   (14, 1),
  (14, 2),
  (14, 3),
  #   (14, 4),
  #   (15, 1),
  #   (15, 2),
  (15, 3),
  (15, 4),
  #   (16, 1),
  #   (16, 2),
  (16, 3),
  (16, 4),
  #   (17, 1),
  #   (17, 2),
  #   (17, 3),
  (17, 4),
  #   (18, 1),
  #   (18, 2),
  #   (18, 3),
  (18, 4);