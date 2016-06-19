package com.measuredsoftware.dagger2realworld.di.login;

import com.measuredsoftware.dagger2realworld.LoginActivity;
import com.measuredsoftware.dagger2realworld.di.ApplicationComponent;

import dagger.Component;

/**
 * Created by neil on 19/06/16.
 */
@Login
@Component (dependencies = ApplicationComponent.class, modules = LogInModule.class)
public interface LogInComponent {
    void inject(LoginActivity loginActivity);
}
