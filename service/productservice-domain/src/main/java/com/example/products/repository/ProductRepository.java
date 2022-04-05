package com.example.products.repository;

import java.util.List;

import com.example.products.entity.Product;

public interface ProductRepository {

  public Product getProduct(final String productId);

  public List<String> getSimilarProductIds(final String productId);

}
