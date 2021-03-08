package service;

import model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> findAll();
    List<Customer> findByName(String name);
    Customer findId(int id);
    void delete(Customer customer);
    void createAndEdit (Customer customer);
}
