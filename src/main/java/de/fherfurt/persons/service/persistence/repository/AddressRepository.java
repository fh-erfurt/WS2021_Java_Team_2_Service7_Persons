package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;

import java.util.List;

public interface AddressRepository {



    boolean createAddress( Address address );
    /*
    List<Address> getAllAddresses();
    Address getAddress(Long addressId );
    boolean updateAddress( Address address );
    boolean deleteAddress(Long addressId );

     */
}
