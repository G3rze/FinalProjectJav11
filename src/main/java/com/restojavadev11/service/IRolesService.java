package com.restojavadev11.service;

import com.restojavadev11.entity.RolesEntity;

import java.util.List;
import java.util.Optional;

public interface IRolesService {

    List<RolesEntity> allRoles();

    Optional<RolesEntity> getRoleById(long id);

    RolesEntity newRole(String name, String description);

    void updateRoles(RolesEntity newRole);
}
