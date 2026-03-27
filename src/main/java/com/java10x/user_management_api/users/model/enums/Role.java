package com.java10x.user_management_api.users.model.enums;

public enum Role {

    ADM("High Role"),
    MANAGER("Medium Role"),
    EMPLOYEE("Low Role");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
