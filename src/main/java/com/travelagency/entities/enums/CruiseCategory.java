package com.travelagency.entities.enums;


public enum CruiseCategory {

    FIRST_CLASS("First Class"), SECOND_CLASS("Second Class"), TOURIST_CLASS("Tourist Class");

    private String type;

    CruiseCategory(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String classType) {
        this.type = classType;
    }
}
