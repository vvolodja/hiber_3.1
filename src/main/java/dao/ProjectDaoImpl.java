package dao;

import model.Project;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;


public class ProjectDaoImpl {

    public void addProject(Project project) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(project);
        session.getTransaction().commit();
        session.close();
    }

    public Project getProject(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Project project = session.get(Project.class, id);
        session.getTransaction().commit();
        session.close();

        return project;
    }

    public List<Project> getAllProjectsList( ) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Project> allProjectList = session.createQuery("from Project").list();
        session.getTransaction().commit();
        session.close();

        return allProjectList;
    }

    public void updateProject(Project project) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(project);
        session.getTransaction().commit();
        session.close();
    }

    public void removeProject(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(session.get(Project.class, id));
        session.getTransaction().commit();
        session.close();
    }
}
