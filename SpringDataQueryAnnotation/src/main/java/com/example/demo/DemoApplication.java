package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("__________Reset and init data________________");
        customerRepository.myDelete();
        customerRepository.save(new Customer("Dead pool", "Marvel"));
        customerRepository.save(new Customer("Thor", "ragnarok"));
        customerRepository.save(new Customer("Iron Man", "Marvel"));
        customerRepository.save(new Customer("Hulk", "Marvel"));
        customerRepository.save(new Customer("Hawkeye", "Marven"));
        customerRepository.save(new Customer("Thanos", "Titan"));
        customerRepository.save(new Customer("Batman", "DC"));
        System.out.println("__________Demo find all order by name desc________________");
        List<Customer> customers = customerRepository.findAllOrderByNameDesc();
        customers.forEach(customer -> System.out.println(customer));

        System.out.println("__________Demo find find by name like 'th'________________");
        List<Customer> listCustomer = customerRepository.findByNameLike("%th%");
        listCustomer.forEach(customer -> System.out.println(customer));
    }
}
