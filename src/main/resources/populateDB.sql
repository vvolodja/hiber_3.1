
INSERT INTO hiber_3.projects(proj_name)
  VALUE
  ('epam_project'),
  ('luxoft_project'),
  ('ciklum_project');


INSERT INTO hiber_3.developers(dev_name, dev_salary)
  VALUE
  ('Frank', 2500),
  ('Tom', 3000),
  ('Kevin', 3300),
  ('Max', 2000),
  ('Alex', 2800),
  ('Leo', 3500);

# "many-to-many"

INSERT INTO hiber_3.developer_project(developer_id, project_id)
    VALUE
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 1),
  (5, 2),
  (6, 3);