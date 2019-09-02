package tdd.customer.infrastructure.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import tdd.customer.IntegrationTestBase;
import tdd.customer.domain.model.Customer;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerRepositoryByJdbcIT extends IntegrationTestBase {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        jdbcTemplate.update("insert into customer (first_name, last_name) values ('First', 'Last')");
    }

    @After
    public void tearDown() throws Exception {
        jdbcTemplate.update("truncate table customer");
    }

    @Test
    public void should_get_1_in_list_when_findByLastName() {

        //when
        final List<Customer> customerList = customerRepository.findByLastName("Last");
        //then
        assertEquals(1, customerList.size());
        assertEquals("First", customerList.get(0).getFirstName());
    }

    @Test
    public void should_get_0_in_list_when_findByLastName() {

        //when
        final List<Customer> customerList = customerRepository.findByLastName("Wrong");
        //then
        assertEquals(0, customerList.size());
    }

}