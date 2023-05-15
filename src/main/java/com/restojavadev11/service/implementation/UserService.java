package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.UserEntity;
import com.restojavadev11.repositories.UserRepository;
import com.restojavadev11.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService  {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> allUsers() {
        return null;
    }

    @Override
    public Optional<UserEntity> getUserById(long id) {
        return Optional.empty();
    }

    @Override
    public UserEntity newUser(String email, String Password) {
        return null;
    }

    @Override
    public void updateUser(UserEntity newUser) {

    }


    @Override
    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();


        System.out.println("Roles of the current user:");

        for (GrantedAuthority authority : authentication.getAuthorities()) {
            System.out.println(authority.getAuthority());
        }
        return userRepository.findByEmail(currentPrincipalName).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOptional = this.userRepository.findByEmail(username);

        if (!userEntityOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        UserEntity userEntity = userEntityOptional.get();
        String[] roles = userEntity.getRoles().stream()
                .map(role -> role.getName().replaceFirst("ROLE_", ""))
                .toArray(String[]::new);

        System.out.println("Roles: ");
        System.out.println(Arrays.toString(roles));

        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .roles(roles)
                .build();
    }

}
