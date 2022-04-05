package com.example.products.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

  private String id;

  private String name;

  private BigDecimal price;

  private Boolean availability;

}
