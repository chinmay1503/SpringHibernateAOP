package com.learningspring.hibernate.controller;

import com.learningspring.hibernate.data.Customer;
import com.learningspring.hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> costumers = customerService.getCustomers();
        model.addAttribute(costumers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormAdd(Model model) {
        Customer theCustomer = new Customer();
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormUpdate(@RequestParam("customerId") int theId,
                                 Model model) {
        Customer theCustomer = customerService.getCustomer(theId);
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                  Model theModel) {

        // search customers from the service
        List<Customer> customers = customerService.searchCustomers(theSearchName);

        // add the customers to the model
        theModel.addAttribute(customers);

        return "list-customers";
    }
}
