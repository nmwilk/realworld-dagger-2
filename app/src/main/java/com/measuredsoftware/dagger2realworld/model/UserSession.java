package com.measuredsoftware.dagger2realworld.model;

import android.content.SharedPreferences;

/**
 * Created by neil on 19/06/16.
 */
public class UserSession {
    private static final String KEY_LOGGED_IN_USER = "logged_in_user";

    private User user;

    private SharedPreferences sharedPreferences;

    public UserSession(final SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;

        if (sharedPreferences.contains(KEY_LOGGED_IN_USER)) {
            user = new User(sharedPreferences.getString(KEY_LOGGED_IN_USER, ""));
        }
    }

    public void loginUser(final User user) {
        sharedPreferences.edit().putString(KEY_LOGGED_IN_USER, user.getId()).apply();
        this.user = user;
    }

    public void logoutUser() {
        user = null;
        sharedPreferences.edit().remove(KEY_LOGGED_IN_USER).apply();
    }

    public boolean isUserLoggedIn() {
        return user != null;
    }

    public User getUser() {
        return user;
    }
}
