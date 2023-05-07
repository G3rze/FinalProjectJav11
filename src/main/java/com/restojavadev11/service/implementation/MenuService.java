package com.restojavadev11.service.implementation;

import com.restojavadev11.service.IMenuService;
import com.restojavadev11.entity.MenuEntity;
import com.restojavadev11.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService implements IMenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuEntity> allMenus() {

        return menuRepository.findAll();
    }

    @Override
    public Optional<MenuEntity> getMenuById(long id) {

        try {
            return menuRepository.findById(id);
        } catch (Exception e){
            return Optional.empty();
        }
    }
}
