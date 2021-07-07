package com.sg.mthree.webstore.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductListTest {

    protected ProductList productList = new ProductList();

    @Test
    void getPageNumber() {
        int actual = productList.getPageNumber();
        int expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    void getMaxPageNumber() {
    }

    @Test
    void getItemCount() {
    }

    @Test
    void getDisplayOrder() {
    }

    @Test
    void getItemCountOption() {
    }

    @Test
    void getDisplayOrderOption() {
    }

    @Test
    void getCategories() {
    }

    @Test
    void setPageNumber() {
    }

    @Test
    void setItemCount() {
    }

    @Test
    void setDisplayOrder() {
    }

    @Test
    void setCategory() {
    }

    @Test
    void nextPage() {
    }

    @Test
    void prevPage() {
    }

    @Test
    void search() {
    }
}