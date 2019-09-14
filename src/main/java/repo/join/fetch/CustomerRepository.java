package repo.join.fetch;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Collection;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Join(value = "orders", type = Join.Type.FETCH)
    Collection<Customer> findByName(String name);
}
