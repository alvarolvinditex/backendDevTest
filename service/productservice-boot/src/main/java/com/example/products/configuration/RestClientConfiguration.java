package com.example.products.configuration;

import com.example.products.api.ApiClient;
import com.example.products.api.codegen.DefaultApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public ApiClient apiClient() {
    return new ApiClient();
  }

  @Bean
  @Primary
  public DefaultApi getDefaultApi(@Qualifier("apiClient") ApiClient apiClient) {
    return new DefaultApi(apiClient);
  }

}
