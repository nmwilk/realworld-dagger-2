package com.measuredsoftware.dagger2realworld.model;

/**
 * Created by neil on 19/06/16.
 */
public class LoginBehaviour {
    private final String logInUrl;

    public LoginBehaviour(final String logInUrl) {
        this.logInUrl = logInUrl;
    }

    public String getLogInUrl() {
        return logInUrl;
    }
}
