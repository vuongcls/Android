package com.example.vuongvl;

public class Client {
    protected String name;
    protected boolean typeService;

    public Client(String name, boolean typeService) {
        this.name = name;
        this.typeService = typeService;
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        return this;
    }

    public boolean getTypeService() {
        return typeService;
    }

    public Client setTypeService(boolean typeService) {
        return this;
    }
}
