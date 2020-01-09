package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Address;
import pl.edu.ug.tent.springmvcdemo.service.AddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressController {

    private AddressService as;

    @Autowired
    public AddressController(AddressService as) {
        this.as = as;
    }

    @GetMapping("/api/address")
    public List<Address> getAllAddresses(){
        return  as.findAll();
    }
    @GetMapping("/api/address/{id}")
    public Address getAddress(@PathVariable Long id){
        return as.findById(id);
    }
    @PostMapping("/api/address")
    public Address addAddress(@Valid @RequestBody Address address){
        return as.add(address);
    }
    @PutMapping("/api/address/{id}")
    public String updateAddress(@Valid @RequestBody Address address, @PathVariable Long id){
        return as.update(address,id);
    }
    @DeleteMapping("/api/address/{id}")
    public String deleteAddress(@PathVariable Long id){
        return as.delete(id);
    }
}
