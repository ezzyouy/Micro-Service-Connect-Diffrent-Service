package org.sid.customerservice;

import org.sid.customerservice.entities.Product;
import org.sid.customerservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, @Autowired(required = false) RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"HP",3500,12));
            productRepository.save(new Product(null,"MACBook", 12600, 20));
            productRepository.save(new Product(null,"ACER",5000, 44));

            productRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }

}
