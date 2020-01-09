package pl.edu.ug.tent.springmvcdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Address;
import pl.edu.ug.tent.springmvcdemo.domain.Product;
import pl.edu.ug.tent.springmvcdemo.domain.Shop;

public interface ShopRepository extends CrudRepository<Shop,Long> {
    Shop findByAddress(Address address);
}
