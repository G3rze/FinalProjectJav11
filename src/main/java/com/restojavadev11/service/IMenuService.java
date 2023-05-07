package com.restojavadev11.service;

import com.restojavadev11.models.MenuEntity;

import java.util.List;
import java.util.Optional;

public interface IMenuService {

    List<MenuEntity> allMenus();

    Optional<MenuEntity> getMenuById(long id);

}
