package tdd.customer.domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @Test
    public void toString应将客户信息转换成字符串() {
        Customer customer = new Customer();
        customer.setId(100L);
        customer.setFirstName("Bruce");
        customer.setLastName(("Lee"));

        assertThat(customer.toString())
                .isEqualTo( "Customer{id=100, firstName='Bruce', lastName='Lee'}" );


    }

}