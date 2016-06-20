package com.measuredsoftware.dagger2realworld.di.login;

import com.measuredsoftware.dagger2realworld.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by neil on 19/06/16.
 */
@Login
@Subcomponent(modules = LogInModule.class)
public interface LogInComponent {
    void inject(LoginActivity loginActivity);
}
