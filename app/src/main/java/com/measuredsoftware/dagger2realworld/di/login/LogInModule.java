package com.measuredsoftware.dagger2realworld.di.login;

import com.measuredsoftware.dagger2realworld.model.LoginBehaviour;

import dagger.Module;
import dagger.Provides;

/**
 * Created by neil on 19/06/16.
 */
@Module
public class LogInModule {

    private final String logInUrl;

    public LogInModule(final String logInUrl) {
        this.logInUrl = logInUrl;
    }

    @Login
    @Provides
    LoginBehaviour loginBehaviour() {
        return new LoginBehaviour(logInUrl);
    }
}
