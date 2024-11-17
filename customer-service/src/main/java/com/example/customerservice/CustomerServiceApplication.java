package com.example.customerservice;


import com.example.customerservice.config.CustomerConfigParams;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
				customerRepository.save(Customer.builder().email("med@gmail.com").name("med").build());
				customerRepository.save(Customer.builder().email("fatiz@gmail.com").name("fatiz").build());
				customerRepository.save(Customer.builder().email("yassine@gmail.com").name("yassine").build());
				customerRepository.findAll().forEach(c->{
					System.out.println("=========================");
					System.out.println(c.getId());
					System.out.println(c.getName());
					System.out.println(c.getEmail());
					System.out.println("=========================");
				});
		};
	}

}
