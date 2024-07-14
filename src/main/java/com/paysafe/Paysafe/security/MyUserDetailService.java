package com.paysafe.Paysafe.security;

import com.paysafe.Paysafe.model.MyUser;
import com.paysafe.Paysafe.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService  implements UserDetailsService {

    @Autowired
    private MyUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = repository.findByUsername(username);
        var userObj = user.get();
        if(user.isPresent()){
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        }
        else {
            throw new UsernameNotFoundException(username);
        }


    }

    private String[] getRoles(MyUser user) {
        if(user.getRole() == null)return new String[]{ "USER"};
        else{
            return user.getRole().split(";");
        }

    }
}
