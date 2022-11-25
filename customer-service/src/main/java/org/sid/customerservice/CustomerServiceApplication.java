package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, @Autowired(required = false) RepositoryRestConfiguration  restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null,"yafit","yafit@gmail.com"));
            customerRepository.save(new Customer(null,"sam","sam@gmail.com"));
            customerRepository.save(new Customer(null,"ham","ham@gmail.com"));

            customerRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }

}
