package com.example.products.usecase;

import java.util.List;

import com.example.products.entity.Product;

public interface GetSimilarProductsUseCase {

  public List<Product> getSimilarProducts(final String productId);

}
