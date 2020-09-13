package pd.rest.repository;

import pd.rest.Address;
import pd.rest.Customer;

public class CustomerFactory {





    public static Customer createDefaultCustomer(){
        Customer customer = new Customer();
        customer.setName("Paweł");
        customer.setId(1);
        customer.setAddress(createDefaultAddress());

        return customer;
    }

     private static Address createDefaultAddress(){
        Address address = new Address();
        address.setCity("Katowice");
        address.setStreet("Korfantego");
        address.setZipCode("42-018");
        return address;
    }
}
