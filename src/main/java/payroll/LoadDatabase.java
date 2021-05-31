package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(Employee.builder()
                    .firstName("Bilbo")
                    .lastName("Baggins")
                    .role("burglar")
                    .build());
            employeeRepository.save(Employee.builder()
                    .firstName("Frodo")
                    .lastName("Baggins")
                    .role("thief")
                    .build());
            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(Order.builder()
                    .description("MacBook Pro")
                    .status(Status.COMPLETED)
                    .build());
            orderRepository.save(Order.builder()
                    .description("iPhone")
                    .status(Status.IN_PROGRESS)
                    .build());

            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
