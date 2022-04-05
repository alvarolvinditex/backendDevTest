package com.example.products.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.products.api.codegen.DefaultApi;
import com.example.products.api.codegen.model.ProductDetail;
import com.example.products.entity.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

  @Autowired
  private DefaultApi productApi;

  @Override
  public Product getProduct(String productId) {
      final ProductDetail product = productApi.getProductProductId(productId);
      return Product.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).availability(product.isAvailability()).build();
  }

  @Override
  public List<String> getSimilarProductIds(String productId) {
      return productApi.getProductSimilarids(productId).stream().collect(Collectors.toList());
  }
}
