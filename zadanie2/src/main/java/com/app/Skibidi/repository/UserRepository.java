package com.app.Skibidi.repository;

import com.app.Skibidi.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<Object> findByUsername(String login);
}
