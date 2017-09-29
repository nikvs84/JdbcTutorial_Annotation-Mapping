package service;

import bl.SessionUtil;
import dao.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDAO {
    @Override
    public void add(Project project) {
        openTransactionSession();

        Session session = getSession();
        session.save(project);

        closeTransactionSession();
    }

    @Override
    public List<Project> getAll() {
        List<Project> result = null;
        String sql = "SELECT * FROM PROJECT";

        openTransactionSession();

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);

        result = query.list();

        closeTransactionSession();

        return result;
    }

    @Override
    public Project getById(Long id) {
        Project result = null;
        String sql = "";

        openTransactionSession();

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);

        result = (Project) query.getSingleResult();

        closeTransactionSession();

        return result;
    }

    @Override
    public void update(Project project) {
        openTransactionSession();

        Session session = getSession();
        session.update(project);

        closeTransactionSession();
    }

    @Override
    public void remove(Project project) {
        openTransactionSession();

        Session session = getSession();
        session.remove(project);

        closeTransactionSession();
    }
}
