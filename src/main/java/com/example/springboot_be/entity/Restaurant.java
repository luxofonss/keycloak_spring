package com.example.springboot_be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String name;

    private String location;

    @Column(name = "type_name")
    private String type;
}
