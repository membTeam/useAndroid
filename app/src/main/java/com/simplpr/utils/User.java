package com.simplpr.utils;

public class User {
    private long id;
    private String first_name;
    private String last_name;
    private String email;


    @Override
    public String toString() {
        return "User: " +
                "\nid= " + id +
                ",\nfirst_name= " + first_name +
                ",\nlast_name= " + last_name +
                ",\nemail= " + email;
    }
}
