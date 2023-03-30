package edu.iu.p565.customerservice.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.customerservice.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Customer> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public int create(@Valid  @RequestBody Customer customer){

       Customer addedcustomer =  repository.save(customer);
       return addedcustomer.getId();
    }
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer,@PathVariable int id){
        customer.setId(id);
        repository.save(customer);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Customer customer = new Customer();
        customer.setId(id);
        repository.delete(customer);
    }
       
}
