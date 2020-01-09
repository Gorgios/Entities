package pl.edu.ug.tent.springmvcdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Address;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
