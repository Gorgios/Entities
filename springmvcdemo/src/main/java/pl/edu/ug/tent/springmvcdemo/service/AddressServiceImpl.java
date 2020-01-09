package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.domain.Address;
import pl.edu.ug.tent.springmvcdemo.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository ar;

    @Autowired
    public AddressServiceImpl(AddressRepository ar) {
        this.ar = ar;
    }

    @Override
    public List<Address> findAll() {
        return (List<Address>) ar.findAll();
    }

    @Override
    public Address findById(Long id) {
        return ar.findById(id).orElse(null);
    }

    @Override
    public Address add(Address address) {
        Address addingAddress = new Address(address.getStreet(), address.getCity(), address.getNumber());
        return ar.save(addingAddress);
    }

    @Override
    public String update(Address address, Long id) {
        Address a = ar.findById(id).orElse(null);
        if (a != null) {
            a.setCity(address.getCity());
            a.setNumber(address.getNumber());
            a.setShop(address.getShop());
            a.setStreet(address.getStreet());
            ar.save(a);
            return "Successfully added address";
        }
        return "Address with this Id not exists";
    }

    @Override
    public String delete(Long id) {
        if (findById(id) != null) {
            ar.deleteById(id);
            return "Successfully deleted address";
        }
        return "Address with this Id not exists";
    }
}
