package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;

import java.util.List;


/**
 * The interface AddressRepository represent the abstract layer between AddressResources and Repository-Layer.
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
public interface AddressRepository {

    List<Address> findAllAddresses();
    Address findAddressBy(Long addressId );
    boolean createAddress( Address address );
    boolean updateAddressBy(Address address );
    boolean deleteAddressBy(long addressId );
}
