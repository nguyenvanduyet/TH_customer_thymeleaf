package service;

import com.mysql.cj.xdevapi.SessionFactory;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerServiceORM implements ICustomerService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        String query = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> query1 = entityManager.createQuery(query, Customer.class);
        return query1.getResultList();
    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public Customer findId(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void create(Customer customer) {

    }

    @Override
    public void edit(int id, Customer customer) {

    }
}
