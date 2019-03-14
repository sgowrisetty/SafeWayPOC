package com.example.demo.profiles;

public class CosmosRepository implements TestRepository {
    @Override
    public TestRepository getRepository() {
        return new CosmosRepository();
    }

    @Override
    public String getRepositoryName() {
        return "Cosmos Repossitory";
    }


}
