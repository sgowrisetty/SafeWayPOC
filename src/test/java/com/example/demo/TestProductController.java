package com.example.demo;

import com.example.demo.controller.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class TestProductController {

    @InjectMocks
    ProductController productController;


    @Test
    public void testSaveProduct() {

    }
}
