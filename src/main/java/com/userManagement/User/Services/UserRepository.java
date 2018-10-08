package com.userManagement.User.Services;

import com.userManagement.User.Model.*;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}