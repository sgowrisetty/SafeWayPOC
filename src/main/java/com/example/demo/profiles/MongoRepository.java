package com.example.demo.profiles;

//Dummy class to demonstrate the Mongo repository
public class MongoRepository implements TestRepository {

    //Sending new MongoRpository class while @Autowiring TestRepository
    @Override
    public TestRepository getRepository() {
        return new MongoRepository();
    }

    //Sending the Name of the Repository
    @Override
    public String getRepositoryName() {
        return "MongoRepository";
    }
}
