package com.java10x.user_management_api.tasks.model.enums;

public enum Difficulty {

    EASY("Low difficulty"),
    MEDIUM("Medium difficulty"),
    HARD("High difficulty");

    private String description;

    Difficulty(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
