package com.example.demo.controller;

import com.example.demo.Features;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.FileNotFoundException;
import java.util.List;

//@ConditionalOnProperty(name="feature.toggles.dbOperations",havingValue = "true")

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    Features features;

    /*This method will return all the products exists in the mongo testDB.Product table*/
    @GetMapping(value = "/getAllProducts", headers = "Accept=application/json")
    public List<Product> getProductInfo() {
        return productService.getAllProducts();
    }
    /*
        This method will save the Product in to the Mongo DB if the updateFeatureEnabled is true
    */
    @PostMapping(value = "/saveProduct", headers = "Accept=application/json")
    public void saveProduct(@RequestBody Product newProduct) throws Exception {
        if(!features.updateFeatureEnabled())
            throw new FileNotFoundException();
        productService.saveProduct(newProduct);
    }

    @GetMapping(value = "/getProduct", headers = "Accept=application/json")
    public Product getProduct(@PathParam("id") int id) {
        return productService.getProduct(id);
    }
}
