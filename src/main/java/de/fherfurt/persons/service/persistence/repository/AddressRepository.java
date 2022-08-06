package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;

import java.util.List;

public interface AddressRepository {

    List<Address> findAllAddresses();
    Address findAddressBy(Long addressId );
    boolean createAddress( Address address );
    boolean updateAddressBy(Address address );
    boolean deleteAddressBy(long addressId );
}
