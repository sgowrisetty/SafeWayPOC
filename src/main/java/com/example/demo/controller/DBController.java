package com.example.demo.controller;

import com.example.demo.profiles.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class DBController {

    @Autowired
    TestRepository testRepository;

    @GetMapping(value = "/DB", headers = "Accept=application/json")
    public String getDBDetails() {
        return testRepository.getRepositoryName();
    }
}
