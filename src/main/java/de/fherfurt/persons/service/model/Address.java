package de.fherfurt.persons.service.model;
import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Address extends AbstractDatabaseEntity{


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
