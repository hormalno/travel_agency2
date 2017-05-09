package com.travelagency.entities.enums;

public enum FlightCategory {

    FIRST_CLASS("First Class"), SECOND_CLASS("Second Class"), TOURIST_CLASS("Tourist Class");

    private String type;

    FlightCategory(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
