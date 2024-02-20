package com.example.springboot_be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private Long menuId;

    private String name;

    private String description;

    @Column(name = "type_name")
    private String type;

    @Column(name = "group_name")
    private String group;

    private BigDecimal price;
}
