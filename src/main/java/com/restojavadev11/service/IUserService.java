package com.restojavadev11.service;

import com.restojavadev11.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserEntity> allUsers();

    Optional<UserEntity> getUserById(long id);

    UserEntity newUser(String email, String Password);

    void updateUser(UserEntity newUser);
    UserEntity getCurrentUser();

}
