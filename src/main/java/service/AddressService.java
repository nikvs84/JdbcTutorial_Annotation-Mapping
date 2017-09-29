package service;

import bl.SessionUtil;
import dao.AddressDAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AddressService extends SessionUtil implements AddressDAO {
    @Override
    public void add(Address address) {
        openTransactionSession();

        Session session = getSession();
        session.save(address);

        closeTransactionSession();
    }

    @Override
    public List<Address> getAll() {
        String sql = "SELECT * FROM ADDRESS";

        openTransactionSession();
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> result = query.list();

        closeTransactionSession();

        return result;
    }

    @Override
    public Address getById(Long id) {
        Address result = null;
        String sql = "SELECT * FROM ADDRESS WHERE ID = :id";
        openTransactionSession();

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);

        result = (Address) query.getSingleResult();

        closeTransactionSession();
        return result;
    }

    @Override
    public void update(Address address) {
        String sql = "";

        openTransactionSession();

        Session session = getSession();
        session.update(address);

        closeTransactionSession();
    }

    @Override
    public void remove(Address address) {
        openTransactionSession();

        Session session = getSession();
        session.remove(address);

        closeTransactionSession();
    }
}
