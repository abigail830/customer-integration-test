package tdd.customer.application;

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
public class CustomerServiceIT extends IntegrationTestBase {

    @Autowired
    CustomerService customerService;

    @Test
    @DataSet(value = "/db_rider/find_by_name.yml",
            strategy = SeedStrategy.CLEAN_INSERT,
            cleanAfter = true)
    public void findCustomerByName_search_by_first_name() {
        //given

        //when
        final List<Customer> kevin = customerService.findCustomerByName("Kevin", CustomerService.FIRST);

        //then
        assertEquals(1, kevin.size());
        assertEquals("Last1", kevin.get(0).getLastName());
    }

    @Test
    @DataSet(value = "/db_rider/find_by_name.yml",
            strategy = SeedStrategy.CLEAN_INSERT,
            cleanAfter = true)
    public void findCustomerByName_search_by_last_name() {
        //given

        //when
        final List<Customer> kevin = customerService.findCustomerByName("Kevin", CustomerService.LAST);

        //then
        assertEquals(1, kevin.size());
        assertEquals("first2", kevin.get(0).getFirstName());

    }
}