package com.restojavadev11.service.implementation;

import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.MenuParameters;
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
            return Optional.ofNullable(menuRepository.findById(id));
        } catch (Exception e){
            //Catch the corresponding exception with the DataAccesEx. class, if there's a problem with the id search
            throw new DataAccessException("Cannot find the menu id", e);
        }
    }

    @Override
    public MenuEntity newMenu(MenuParameters menuParameters) {
        MenuEntity newMenu = new MenuEntity();

        newMenu.setMDishName(menuParameters.getName());
        newMenu.setMDescription(menuParameters.getDescription());
        newMenu.setMPrice(menuParameters.getPrice());

        return newMenu;
    }

    @Override
    public void updateMenu(MenuEntity newMenu) {
        menuRepository.save(newMenu);
    }
}
