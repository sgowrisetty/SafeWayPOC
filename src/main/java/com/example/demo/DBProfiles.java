package com.example.demo;

import com.example.demo.profiles.CRUDRepository;
import com.example.demo.profiles.CosmosRepository;
import com.example.demo.profiles.MongoRepository;
import com.example.demo.profiles.TestRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DBProfiles {

    //With feature.toggles.db true the bean will be created for the mongoRepositoy and return the  MongoRepository Bean
    @Bean
    @ConditionalOnProperty(name ="features.db.name", havingValue = "mongo")
    public TestRepository mongoRepository() {
        return new MongoRepository();
    }
    //With feature.toggles.db false the bean will be created for the crudRepository and return the CRUDRepository Bean
    @Bean
    @ConditionalOnProperty(name ="features.db.name", havingValue = "crud")
    public TestRepository crudRepository()
    {
        return new CRUDRepository();
    }

    @Bean
    @ConditionalOnProperty(name ="features.db.name", havingValue = "cosmos")
    public TestRepository cosmosRepository()
    {
        return new CosmosRepository();
    }

}
