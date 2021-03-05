package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public ICustomerService customerService;

    @GetMapping("")
    public ModelAndView showAllCustomer(){
        ModelAndView modelAndView = new ModelAndView("list");
        List <Customer> customerList = customerService.findAll();
        modelAndView.addObject("list",customerList);
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView findByName(@RequestParam String name){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findByName(name);
        modelAndView.addObject("list",customers);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditCustomer(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Customer customer = customerService.findId(id);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable int id,@ModelAttribute Customer customer){
        customer.setId(id);
        customerService.edit(id,customer);
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable int id){
        customerService.delete(id);
        return new ModelAndView("redirect:/customer");
    }
    @GetMapping("/create")
    public ModelAndView showCreateCustomer(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("c",new Customer());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createStudent( @ModelAttribute Customer customer){
        int id =(int)(Math.random()*1000) ;
        customer.setId(id);
        customerService.create(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        return modelAndView;
    }
}
