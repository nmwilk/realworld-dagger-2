package com.measuredsoftware.dagger2realworld.model;

/**
 * Created by neil on 19/06/16.
 */
public class User {
    private final String id;

    public User(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
