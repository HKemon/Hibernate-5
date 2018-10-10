//package entities;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "address_table")
//public class Address{
//
//    @Id
//    @Column(name = "address_id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence_generator")
//    @SequenceGenerator(name = "address_sequence_generator",sequenceName = "employee_sequence", allocationSize=1)
//    private Integer addressId;
//
//    @Column(name = "street_name")
//    private String street;
//
//    public Integer getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(Integer addressId) {
//        this.addressId = addressId;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "addressId=" + addressId +
//                ", street='" + street + '\'' +
//                '}';
//    }
//}