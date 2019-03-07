package com.example.demo;

import com.example.demo.controller.DBController;
import com.example.demo.profiles.TestRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class TestFeatureFlag {

   public DBController dbController;

   @Mock
   TestRepository testRepository;

    @Test
    public void TestDBAccess()
    {
        dbController =new DBController();
        Assert.assertEquals("MongoRepository",dbController.getDBDetails());
    }
}
