package com.restojavadev11.controller;

import com.restojavadev11.entity.MenuEntity;
import com.restojavadev11.parameters.MenuParameters;
import com.restojavadev11.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping("/getAll")
    public List<MenuEntity> getAllMenus(){
        return menuService.allMenus();
    }

    @GetMapping("/getById{id}")
    public Optional<MenuEntity> getMenuById(@RequestParam("id") long id){
        return menuService.getMenuById(id);
    }

    @PostMapping("/create")
    public void insterMenu(@RequestBody MenuParameters menuParameters){
        MenuEntity newMenu =  menuService.newMenu(menuParameters);

        menuService.updateMenu(newMenu);
    }
}
