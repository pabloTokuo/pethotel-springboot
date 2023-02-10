package app.services;

import app.model.Address;

import java.util.List;

public interface AdressService {

    List<Address> findAll();

    Address findById(Long id);

    Address insertAddress(Address address);

    void deleteAddressById(Long id);


}
