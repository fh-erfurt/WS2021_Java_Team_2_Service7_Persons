package de.fherfurt.persons.service.model;
import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;



/**
 * The class Address is an Entity in the Database.  The class Address includes the street, city and zipCode of a Person
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
@Entity
@Getter
@Setter
@ToString
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
