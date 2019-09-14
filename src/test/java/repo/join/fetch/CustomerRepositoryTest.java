package repo.join.fetch;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Collection;

@MicronautTest
public class CustomerRepositoryTest {

    @Inject
    CustomerRepository customerRepository;

    @BeforeEach
    public void init() {

        Customer customer = new Customer();
        customer.setName("Kiran");
        customer.setAddress("USA");
        customer.setEmail("user.name@email.com");

        Order order1 = new Order();
        order1.setCustomer(customer);
        order1.setProduct("Prod1");

        Order order2 = new Order();
        order2.setCustomer(customer);
        order2.setProduct("Prod2");

        Order order3 = new Order();
        order3.setCustomer(customer);
        order3.setProduct("Prod1");

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        customer.getOrders().add(order3);

        customerRepository.save(customer);
    }

    @Test
    public void test_findByName() {

        Collection<Customer> customers = customerRepository.findByName("Kiran");
        Assertions.assertEquals(1, customers.size());
    }
}
