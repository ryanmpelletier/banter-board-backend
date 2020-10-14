package com.banterboard.banterboardbackend.model;

public class Reaction {

    public static final String LAUGH_WITH = "laugh with";
    public static final String LAUGH_AT = "laugh at";

    public Reaction(){}

    public Reaction(String value){
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
