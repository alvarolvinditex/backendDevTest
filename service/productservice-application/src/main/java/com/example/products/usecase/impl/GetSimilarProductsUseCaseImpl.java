package com.example.products.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.products.entity.Product;
import com.example.products.repository.ProductRepository;
import com.example.products.usecase.GetSimilarProductsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSimilarProductsUseCaseImpl implements GetSimilarProductsUseCase {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> getSimilarProducts(String productId) {
    final List<Product> result = new ArrayList<>();
    final List<String> similarProductsIds = productRepository.getSimilarProductIds(productId);

    similarProductsIds.forEach(similarProductsId -> {
      result.add(productRepository.getProduct(similarProductsId));
    });
    return result;
  }
}
