package de.fherfurt.persons.service.model;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @Column(name = "addressId", nullable = false)
    private Long addressId;

    private String street;
    private String city;
    private String zipCode;

    public Address() {}

    public Address( String street, String city, String zipCode ) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }



}
