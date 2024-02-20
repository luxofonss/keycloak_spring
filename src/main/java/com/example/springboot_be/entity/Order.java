package com.example.springboot_be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private Long restaurantId;

    private BigDecimal total;

    @Transient
    private List<OrderItem> orderItems;
}
