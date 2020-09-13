package pd.rest.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import pd.rest.Customer;

public class CustomerRepository {

    private static final Map<Integer, Customer> custStore = new ConcurrentHashMap<>();

    private AtomicInteger lastId;

    static {
        custStore.put(1, CustomerFactory.createDefaultCustomer());
    }

    public CustomerRepository() {
        lastId = new AtomicInteger(custStore.size());
    }

    public Customer save(Customer customer) {
        Integer id = lastId.incrementAndGet();
        Customer toPersist = customer.clone();
        toPersist.setId(id);
        custStore.put(id, toPersist);
        return custStore.get(id);
    }

    public Collection<Customer> findAll() {
        return custStore.values();
    }

    public Optional<Customer> findById(Integer id) {
        return Optional.ofNullable(custStore.get(id));
    }

    public void update(Integer id, Customer customer) {
        Customer toPersist = customer.clone();
        toPersist.setId(id);
        custStore.put(id, toPersist);
    }

    public void delete(Integer id) {
        custStore.remove(id);
    }

}