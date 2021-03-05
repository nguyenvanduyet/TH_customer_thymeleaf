//package service;
//
//import model.Customer;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CustomerService implements ICustomerService {
//    public static Map<Integer,Customer> customers = new HashMap<>();
//
//    static {
//        customers.put(1,new Customer(1, "Thanh", "Hà Nội", "phucthanh@gmail.com"));
//        customers.put(2 ,new Customer(2, "Toàn", "Thái Bình", "toanpham@gmail.com"));
//        customers.put(3,new Customer(3, "hiếu", "Hà Nội", "hieubi@gmail.com"));
//        customers.put(4,new Customer(4, "Mung", "Nam Dinh", "vumung@gmail.com"));
//        customers.put(5,new Customer(5, "việt", "Hà Nội", "damviet@gmail.com"));
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return new ArrayList<>(customers.values());
//    }
//
//    @Override
//    public List<Customer> findByName(String name) {
//        List<Customer> customerList = new ArrayList<>();
//        for (Customer c : customers.values()) {
//            if (c.getName().equals(name)) {
//                customerList.add(c);
//            }
//        }
//        return customerList;
//    }
//
//    @Override
//    public Customer findId(int id) {
//
//        return customers.get(id);
//    }
//
//    @Override
//    public void delete(int id) {
//        customers.remove(id);
//
//    }
//
//    @Override
//    public void create( Customer customer) {
//        customers.put(customer.getId(), customer);
//    }
//
//    @Override
//    public void edit(int id, Customer customer) {
//        customers.put(id,customer);
//    }
//}
