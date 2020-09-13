package pd.rest;

public class Address {
    private String city;
    private String street;
    private String zipCode;

    public Address(){}

   public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Address clone(){
        Address address = new Address();
        address.city = this.city;
        address.street = this.street;
        address.zipCode = this.zipCode;

        return address;
    }
}
