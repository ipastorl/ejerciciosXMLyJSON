package U9.Entregable2122;

/**
 * Clase Customer con los atributos como final,
 * con Getters, sin Setters
 */
public class Customer {
    private final Integer customerNumber, salesRepEmployeeNumber;
    private final String customerName
                        , contactLastName
                        , contactFirstName
                        , phone
                        , addressLine1
                        , addressLine2
                        , city
                        , state
                        , postalCode
                        , country;
    private final Double creditLimit;


    public Customer(
                    Integer customerNumber,
                    Integer salesRepEmployeeNumber,
                    String customerName,
                    String contactLastName,
                    String contactFirstName,
                    String phone,
                    String addressLine1,
                    String addressLine2,
                    String city,
                    String state,
                    String postalCode,
                    String country,
                    Double creditLimit) {
        this.customerNumber = customerNumber;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.creditLimit = creditLimit;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public Integer getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }
}
