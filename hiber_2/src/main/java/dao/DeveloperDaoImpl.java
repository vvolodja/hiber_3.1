package dao;

import model.Developer;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDaoImpl implements DeveloperDao {

    public void addDeveloper(Developer developer) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(developer);
        session.getTransaction().commit();
        session.close();
    }

    public void updateDeveloper(Developer developer) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(developer);
        session.getTransaction().commit();
        session.close();
    }

    public void removeDeveloper(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(session.get(Developer.class, id));
//        Query query = (Query) session.createQuery("delete Developer where id = :id");
        session.getTransaction().commit();
        session.close();

    }

    public Developer getDeveloperById(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        session.getTransaction().commit();
        session.close();

        return developer;
    }

    //    ������ �������������, �������������� �� ���������� �������

    public List<Developer> getDevelopersByProject(int id) throws SQLException {

        List<Developer> allDevelopersOnProject = new ArrayList<Developer>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Developer as d join fetch d.projects as p where p.id = :projectId";
        allDevelopersOnProject = session.createQuery(hql).setParameter("projectId", id).list();
        session.getTransaction().commit();
        session.close();

        return allDevelopersOnProject;
    }

    //    ������ ���� �������������
    @SuppressWarnings("unchecked")
    public List<Developer> getAllDevelopersList() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Developer";
        List<Developer> allDevelopersList = session.createQuery(hql).list();
        session.getTransaction().commit();
        session.close();

        return allDevelopersList;
    }
}
