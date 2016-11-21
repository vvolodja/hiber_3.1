package dao;

import model.Project;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HibernateUtil;
import view.ConsoleHelper;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


public class ProjectDaoImpl {

    private static Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    Project project;

    public void addProject(Project project) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(project);
        session.getTransaction().commit();
        logger.info("Add Developer: " + project.getName());
        session.close();
    }

    public Project getProject(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        project = session.get(Project.class, id);
        session.getTransaction().commit();
        session.close();
        return project;
    }

//    without returning any object

    public void showProject(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        project = session.get(Project.class, id);
        ConsoleHelper.writeMessage(project.toString());
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Project> getAllProjectsList() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "select * from projects";
        List<Project> allProjectList = session.createNativeQuery(sql).list();
        session.getTransaction().commit();
        session.close();
        return allProjectList;
    }

    //    without returning any object

    @SuppressWarnings("unchecked")
    public void showAllProjectsList() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "select * from projects";
        Collection<Project> projectsList = session.createNativeQuery(sql).list();
        logger.info("Reading all Projects: " + projectsList);
        for (Project project : projectsList) {
            ConsoleHelper.writeMessage(project.toString());
        }
        session.getTransaction().commit();
        session.close();
    }

    public void updateProject(Project project) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(project);
        session.getTransaction().commit();
        showProject(project.getId());
        logger.info("Update Project: " + project.getName());
        session.close();
    }

    public void removeProject(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        project = session.get(Project.class, id);
        session.delete(project);
        session.getTransaction().commit();
        logger.info("Remove Project: " + project.getName());
        session.close();
    }
}
