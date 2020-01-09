package pl.edu.ug.tent.springmvcdemo.service;

import pl.edu.ug.tent.springmvcdemo.domain.Address;
import pl.edu.ug.tent.springmvcdemo.domain.Product;

import java.util.List;

public interface AddressService {

    List<Address> findAll();

    Address findById(Long id);

    Address add(Address address);

    String update(Address address, Long id);

    String delete(Long id);

}
