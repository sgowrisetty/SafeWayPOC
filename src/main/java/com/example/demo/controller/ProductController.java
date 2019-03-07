package com.example.demo.controller;

import com.example.demo.Features;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getProductInfo() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    /*
        This method will save the Product in to the Mongo DB
        if the updateFeatureEnabled is true else throw the error bad Request
    */
    @PostMapping(value = "/saveProduct", headers = "Accept=application/json")
    public ResponseEntity saveProduct(@RequestBody Product newProduct) throws Exception {
        if (features.updateFeatureEnabled()) {
            productService.saveProduct(newProduct);

        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getProduct/{id}", headers = "Accept=application/json")
    public ResponseEntity getProduct(@PathVariable("id") int id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }
}
