package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.RolesEntity;
import com.restojavadev11.repositories.RolesRepository;
import com.restojavadev11.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<RolesEntity> allRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Optional<RolesEntity> getRoleById(long id) {
        return Optional.empty();
    }

    @Override
    public RolesEntity newRole(String name, String description) {
        return null;
    }

    @Override
    public void updateRoles(RolesEntity newRole) {

    }
}
