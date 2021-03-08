package service;

import model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerServiceORM implements ICustomerService {
    @PersistenceContext
    private EntityManager entityManager;

//
//    @Autowired
//    private SessionFactory sessionFactory;

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
        return entityManager.find(Customer.class, id);

    }

    @Override
    public void delete(Customer customer) {
//        entityManager.remove(entityManager.contains(customer) ? customer : entityManager.merge(customer));
        entityManager.remove(findId(customer.getId()));
    }

    @Override
    public void createAndEdit(Customer customer) {
        if (customer.getId() != 0) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);

        }
    }

}
