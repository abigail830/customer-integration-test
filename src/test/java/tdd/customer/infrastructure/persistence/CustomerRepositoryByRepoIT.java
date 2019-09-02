package tdd.customer.infrastructure.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tdd.customer.IntegrationTestBase;
import tdd.customer.domain.model.Customer;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CustomerRepositoryByRepoIT extends IntegrationTestBase {


    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        //given
        final Customer kevin = new Customer("First", "Kevin");
        customerRepository.save(kevin);
    }

    @After
    public void tearDown() throws Exception {
        customerRepository.deleteAll();
    }

    @Test
    public void findByLastName_should_able_find_Kevin_when_exist_in_DB() {

        //when
        final List<Customer> result = customerRepository.findByLastName("Kevin");

        //then
        assertEquals(1, result.size());
        assertEquals("First", result.get(0).getFirstName());

    }

    @Test
    public void findByLastName_should_get_0_when_not_exist_in_DB() {

        //when
        final List<Customer> result = customerRepository.findByLastName("Dennis");

        //then
        assertEquals(0, result.size());
    }
}