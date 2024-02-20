package com.example.springboot_be.controller;

import com.example.springboot_be.entity.Menu;
import com.example.springboot_be.entity.MenuItem;
import com.example.springboot_be.entity.Restaurant;
import com.example.springboot_be.repository.MenuItemRepository;
import com.example.springboot_be.repository.MenuRepository;
import com.example.springboot_be.repository.RestaurantRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
@SecurityRequirement(name = "Keycloak")
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

    @GetMapping
    @RequestMapping("/public/list")
    //Public API
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/public/menu/{restaurantId}")
    //Public API
    public Menu getMenu(@PathVariable Long restaurantId) {
        Menu menu = menuRepository.findByRestaurantId(restaurantId);
        menu.setMenuItems(menuItemRepository.findAllByMenuId(menu.id));
        return menu;
    }

    @PostMapping
    // admin can access (admin)
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PutMapping
    // manager can access (suresh)
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PostMapping
    @RequestMapping("/menu")
    // manager can access (suresh)
    public Menu createMenu(Menu menu) {
        menuRepository.save(menu);
        menu.getMenuItems().forEach(menuItem -> {
            menuItem.setMenuId(menu.id);
            menuItemRepository.save(menuItem);
        });
        return menu;
    }

    @PutMapping
    @RequestMapping("/menu/item/{itemId}/{price}")
    // owner can access (amar)
    public MenuItem updateMenuItemPrice(@PathVariable("itemId") Long itemId
            , @PathVariable("price") BigDecimal price) {
        Optional<MenuItem> menuItem = menuItemRepository.findById(itemId);
        menuItem.get().setPrice(price);
        menuItemRepository.save(menuItem.get());
        return menuItem.get();
    }
}
