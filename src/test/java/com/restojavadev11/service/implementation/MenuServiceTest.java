package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.CustomerEntity;
import com.restojavadev11.entity.MenuEntity;
import com.restojavadev11.repositories.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MenuServiceTest {

    @Mock
    private MenuRepository menuRepository;
    @InjectMocks
    private MenuService menuService;
    private MenuEntity menuEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        menuEntity = new MenuEntity();
        menuEntity.setIdMenu(Long.valueOf(1));
        menuEntity.setMDishName("Bistec de ribeye a la parrilla con mantequilla de ajo y vegetales asados");
        menuEntity.setMDescription("Nuestro jugoso bistec es la estrella de este plato. Acompañado de una cremosa mantequilla de ajo y unos vegetales frescos asados al horno para aportar una textura crujiente y un sabor ahumado.");
        menuEntity.setMPrice(27.5);
    }

    @Test
    void allMenus() {
        when(menuRepository.findAll()).thenReturn(Arrays.asList(menuEntity));
        assertNotNull(menuService.allMenus());
    }

    @Test
    void getMenuById() {
        //En comprobacion
        Long menuId = Long.valueOf(1);

        when(menuRepository.findById(menuId)).thenReturn(Optional.of(menuEntity));

        Optional<MenuEntity> actualMenuEntity = menuService.getMenuById(menuId);

        assertEquals(menuEntity, actualMenuEntity.get());

    }
}