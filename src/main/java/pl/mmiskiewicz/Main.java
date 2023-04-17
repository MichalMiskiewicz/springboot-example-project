package pl.mmiskiewicz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*@ComponentScan(basePackages = "pl.mmiskiewicz")
@EnableAutoConfiguration*/
@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    /*@GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse(
                "Hello",
                List.of("Java", "Golang", "JavaScript"),
                new Person("Alex", 24, 30_000)
        );

        return response;
    }

    record Person (String name, int age, double savings){}
    record GreetResponse(
            String greet,
            List<String> favPogrammingLanguages,
            Person person
    ) {}*/
}
