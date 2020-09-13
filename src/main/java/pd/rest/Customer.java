package pd.rest;



public class Customer {
    private Integer id;
    private String name;
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer clone(){
        Customer result = new Customer();
        result.address = this.address.clone();
        result.id = this.id;
        result.name = this.name;
        return result;
    }
}
