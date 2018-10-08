package com.userManagement.User.Services;

import com.userManagement.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDao{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean saveUser(User user) {

      if (validateUsername(user).equals(Boolean.TRUE)){
          user.setPassword(passwordEncoder.encode(user.getPassword()));
          userRepository.save(user);
          return true;
      }

      return false;
    }

    private Boolean validateUsername(User user){
        if(userRepository.findByUsername(user.getUsername()) == null)
            return true;
        else
            return false;
    }

}