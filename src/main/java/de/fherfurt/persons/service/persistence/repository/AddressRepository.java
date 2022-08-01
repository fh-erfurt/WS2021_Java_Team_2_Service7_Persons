package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;

import java.util.List;

public interface AddressRepository {



    boolean createAddress( Address address );

    List<Address> findAllAddresses();
    Address findAddressBy(Long addressId );
    boolean updateAddressBy( long addressId ,Address address );
    boolean deleteAddressBy(long addressId );
}
