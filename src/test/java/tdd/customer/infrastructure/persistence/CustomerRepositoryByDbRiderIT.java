package tdd.customer.infrastructure.persistence;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.SeedStrategy;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tdd.customer.IntegrationTestBase;
import tdd.customer.domain.model.Customer;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DBRider
public class CustomerRepositoryByDbRiderIT extends IntegrationTestBase {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @DataSet(value = "/db_rider/find_by_last_name.yml",
            strategy = SeedStrategy.CLEAN_INSERT,
            cleanAfter = true)
    public void findByLastName() {
        //given
        System.out.println("In CustomerRepositoryByDbRiderIT");
        //when
        final List<Customer> customerList = customerRepository.findByLastName("Last");

        //then
        assertEquals(1, customerList.size());
        assertEquals("First", customerList.get(0).getFirstName());
    }
}