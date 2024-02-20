package com.example.springboot_be.repository;

import com.example.springboot_be.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository  extends JpaRepository<Menu, Long> {

    Menu findByRestaurantId(Long restaurantId);
}
