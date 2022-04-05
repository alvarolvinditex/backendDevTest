package com.example.products;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.products.controller.codegen.ProductApi;
import com.example.products.controller.codegen.model.ProductDetail;
import com.example.products.entity.Product;
import com.example.products.usecase.GetSimilarProductsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductWebServiceImpl implements ProductApi {

  @Autowired
  private GetSimilarProductsUseCase getSimilarProducts;

  @Override
  public ResponseEntity<Set<ProductDetail>> getProductSimilar(String productId) {
    final List<Product> products = getSimilarProducts.getSimilarProducts(productId);
    return ResponseEntity.ok(products.stream().map(product -> new ProductDetail().id(product.getId()).availability(product.getAvailability()).price(product.getPrice()).name(product.getName())).collect(
        Collectors.toSet()));
  }
}
