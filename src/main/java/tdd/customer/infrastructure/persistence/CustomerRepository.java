package tdd.customer.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import tdd.customer.domain.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

}
