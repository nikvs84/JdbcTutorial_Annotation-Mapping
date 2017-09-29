package service;

import bl.SessionUtil;
import dao.EmployeeDAO;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService extends SessionUtil implements EmployeeDAO {
    @Override
    public void add(Employee employee) {
        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        closeTransactionSession();
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> result = null;
        String sql = "SELECT * FROM EMPLOYEE";

        openTransactionSession();

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);

        result = query.list();

        closeTransactionSession();

        return result;
    }

    @Override
    public Employee getById(Long id) {
        Employee result = null;
        String sql = "SELECT * FROM EMPLOYEE WHERE ID = :id";

        openTransactionSession();

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);

        result = (Employee) query.getSingleResult();

        closeTransactionSession();

        return result;
    }

    @Override
    public void update(Employee employee) {
        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        closeTransactionSession();
    }

    @Override
    public void remove(Employee employee) {
        openTransactionSession();

        Session session = getSession();
        session.remove(employee);

        closeTransactionSession();
    }
}
