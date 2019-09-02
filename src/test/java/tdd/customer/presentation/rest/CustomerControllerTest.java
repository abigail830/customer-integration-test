package tdd.customer.presentation.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tdd.customer.application.CustomerService;
import tdd.customer.domain.model.Customer;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    @Test
    public void findAll() {
        //given
        final Customer customer = new Customer("First", "Last");
        when(customerService.findAll()).thenReturn(Arrays.asList(customer));
        //when
        final List<Customer> customers = customerController.findAll();
        //then
        verify(customerService, times(1)).findAll();
        assertEquals(1, customers.size());
        assertEquals("First", customers.get(0).getFirstName());
        assertEquals("Last", customers.get(0).getLastName());

    }
}