package tdd.customer.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tdd.customer.domain.model.Customer;
import tdd.customer.infrastructure.persistence.CustomerRepository;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Test
    public void findCustomerByName_should_able_to_get_customer_by_first_name() {

        //when
        final List<Customer> customerByName = customerService.findCustomerByName("Kevin", CustomerService.FIRST);

        //then
        verify(customerRepository, times(1)).findByFirstName("Kevin");
        verify(customerRepository, never()).findByLastName("Kevin");
    }

    @Test
    public void findCustomerByName_should_able_to_get_customer_by_last_name() {

        //when
        final List<Customer> customerByName = customerService.findCustomerByName("Kevin", CustomerService.LAST);

        //then
        verify(customerRepository, times(1)).findByLastName("Kevin");
        verify(customerRepository, never()).findByFirstName("Kevin");
    }

    @Test(expected = RuntimeException.class)
    public void findCustomerByName_should_able_to_throw_exception() {

        //when
        final List<Customer> customerByName = customerService.findCustomerByName("Kevin", "ABNORMAL");

        //then
        verify(customerRepository, never()).findByLastName("Kevin");
        verify(customerRepository, never()).findByFirstName("Kevin");
    }
}