package com.restojavadev11.service;

import com.restojavadev11.entity.MenuEntity;
import com.restojavadev11.parameters.MenuParameters;

import java.util.List;
import java.util.Optional;

public interface IMenuService {

    List<MenuEntity> allMenus();

    Optional<MenuEntity> getMenuById(long id);

    MenuEntity newMenu(MenuParameters menuParameters);

    void updateMenu(MenuEntity menu);

}
