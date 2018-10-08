package com.userManagement.User.Services;

import com.userManagement.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by lauda on 20.09.2018.
 */

@Service
public class AuthenticatedUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("The user " + username + " does not exist");
        }

        return new AuthenticatedUser(user);
    }
}
