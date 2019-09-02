package tdd.customer.presentation.rest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.SeedStrategy;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import tdd.customer.IntegrationTestBase;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@DBRider
public class CustomerControllerIT extends IntegrationTestBase {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DataSet(value = "/db_rider/find_by_name.yml",
            strategy = SeedStrategy.CLEAN_INSERT,
            cleanAfter = true)
    public void findAll() throws Exception {

        final MvcResult mvcResult = mockMvc.perform(get("/api/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());

        String expect = "[{\"id\":1,\"firstName\":\"Kevin\",\"lastName\":\"Last1\"}," +
                "{\"id\":2,\"firstName\":\"first2\",\"lastName\":\"Kevin\"}]";
        assertEquals(expect, mvcResult.getResponse().getContentAsString());

    }
}