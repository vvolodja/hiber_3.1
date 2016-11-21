package dao;

import view.ConsoleHelper;

import model.Developer;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeveloperDaoImpl implements DeveloperDao {

    private static Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    Developer developer;


    public void addDeveloper(Developer developer) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(developer);
        session.getTransaction().commit();
        logger.info("Add Developer: " + developer.getName());
        session.close();
    }

    public void updateDeveloper(Developer developer) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(developer);
        session.getTransaction().commit();
        showDeveloper(developer.getId());
        logger.info("Update Developer: " + developer.getName());

        session.close();
    }

    public void removeDeveloper(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//        session.delete(session.get(Developer.class, id));
        developer = session.get(Developer.class, id);
        session.delete(developer);
//        Query query = (Query) session.createQuery("delete Developer where id = :id");
        session.getTransaction().commit();
        logger.info("Remove Developer: " + developer.getName());
        session.close();

    }

    public Developer getDeveloperById(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        developer = session.get(Developer.class, id);
        session.getTransaction().commit();
        session.close();

        return developer;
    }

    //    new_1
    public void showDeveloper(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//        Developer developer = null;
        try {
            developer = session.load(Developer.class, id);
            session.getTransaction().commit();
            ConsoleHelper.writeMessage(developer.toString());
        } catch (ObjectNotFoundException e) {
            ConsoleHelper.writeMessage("Разработчик с указанным ID не найден.");
        } finally {
            session.close();
        }
    }

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

    //    new_2
    public void showAllDevelopers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Collection<Developer> listDevelopers = session.createQuery("FROM Developer").list();
        logger.info("Reading all Developer: " + listDevelopers);
        for (Developer developer : listDevelopers) {
            ConsoleHelper.writeMessage(developer.toString());
        }
        session.close();
    }
}
