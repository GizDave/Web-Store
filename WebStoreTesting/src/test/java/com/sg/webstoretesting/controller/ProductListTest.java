package com.sg.webstoretesting.controller;

import com.sg.webstoretesting.dao.ProductRepository;
import com.sg.webstoretesting.dto.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductListTest {

    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);

    private ProductList productList;

    @BeforeEach
    void setUp() {
        productList = new ProductList(productRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void productHasName() {
       Product product = new Product(1, "Razer");
       when(productRepository.save(any(Product.class))).then(returnsFirstArg());
       Product savedProduct = productList.saveProduct(product);
       Assertions.assertThat(savedProduct.getName()).isNotNull();
    }

    @Test
    void productHasCategoryId() {
        Product product = new Product(1, "Razer");
        when(productRepository.save(any(Product.class))).then(returnsFirstArg());
        Product savedProduct = productList.saveProduct(product);
        Assertions.assertThat(savedProduct.getCategoryId()).isNotNull();
    }

    @Test
    void productHasNullDescription() {
        Product product = new Product(1, "Razer");
        when(productRepository.save(any(Product.class))).then(returnsFirstArg());
        Product savedProduct = productList.saveProduct(product);
        Assertions.assertThat(savedProduct.getDescription()).isNull();
    }

    @Test
    void productHasDescription() {
        Product product = new Product(1, "Razer");
        product.setDescription("Overpriced mechanical keyboard.");
        when(productRepository.save(any(Product.class))).then(returnsFirstArg());
        Product savedProduct = productList.saveProduct(product);
        Assertions.assertThat(savedProduct.getDescription()).isNotNull();
        Assertions.assertThat(savedProduct.getDescription()).isEqualTo("Overpriced mechanical keyboard.");
    }

}