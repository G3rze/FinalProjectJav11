package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.UserEntity;
import com.restojavadev11.repositories.UserRepository;
import com.restojavadev11.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

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
}
