package com.measuredsoftware.dagger2realworld.di.session;

import com.measuredsoftware.dagger2realworld.MainActivity;
import com.measuredsoftware.dagger2realworld.di.login.LogInComponent;
import com.measuredsoftware.dagger2realworld.di.login.LogInModule;

import dagger.Subcomponent;

/**
 * Created by neil.wilkinson on 20/06/2016.
 */
@Session
@Subcomponent(modules = SessionModule.class)
public interface SessionComponent {
    LogInComponent plus(LogInModule logInModule);

    void inject(MainActivity mainActivity);
}
