package tdd.customer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdd.customer.domain.model.Customer;
import tdd.customer.infrastructure.persistence.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    public static final String FIRST = "F";
    public static final String LAST = "2";
    @Autowired
    CustomerRepository repository;

    public void create(Customer customer) {
        repository.save(customer);
    }

    public Optional<Customer> findById(long id) {
        return repository.findById(id);
    }


    public List<Customer> findAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Customer> findCustomerByName(String name, String searchType) {
        if (searchType.equals(LAST))
            return repository.findByLastName(name);
        else if (searchType.equals(FIRST))
            return repository.findByFirstName(name);
        else
            throw new RuntimeException("Invalid searchType");
    }
}
