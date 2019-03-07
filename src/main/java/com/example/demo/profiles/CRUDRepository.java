package com.example.demo.profiles;

//Dummy class to demonstrate the CRUD repository
public class CRUDRepository implements TestRepository {
    @Override
    public TestRepository getRepository() {
        return new CRUDRepository();
    }

    @Override
    public String getRepositoryName() {
        return "CRUD Repository";
    }
}
